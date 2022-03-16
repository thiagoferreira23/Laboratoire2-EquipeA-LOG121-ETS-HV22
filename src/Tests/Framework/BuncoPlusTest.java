package Framework;

import Bunco.BuncoPlus;
import Bunco.StrategieBuncoPlus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuncoPlusTest {

    static BuncoPlus jeuBunco;
    static iterateurJoueur joueursQuiJouent;
    @BeforeAll
    public static void initParametresParDefauts() {

        /*Création des instances de jeu avec les paramètres décrit dans l'ennoncé*/
        /* J<obtient la liste des joueurs*/

         jeuBunco = new BuncoPlus(6,3,6,3,new StrategieBuncoPlus());
         joueursQuiJouent = jeuBunco.getLstJoueurEnJeu().creerIterateur();


    }

    @Test
    public void combinaison(){


    }
    @Test
    public void tripleCombinaison(){


    }

    @Test
    public void calculerLeBonScoreDansUnTour(){





    }




}