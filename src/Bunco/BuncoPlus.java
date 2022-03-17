package Bunco;

import Framework.*;

import java.util.Random;
import java.util.Scanner;

public class BuncoPlus extends Jeu {

    public BuncoPlus(int nbTourPourJeu, int nbDeJoueur, int nbFaceDe, int nbDeParJoueur, IStrategie typeStrategieCalcul) {
        super(nbTourPourJeu, nbDeJoueur, nbFaceDe, nbDeParJoueur, typeStrategieCalcul);
    }

    //CALCUL DES POINTS ET VAINQUEUR
    @Override
    public void calculerScoreTour() {
        this.getTypeStrategieCalcul().calculerScoreTour(this);
    }

    @Override
    public void calculerLeVainqueur() {
        this.getTypeStrategieCalcul().calculerLeVainqueur(this);
    }

    //LISTE DES COMBINAISONS POSSIBLE POUR JEU BUNCO

    //COMBINAISON BUNCO
    public boolean buncoCombinaison(){
        iterateurDe ite = this.getLstDeEnJeu().creerIterateur();
        int deJoue = ite.next().getFaceJouer();
        if (tripleCombinaison() == true){
            if (deJoue == this.getNumTour()){
                return true;
            }
            else
                return false;
        }
        return false;
    }
    //COMBINAISON TRIPLE
    public boolean tripleCombinaison(){
        iterateurDe iteDe = this.getLstDeEnJeu().creerIterateur();
        //STOCK LA PREMIERE VALEUR DE LA LISTE
        int valeurDeSimilaire = 0;
        while (iteDe.hasNext()) {
            valeurDeSimilaire = iteDe.next().getFaceJouer();
        }

        boolean triple = false;
        iteDe = this.getLstDeEnJeu().creerIterateur();
        while (iteDe.hasNext()) {
            if (iteDe.next().getFaceJouer() == valeurDeSimilaire) {
                triple = true;
            } else {
                triple = false;
                break;
            }
        }
        return triple;
    }

    //METHODE JOUER (TEST UNITAIRE)
    public void jouer() {
        //AFFICHER RÉSULTAT DES DÉS PAR TOUR
        while (this.getNumTour() != this.getNbTour()) {
            this.calculerScoreTour();
            this.incrementerTour();
        }
    }
    /*
    //METHODE JOUER (AFFICHAGE)
    public void jouer() {
        Scanner sc = new Scanner(System.in);

        //DÉMARRER LA PARTIE
        System.out.println("Commencer la partie...");
        sc.nextLine();

        //AFFICHER RÉSULTAT DES DÉS PAR TOUR
        while (this.getNumTour() != this.getNbTour()) {
            this.calculerScoreTour();
            this.incrementerTour();
            System.out.println("\n");
            System.out.println("Prochain tour...");

            //PASSER PROCHAIN TOUR
            sc.nextLine();
        }
        System.out.println("\n \n");
        afficherResultatFinal();
    }
    */

    //METHODES POUR TESTER LES DONNES (PAS NECESSAIRE)
    //AFFICHAGE DES RÉSULTATS
    public void afficherResultatParTour(Joueur joueur, Jeu buncoplus, int pointTour) { //int numTour, int idJoueur, int[] lstValeurDe, int pointage
        iterateurDe iterateurDe = buncoplus.getLstDeEnJeu().creerIterateur();
        System.out.println("========================");
        System.out.println("        TOUR " + (buncoplus.getNumTour() + 1));
        System.out.println("       JOUEUR " + joueur.getIdJoueur());
        System.out.print("======================== \n \n");
        System.out.print("DÉS JOUÉS : ");
        while (iterateurDe.hasNext()) {
            System.out.print(iterateurDe.next().getFaceJouer() + " ");
        }
        System.out.print("\n");
        System.out.println("---------------");
        System.out.println("POINTS : " + pointTour);
        System.out.println("---------------");
        System.out.println("\n");
    }

    //AFFICHAGE DES RÉSULTATS FINALS
    public void afficherResultatFinal() {
        iterateurJoueur iteJoueur = this.getLstJoueurEnJeu().creerIterateur();
        System.out.println("=========================");
        System.out.println("         BUNCO+ ");
        System.out.println("    CLASSEMENT FINALE ");
        System.out.print("========================= \n \n");
        while (iteJoueur.hasNext()) {
            Joueur joueur = iteJoueur.next();
            System.out.println(joueur.getNomComplet() + " : " + joueur.getPoints() + " POINTS");
        }
        iteJoueur = this.getLstJoueurEnJeu().creerIterateur();
        System.out.print("\n");
        System.out.println("VAINQUEUR : " + iteJoueur.next());
        System.out.println("---------------");
        System.out.println("\n");
    }
}
