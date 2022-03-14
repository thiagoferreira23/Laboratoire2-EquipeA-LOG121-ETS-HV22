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
        while (iteJoueur.hasNext()) {
            lstJoueurParticipant[index] = iteJoueur.next();
            index++;
        }

        //METTRE LA LISTE DES JOUEURS EN ORDRE DECROISSANT PAR POINTS
        for (int i = 0; i < lstJoueurParticipant.length; i++) {
            for (int j = i + 1; j < lstJoueurParticipant.length; j++) {
                Joueur joueur = null;
                if (lstJoueurParticipant[i].compareTo(lstJoueurParticipant[j]) == -1) {
                    joueur = lstJoueurParticipant[i];
                    lstJoueurParticipant[i] = lstJoueurParticipant[j];
                    lstJoueurParticipant[j] = joueur;
                }
            }
        }
        jeu.getLstJoueurEnJeu().setLstJoueur(lstJoueurParticipant);
        return jeu.getLstJoueurEnJeu();
    }

    //METHODE POUR (TEST UNITAIRE)
    @Override
    public void calculerScoreTour(Jeu jeu) {
        Scanner sc = new Scanner(System.in);

        //CRÉE ITERATEUR POUR ROULER LES DES
        iterateurJoueur iteJoueur = jeu.getLstJoueurEnJeu().creerIterateur();

        //JOUEUR X JOUE UN TOUR
        while (iteJoueur.hasNext()) {
            //INITIALISE LE JOUEUR
            Joueur joueur = iteJoueur.next();
            boolean rejouerTour = true;

            //BOUCLE : REJOUE OU NON
            while (rejouerTour) {
                int point = 0;
                rejouerTour = false;

                //CRÉE ITERATEUR POUR ROULER LES DES
                iterateurDe iteDe = jeu.getLstDeEnJeu().creerIterateur();
                while (iteDe.hasNext()) {
                    int deJoue = iteDe.next().roulerDe();
                    if (deJoue == (jeu.getNumTour() + 1)) {
                        rejouerTour = true;
                        point++;
                    }
                }

                //TRIPLE : (AVEC BUNCO) OU (SANS BUNCO)
                if (((BuncoPlus) jeu).tripleCombinaison() == true) {
                    if (((BuncoPlus) jeu).buncoCombinaison() == true) {
                        rejouerTour = false;
                        point = 21;
                    }
                    else
                    {
                        rejouerTour = true;
                        point = 5;
                    }
                }
                joueur.ajouterPoints(point);
            }
        }
    }


    //METHODE POUR (AFFICHAGE)
    /*
    @Override
    public void calculerScoreTour(Jeu jeu) {
        Scanner sc = new Scanner(System.in);

        //CRÉE ITERATEUR POUR ROULER LES DES
        iterateurJoueur iteJoueur = jeu.getLstJoueurEnJeu().creerIterateur();

        //JOUEUR X JOUE UN TOUR
        while (iteJoueur.hasNext()) {
            //INITIALISE LE JOUEUR
            Joueur joueur = iteJoueur.next();
            boolean rejouerTour = true;

            //BOUCLE : REJOUE OU NON
            while (rejouerTour) {
                int point = 0;
                rejouerTour = false;

                //CRÉE ITERATEUR POUR ROULER LES DES
                iterateurDe iteDe = jeu.getLstDeEnJeu().creerIterateur();
                while (iteDe.hasNext()) {
                    int deJoue = iteDe.next().roulerDe();
                    if (deJoue == (jeu.getNumTour() + 1)) {
                        rejouerTour = true;
                        point++;
                    }
                }

                //SI ON OBTIENT UN (TRIPLE+BUNCO) OU (TRIPLE+SANSBUNCO)
                if (((BuncoPlus) jeu).tripleCombinaison() == true) {
                    if (((BuncoPlus) jeu).buncoCombinaison() == true) {
                        rejouerTour = false;
                        point = 21;
                    }
                    else
                    {
                        rejouerTour = true;
                        point = 5;
                    }
                }
                joueur.ajouterPoints(point);

                //AFFICHAGE DES RESULTAT PAR TOUR
                ((BuncoPlus) jeu).afficherResultatParTour(joueur, jeu, point);
                //AFFICHAGE DU MESS. APPRO. POUR X SITUATION
                if (rejouerTour == true) {
                    System.out.println("Relancer de nouveau!");
                } else {
                    System.out.println("Prochain joueur!");
                }
                sc.nextLine();
            }
        }
    }
    */


}
