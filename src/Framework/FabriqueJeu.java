package Framework;

import Bunco.BuncoPlus;
import Bunco.StrategieBuncoPlus;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:26 a.m.
 */
public class FabriqueJeu {
    public void initialiserJeu(int nbJoueur, int nbDeParJoueur, int nbFaceDe, int nbTour, IStrategie regleJeu) {

    }

    public void creerJoueur(int nbJoueur) {

    }

    public void creerDe(int nbFaceDe, int nbDeParJoueur) {

    }

    public void jouer() {

    }

    public final void creerJeuBunco(int nbJoueur, int nbDeParJoueur, int nbFaceDe, int nbTour, IStrategie regleJeu) {
        initialiserJeu(nbJoueur, nbDeParJoueur, nbFaceDe, nbTour, regleJeu);
        creerJoueur(nbJoueur);
        creerDe(nbFaceDe, nbDeParJoueur);
        jouer();
    }


    public static void main(String[] args) {



        BuncoPlus jeuBunco = new BuncoPlus(6,3,6,3,new StrategieBuncoPlus());

        jeuBunco.jouer();


        iterateurJoueur joueursQuiJouent = jeuBunco.getLstJoueurEnJeu().creerIterateur();

        while (joueursQuiJouent.hasNext()) {
            Joueur joueur = joueursQuiJouent.next();
          //  System.out.println(joueur.getNomComplet() + " : " + joueur.getPoints() + " POINTS");
            jeuBunco.afficherResultatParTour(joueur,jeuBunco,joueur.getPoints());
        }



        jeuBunco.afficherResultatFinal();




    }
}