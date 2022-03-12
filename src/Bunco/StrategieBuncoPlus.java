package Bunco;

import Bunco.BuncoPlus;
import Framework.*;

import java.util.Collection;
import java.util.Scanner;

public class StrategieBuncoPlus implements IStrategie {
    @Override
    public CollectionJoueur calculerLeVainqueur(Jeu jeu) {
        iterateurJoueur iteJoueur = jeu.getLstJoueurEnJeu().creerIterateur();
        Joueur[] lstJoueurParticipant = new Joueur[iteJoueur.size()];

        //INSERER LES JOUEURS DANS UN TABLEAU
        iteJoueur = jeu.getLstJoueurEnJeu().creerIterateur();
        int index = 0;
        while (iteJoueur.hasNext()){
            lstJoueurParticipant[index] = iteJoueur.next();
            index++;
        }

        //METTRE LA LISTE DES JOUEURS EN ORDRE DECROISSANT PAR POINTS
        for (int i = 0; i < lstJoueurParticipant.length; i++){
            for (int j = i+1; j < lstJoueurParticipant.length; j++){
                Joueur joueur = null;
                if (lstJoueurParticipant[i].compareTo(lstJoueurParticipant[j]) == -1)
                {
                    joueur = lstJoueurParticipant[i];
                    lstJoueurParticipant[i] = lstJoueurParticipant[j];
                    lstJoueurParticipant[j] = joueur;
                }
            }
        }
        jeu.getLstJoueurEnJeu().setLstJoueur(lstJoueurParticipant);
        return jeu.getLstJoueurEnJeu();
    }


    @Override
    public void calculerScoreTour(Jeu jeu) {
        iterateurDe iteDe = jeu.getLstDeEnJeu().creerIterateur();
        int point = 0;
        while (iteDe.hasNext()){
            int chiffreJoue = iteDe.next().getFaceJouer();
            if (jeu.getNumTour()+1 == chiffreJoue){
                point++;
            }
        }
        if (((BuncoPlus)jeu).tripleCombinaison() == true){
            point = 5;
        }
        if (((BuncoPlus)jeu).buncoCombinaison() == true){
            point = 21;
        }
        jeu.setPointageParTour(point);
    }

    /* COMPLETER LA METHODE CALCULER SCORETOUR SELON LES CALCULSCORE TOUR EN HAUT
    //METHODE POUR JOUER LE JEU
    public void calculerScoreTour(Jeu jeu) {
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
    */
}
