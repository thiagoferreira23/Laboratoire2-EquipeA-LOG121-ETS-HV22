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
        System.out.println("Rouler les dés...");
        String demarrerJeu = sc.nextLine();

        //CRÉER TABLEAU POUR DÉS JOUÉS
        iterateurDe iteDe = this.getIteDe();
        int[] lstValeurDeEnJeu = new int[iteDe.size()];

        //AFFICHER RÉSULTAT DES DÉS PAR TOUR
        int pointage = 0;
        while (this.getNumTour() != this.getNbTour()) {
            boolean pointGagne = true;
            while (pointGagne == true){
                pointGagne = false;

                iteDe = this.getIteDe();
                int index = 0;
                while (iteDe.hasNext()) {
                    lstValeurDeEnJeu[index] = iteDe.next().roulerDe();
                    if (lstValeurDeEnJeu[index] == this.getNumTour()+1){
                        pointGagne = true;
                    }
                    index++;
                }
                calculerScoreTour();
                if (pointGagne == true){
                    System.out.println("Relancer de nouveau!");
                    String continuerJeu = sc.nextLine();
                }
            }

            //IMPLÉMENTER LE SYSTEME LOOP POUR AFFICHER
            //afficherResultatParTour(lstValeurDeEnJeu, pointageEnJeu);
            this.incrementerTour();
            System.out.println("Prochain tour...");
            String continuerJeu = sc.nextLine();
        }
    }

    //AFFICHAGE DES RÉSULTATS
    public void afficherResultatParTour(int[] lstValeurDe, int pointage) {
        System.out.println("========================");
        System.out.println("    NUMÉRO DE TOUR     ");
        System.out.println("       JOUEUR #X     ");
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
}
