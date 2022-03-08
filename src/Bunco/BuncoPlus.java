package Bunco;

import Framework.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BuncoPlus extends TemplateJeuDe {
    private Jeu jeuBuncoPlus;

    public void initialiserJeu(int nbJoueur, int nbDeParJoueur, int nbFaceDe, int nbTour, IStrategie regleJeu){
        jeuBuncoPlus = new Jeu(nbTour);
        this.creerJoueur(nbJoueur);
        this.creerDe(nbFaceDe, nbDeParJoueur);
    }

    @Override
    public void creerJoueur(int nbDeJoueur) {
        CollectionJoueur<Joueur> lstNvJoueur = new CollectionJoueur<Joueur>(nbDeJoueur);
        for (int i = 0; i < nbDeJoueur; i++){
            lstNvJoueur.ajouterJoueur(new Joueur ("J"+(i+1), (i+1), 0, true));
        }
        jeuBuncoPlus.setLstJoueurEnJeu(lstNvJoueur);
    }

    @Override
    public void creerDe(int nbFaceDe, int nbDeParJoueur) {
        CollectionDe<De> lstNvDe =  new CollectionDe<De>(nbDeParJoueur);
        for (int i = 0; i < nbDeParJoueur; i++){
            lstNvDe.ajouterDe(new De (nbFaceDe));
        }
        jeuBuncoPlus.setLstDeEnJeu(lstNvDe);
    }

    @Override
    public void jouer(){
        Scanner sc = new Scanner(System.in);

        //DÉMARRER LA PARTIE
        System.out.println("Rouler les dés...");
        String demarrerJeu = sc.nextLine();

        //CRÉER TABLEAU POUR DÉS JOUÉS
        iterateurDe iteDe = jeuBuncoPlus.getIteDe();
        int[] lstValeurDe = new int[iteDe.size()];

        //AFFICHER RÉSULTAT DES DÉS PAR TOUR
        while (jeuBuncoPlus.getNumTour() != jeuBuncoPlus.getNbTour()){
            iteDe = jeuBuncoPlus.getIteDe();
            int i = 0;
            while (iteDe.hasNext()){
                lstValeurDe[i] = iteDe.next().roulerDe();
                i++;
            }
            calculerScoreTour();
            afficherResultatParTour(lstValeurDe);
            jeuBuncoPlus.incrementerTour();
            System.out.println("Prochain tour...");
            String continuerJeu = sc.nextLine();
        }

    }

    //CALCULER POINTS PAR TOUR
    public void calculerScoreTour(){

    }

    //AFFICHAGE DES RESULTATS
    public void afficherResultatParTour(int[] lstValeurDe){
        System.out.println("========================");
        System.out.println("    NUMÉRO DE TOUR     ");
        System.out.println("       JOUEUR #X     ");
        System.out.print("======================== \n \n");
        System.out.print("DÉS JOUÉS : ");
        for (int i = 0; i < lstValeurDe.length; i++){
            System.out.print(lstValeurDe[i] + " ");
        }
        System.out.print("\n");
        System.out.println("---------------");
        System.out.println("POINTS : X");
        System.out.println("---------------");
        System.out.println("\n");
    }

}
