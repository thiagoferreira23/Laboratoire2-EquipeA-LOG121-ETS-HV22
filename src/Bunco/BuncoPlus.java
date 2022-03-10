package Bunco;

import Framework.*;

import java.util.Random;
import java.util.Scanner;

public class BuncoPlus extends Jeu {


    public BuncoPlus(int nbTourPourJeu, int nbDeJoueur, int nbFaceDe, int nbDeParJoueur, IStrategie typeStrategieCalcul) {
        super(nbTourPourJeu, nbDeJoueur, nbFaceDe, nbDeParJoueur, typeStrategieCalcul);
    }

    @Override
    public void calculerScoreTour() {
        this.getTypeStrategieCalcul().calculerScoreTour(this);
    }

    @Override
    public void calculerLeVainqueur() {
        this.getTypeStrategieCalcul().calculerLeVainqueur(this);
    }

    public void jouer(){
        Scanner sc= new Scanner(System.in);

        //DÉMARRER LA PARTIE
        System.out.println("Commencer la partie...");
        sc.nextLine();

        //AFFICHER RÉSULTAT DES DÉS PAR TOUR
        while (this.getNumTour() != this.getNbTour()) {
            //CRÉER TABLEAU POUR LES JOUEURS
            iterateurJoueur iteJoueur = this.getLstJoueurEnJeu().creerIterateur();

            //CRÉER TABLEAU POUR DÉS JOUÉS
            iterateurDe iteDe = this.getLstDeEnJeu().creerIterateur();
            int[] lstValeurDeEnJeu = new int[iteDe.size()];
            //JOUEUR X JOUE UN TOUR
            while (iteJoueur.hasNext()) {
                Joueur joueur = iteJoueur.next();
                boolean faceDeEqTour = true;
                boolean tripleDe = true;
                boolean bunco = false;
                while (faceDeEqTour || tripleDe) {
                    //REINITIALISER LES VALEURS DES COMBINAISONS
                    faceDeEqTour = false;
                    tripleDe = false;

                    System.out.println("111111111");
                    //INSERER LA LISTE DES DES
                    iteDe = this.getLstDeEnJeu().creerIterateur();
                    int index = 0;
                    /* while (iteDe.hasNext()) {
                        lstValeurDeEnJeu[index] = iteDe.next().roulerDe();
                        if (lstValeurDeEnJeu[index] == (this.getNumTour() + 1)) {
                            faceDeEqTour = true;
                        }
                        index++;
                    } */

                    //SI UNE FACE DE DE EQUIVALENT AU NUM. TOUR
                    while (iteDe.hasNext()) {
                        if (iteDe.next().roulerDe() == (this.getNumTour() + 1)) {
                            faceDeEqTour = true;
                        }
                    }

                    //SI ON OBTIENT UN TRIPLE MAIS DIFFERENT NUM.TOUR
                    //SI BUNCO

                    calculerScoreTour();
                    joueur.setPoints(joueur.getPoints() + this.getPointageParTour());
                    afficherResultatParTour(joueur, this);
                    if (faceDeEqTour == true) {
                        System.out.println("Relancer de nouveau!");
                    }
                    else {
                        System.out.println("Prochain joueur!");
                    }

                    //RELANCER OU PASSER PROCHAIN JOUEUR
                    sc.nextLine();
                }
            }
            this.incrementerTour();
            System.out.println("\n");
            System.out.println("Prochain tour...");

            //PASSER PROCHAIN TOUR
            sc.nextLine();
        }
        System.out.println("\n \n");
        afficherResultatFinal();
    }


    //METHODES POUR TESTER LES DONNES (PAS NECESSAIRE)
    //AFFICHAGE DES RÉSULTATS
    public void afficherResultatParTour(Joueur joueur, Jeu buncoplus){ //int numTour, int idJoueur, int[] lstValeurDe, int pointage
        iterateurDe iterateurDe = buncoplus.getLstDeEnJeu().creerIterateur();
        System.out.println("========================");
        System.out.println("        TOUR " + (buncoplus.getNumTour() + 1));
        System.out.println("       JOUEUR " + joueur.getIdJoueur());
        System.out.print("======================== \n \n");
        System.out.print("DÉS JOUÉS : ");
        while (iterateurDe.hasNext()){
            System.out.print(iterateurDe.next().getFaceJouer() + " ");
        }
        System.out.print("\n");
        System.out.println("---------------");
        System.out.println("POINTS : " + buncoplus.getPointageParTour());
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
