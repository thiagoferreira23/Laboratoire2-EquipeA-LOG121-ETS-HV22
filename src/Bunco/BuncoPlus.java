package Bunco;

import Framework.*;

import java.util.Scanner;

public class BuncoPlus extends Jeu {

    public BuncoPlus(int nbTourPourJeu, int nbDeJoueur, int nbFaceDe, int nbDeParJoueur, IStrategie strategyCalculer) {
        super(nbTourPourJeu, nbDeJoueur, nbFaceDe, nbDeParJoueur, strategyCalculer);
    }

    @Override
    public void calculerScoreTour() {
        this.getTypeStrategieCalcul().calculerScoreTour(this);
    }

    @Override
    public void calculerLeVainqueur() {
        this.getTypeStrategieCalcul().calculerLeVainqueur(this);
    }

    @Override
    public void jouer() {
        Scanner sc = new Scanner(System.in);

        //DÉMARRER LA PARTIE
        System.out.println("Commencer la partie...");
        String demarrerJeu = sc.nextLine();

        //AFFICHER RÉSULTAT DES DÉS PAR TOUR
        int pointage = 0;
        while (this.getNumTour() != this.getNbTour()) {
            //CRÉER TABLEAU POUR LES JOUEURS
            iterateurJoueur iteJoueur = this.getLstJoueurEnJeu().creerIterateur();

            //CRÉER TABLEAU POUR DÉS JOUÉS
            iterateurDe iteDe = this.getLstDeEnJeu().creerIterateur();
            int[] lstValeurDeEnJeu = new int[iteDe.size()];

            //JOUEUR X JOUE UN TOUR
            while (iteJoueur.hasNext()) {
                Joueur joueur = iteJoueur.next();
                boolean pointGagne = true;
                while (pointGagne == true) {
                    pointGagne = false;

                    iteDe = this.getLstDeEnJeu().creerIterateur();
                    int index = 0;
                    while (iteDe.hasNext()) {
                        lstValeurDeEnJeu[index] = iteDe.next().roulerDe();
                        if (lstValeurDeEnJeu[index] == this.getNumTour() + 1) {
                            pointGagne = true;
                        }
                        index++;
                    }
                    calculerScoreTour();
                    joueur.setPoints(joueur.getPoints() + this.getPointageParTour());
                    afficherResultatParTour(this.getNumTour(), joueur.getIdJoueur(), lstValeurDeEnJeu, this.getPointageParTour());
                    if (pointGagne == true) {
                        System.out.println("Relancer de nouveau!");
                    }
                    else {
                        System.out.println("Prochain joueur!!");
                    }
                    String continuerJeu = sc.nextLine();
                }
            }
            this.incrementerTour();
            System.out.println("\n");
            System.out.println("Prochain tour...");
            String continuerJeu = sc.nextLine();
        }
        System.out.println("\n \n");
        afficherResultatFinal();
    }


    //METHODES POUR TESTER LES DONNES (PAS NECESSAIRE)
    //AFFICHAGE DES RÉSULTATS
    public void afficherResultatParTour(int numTour, int idJoueur, int[] lstValeurDe, int pointage) {
        System.out.println("========================");
        System.out.println("        TOUR " + (numTour + 1));
        System.out.println("       JOUEUR " + idJoueur);
        System.out.print("======================== \n \n");
        System.out.print("DÉS JOUÉS : ");
        for (int i = 0; i < lstValeurDe.length; i++) {
            System.out.print(lstValeurDe[i] + " ");
        }
        System.out.print("\n");
        System.out.println("---------------");
        System.out.println("POINTS : " + pointage);
        System.out.println("---------------");
        System.out.println("\n");
    }

    //AFFICHAGE DES RÉSULTATS
    public void afficherResultatFinal() {
        iterateurJoueur iteJoueur = this.getLstJoueurEnJeu().creerIterateur();
        System.out.println("=========================");
        System.out.println("         BUNCO+ ");
        System.out.println("    CLASSEMENT FINALE ");
        System.out.print  ("========================= \n \n");
        while (iteJoueur.hasNext()){
            Joueur joueur = iteJoueur.next();
            System.out.println(joueur.getNomComplet() + " : " + joueur.getPoints() + " POINTS");
        }
        System.out.print("\n");
        System.out.println("---------------");
        System.out.println("\n");
    }
}
