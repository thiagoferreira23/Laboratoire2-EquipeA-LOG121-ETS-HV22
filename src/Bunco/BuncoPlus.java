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
    public boolean buncoCombinaison(){
        iterateurDe ite = this.getLstDeEnJeu().creerIterateur();
        int deJoue = ite.next().getFaceJouer();
        if (tripleCombinaison() == true){
            if (deJoue == this.getNumTour()+1){
                return true;
            }
            else
                return false;
        }
        return false;
    }
    public boolean tripleCombinaison(){
        iterateurDe iteDe = this.getLstDeEnJeu().creerIterateur();
        //STOCK LA VALEUR DU DÉ SIMILAIRE
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
            }
        }
        return triple;
    }


    //METHODE POUR JOUER LE JEU
    public void jouer() {
        Scanner sc = new Scanner(System.in);

        //DÉMARRER LA PARTIE
        System.out.println("Commencer la partie...");
        sc.nextLine();

        //AFFICHER RÉSULTAT DES DÉS PAR TOUR
        while (this.getNumTour() != this.getNbTour()) {
            //CRÉER TABLEAU POUR LES JOUEURS
            iterateurJoueur iteJoueur = this.getLstJoueurEnJeu().creerIterateur();

            //JOUEUR X JOUE UN TOUR
            while (iteJoueur.hasNext()) {
                Joueur joueur = iteJoueur.next();
                boolean rejouerTour = true;
                while (rejouerTour) {
                    rejouerTour = false;
                    //CRÉER TABLEAU POUR DÉS JOUÉS
                    iterateurDe iteDe = this.getLstDeEnJeu().creerIterateur();
                    while (iteDe.hasNext()) {
                        iteDe.next().roulerDe();
                    }

                    if (tripleCombinaison() == true) {
                        rejouerTour = true;
                    }
                    System.out.println(rejouerTour);

                    //SI ON OBTIENT UN TRIPLE MAIS DIFFERENT NUM.TOUR
                    if (tripleCombinaison() == false) {
                        //SI UNE FACE DE DE EQUIVALENT AU NUM. TOUR
                        iteDe = this.getLstDeEnJeu().creerIterateur();
                        while (iteDe.hasNext()) {
                            if (iteDe.next().getFaceJouer() == (this.getNumTour() + 1)) {
                                rejouerTour = true;
                            }
                        }
                    }

                    //SI ON OBTIENT UN TRIPLE + BUNCO
                    if (tripleCombinaison() == true) {
                        if (buncoCombinaison() == true){
                            rejouerTour = false;
                        }
                    }
                    calculerScoreTour();
                    joueur.setPoints(joueur.getPoints() + this.getPointageParTour());
                    afficherResultatParTour(joueur, this);
                    if (rejouerTour == true) {
                        System.out.println("Relancer de nouveau!");
                    } else {
                        System.out.println("Prochain joueur!");
                        if (buncoCombinaison() == true){
                            rejouerTour = false;
                        }
                    }
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
    public void afficherResultatParTour(Joueur joueur, Jeu buncoplus) { //int numTour, int idJoueur, int[] lstValeurDe, int pointage
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
