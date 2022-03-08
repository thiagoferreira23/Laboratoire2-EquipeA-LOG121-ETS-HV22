package Tests;

import Bunco.BuncoPlus;
import Framework.*;

import java.util.ArrayList;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:26 a.m.
 */
public class TestJoueurs {

    public static void main(String[] args) {
        /* Joueur j1 = new Joueur();
        j1.setNomComplet("Thiago");
        j1.setPoints(27);
        j1.setStatus(true);
        Joueur j2 = new Joueur("Gabriel",5,20,true);
        //System.out.println(j1);
        //System.out.println(j2);
        CollectionJoueur<Joueur> coll = new CollectionJoueur<Joueur>(2);
        coll.ajouterJoueur(new Joueur("Franco", 1, 0, false));
        coll.ajouterJoueur(new Joueur("Thiago", 2, 0, false));
        coll.ajouterJoueur(new Joueur("Gab", 3, 0, false));
        iterateurJoueur iteJoueur = coll.creerIterateur();
        ArrayList<Joueur> testlstJoueur = new ArrayList<Joueur>();
        while (iteJoueur.hasNext())
            testlstJoueur.add(iteJoueur.next());
        System.out.println(testlstJoueur.get(0).getNomComplet());
        De de = new De(6);
        de.roulerDe();
        System.out.println(de.getFaceJouer());
        System.out.println("p"+1);
        //de.affichageTab();*/

        //Test Bunco+
        BuncoPlus buncoPlus = new BuncoPlus();
        buncoPlus.initialiserJeu(1,3,6,2,new StrategieBunco());
        buncoPlus.calculerScoreTour();





    }


}
