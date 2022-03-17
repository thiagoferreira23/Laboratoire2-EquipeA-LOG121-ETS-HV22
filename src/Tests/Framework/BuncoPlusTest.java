package Framework;

import Bunco.BuncoPlus;
import Bunco.StrategieBuncoPlus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuncoPlusTest {

    static BuncoPlus jeuBunco;
    static StrategieBuncoPlus strategie;
    static iterateurDe iteDe;

    static int nbTour;
    @BeforeAll
    public static void initParametresParDefauts() {

        /*Création des instances de jeu avec les paramètres décrit dans l'ennoncé*/
        /* J<obtient la liste des joueurs*/

         jeuBunco = new BuncoPlus(2,3,6,3,new StrategieBuncoPlus());
         strategie = new StrategieBuncoPlus();
         iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();

        jeuBunco.setNumTour(1);
        nbTour = 2;

    }
    /* Le nombre de tour est initliser à 0. C'est la raison pour laquelle le nombre de tour qui est set est inférieur aux faces du dé.
   Cela nous permet d'avoir un nombre de tour égal aux faces des 3 dés.*/
    @DisplayName("Dans le cas où un joueur obtient trois chiffres identiques et égaux au numéro du tour, " +
            "le score calculé est 21 points et si le joueur passe la main au joueur suivant.")

    @Test
    public void testBunco_21Points(){
        jeuBunco.setNumTour(2);
        iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();
        boolean calculerScore = ((StrategieBuncoPlus)jeuBunco.getTypeStrategieCalcul()).calculerScoreTour(jeuBunco);


        while (iteDe.hasNext()){
            iteDe.next().setFaceJouer(3);
        }
        int  pointageJoueur = 0;
        if(calculerScore==false)
          pointageJoueur = ((StrategieBuncoPlus)jeuBunco.getTypeStrategieCalcul()).getPointParTours();
        //int pointageJoueur = jeuBunco.getTypeStrategieCalcul().
                assertEquals(21,pointageJoueur);


    }
    @Test
    public void testBunco_21Points_ChagementJouueur(){

    }
    @DisplayName("Dans le cas d'obtention de 3 chiffres identiques mais différents du numéro de tour si le score est de 5 points et le joueur garde la main.")
    @Test
    public void testBunco_5Points(){

    }
    @Test
    public void testBunco_5Points_MaintientJouueur(){

    }
    @DisplayName("Dans le cas d'obtention d'un seul chiffre correspondant au numéro de tour si le score est correct et si le joueur garde la main.")
    @Test
    public void testBunco_1Points(){

    }
    @Test
    public void testBunco_1Points_MaintientJouueur(){

    }

@DisplayName("Dans le cas d'obtention de 0 point si le joueur passe la main au joueur suivant.")
    @Test
    public void testBunco_0Points(){

    }

    @Test
    public void testBunco_0Points_ChagementJouueur(){

    }






    @Test
    public void verifierJoueurObtientTroisChiffresIdentiques(){
        iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();
        boolean triple = false;

        while (iteDe.hasNext()){
            iteDe.next().setFaceJouer(2);
        }
        assertTrue(jeuBunco.tripleCombinaison());

    }
    @DisplayName("Le cas ou un joueur n'obtient pas trois chiffres identiques.")
    @Test
    public void verifierJoueurObtientPasTroisChiffresIdentiques(){
        iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();
        boolean triple = false;

        int i = 0;
        while (iteDe.hasNext()){
            iteDe.next().setFaceJouer(i);
            i++;
        }
        assertFalse(jeuBunco.tripleCombinaison());

    }
    /* LE nombre de tour est initliser à 0. C'est la raison pour laquelle le nombre de tour qui est set est inférieur aux faces du dé.
    Cela nous permet d'avoir un nombre de tour égal aux faces des 3 dés.*/
    @DisplayName("Le score calcule est de 21 points")
    @Test
    public void scoreDe21Points(){
        jeuBunco.setNumTour(2);
        iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();
        boolean triple = false;


        while (iteDe.hasNext()){
            iteDe.next().setFaceJouer(3);
        }

           assertTrue(jeuBunco.buncoCombinaison());


    }
    @DisplayName("Vérifie que le joueur passe la main")
    @Test
    public void verifierQueLeJoueurPasseLaMain(){
        boolean binTourPassee = strategie.calculerScoreTour(jeuBunco);
        assertFalse(binTourPassee);

    }

    @DisplayName("Vérifie que le joueur garde la main")
    @Test
    public void verifierQueLeJoueurGardeLaMain(){
        boolean binTourPassee = strategie.calculerScoreTour(jeuBunco);
        assertTrue(!binTourPassee);

    }


    @Test
    public void verifierBuncoCombinaison(){




    }


    @Test
    public void calculerLeBonScoreDansUnTour(){



    }




}