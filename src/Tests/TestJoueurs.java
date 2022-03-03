package Tests;

import Framework.De;
import Framework.Joueur;

/**
 * <p>Description de la classe</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-02-24 9:26 a.m.
 */
public class TestJoueurs {



    public static void main(String[] args) {
        Joueur j1 = new Joueur();
        j1.setNomComplet("Thiago");
        j1.setPoints(27);
        j1.setStatus(true);

        Joueur j2 = new Joueur("Gabriel",5,20,true);
        //System.out.println(j1);
     //   System.out.println(j2);

        De de = new De(4);


        de.affichageTab();




    }


}
