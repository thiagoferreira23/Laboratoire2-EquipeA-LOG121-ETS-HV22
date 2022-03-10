package Bunco;

import Framework.*;

import java.util.Random;

public class BuncoPlus extends TemplateJeuDe {
    private Jeu jeuBuncoPlus;

    @Override
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

    public void jouerUnTour(){
        //GET NOMBRE DE DICE PAR TOUR
        iterateurDe iteDe = jeuBuncoPlus.getIteDe();

        System.out.println("Rouler les dés...");
        System.out.println("Résultat : ");

        //FAIRE AFFICHER LES VALEURS DES DÉS
        while (iteDe.hasNext()){
            iteDe.next().roulerDe();
            System.out.print(iteDe.next().getFaceJouer()+ " ");
        }

    }

}
