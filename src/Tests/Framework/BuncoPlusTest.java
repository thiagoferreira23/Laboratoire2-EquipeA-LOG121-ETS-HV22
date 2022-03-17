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

        jeuBunco = new BuncoPlus(1, 3, 6, 3, new StrategieBuncoPlus());
        strategie = new StrategieBuncoPlus();
        iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();

        jeuBunco.setNumTour(1);

    }

    @DisplayName("Dans le cas où un joueur obtient trois chiffres identiques et égaux au numéro du tour, " +
            "le score calculé est 21 points et si le joueur passe la main au joueur suivant.")
    @Test
    public void testBunco_21Points() {
        jeuBunco.setNumTour(3);
        iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();
        while (iteDe.hasNext()) {
            iteDe.next().setFaceJouer(3);
        }
        jeuBunco.calculerScoreTour();
        int point = ((StrategieBuncoPlus) jeuBunco.getTypeStrategieCalcul()).getPointParTours();

        assertEquals(21, point);
    }

    @Test
    public void testBunco_21Points_ChangementJoueur() {
        jeuBunco.setNumTour(3);
        iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();
        while (iteDe.hasNext()) {
            iteDe.next().setFaceJouer(3);
        }
        boolean joueurRejoue = jeuBunco.getTypeStrategieCalcul().calculerScoreTour(jeuBunco);
        assertFalse(joueurRejoue);
    }

    @DisplayName("Dans le cas d'obtention de 3 chiffres identiques mais différents du numéro de tour si le score est de 5 points et le joueur garde la main.")
    @Test
    public void testBunco_5Points() {
        jeuBunco.setNumTour(2);
        iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();
        while (iteDe.hasNext()) {
            iteDe.next().setFaceJouer(3);
        }
        jeuBunco.calculerScoreTour();
        int point = ((StrategieBuncoPlus) jeuBunco.getTypeStrategieCalcul()).getPointParTours();

        assertEquals(5, point);
    }

    @Test
    public void testBunco_5Points_MaintientJouueur() {
        jeuBunco.setNumTour(2);
        iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();
        while (iteDe.hasNext()) {
            iteDe.next().setFaceJouer(3);
        }
        boolean joueurRejoue = jeuBunco.getTypeStrategieCalcul().calculerScoreTour(jeuBunco);
        assertTrue(joueurRejoue);
    }

    @DisplayName("Dans le cas d'obtention d'un seul chiffre correspondant au numéro de tour si le score est correct et si le joueur garde la main.")
    @Test
    public void testBunco_1Points() {
        jeuBunco.setNumTour(1);
        iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();
        int i = 1;
        while (iteDe.hasNext()) {
            iteDe.next().setFaceJouer(i);
            i++;
        }
        jeuBunco.calculerScoreTour();
        int point = ((StrategieBuncoPlus) jeuBunco.getTypeStrategieCalcul()).getPointParTours();

        assertEquals(1, point);
    }

    @Test
    public void testBunco_1Points_MaintientJouueur() {
        jeuBunco.setNumTour(1);
        iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();
        int i = 1;
        while (iteDe.hasNext()) {
            iteDe.next().setFaceJouer(i);
            i++;
        }
        boolean joueurRejoue = jeuBunco.getTypeStrategieCalcul().calculerScoreTour(jeuBunco);
        assertTrue(joueurRejoue);
    }

    @DisplayName("Dans le cas d'obtention de 0 point si le joueur passe la main au joueur suivant.")
    @Test
    public void testBunco_0Points() {
        jeuBunco.setNumTour(1);
        iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();
        int i = 2;
        while (iteDe.hasNext()) {
            iteDe.next().setFaceJouer(i);
            i++;
        }
        jeuBunco.calculerScoreTour();
        int point = ((StrategieBuncoPlus) jeuBunco.getTypeStrategieCalcul()).getPointParTours();

        assertEquals(0, point);
    }

    @Test
    public void testBunco_0Points_ChagementJouueur() {
        jeuBunco.setNumTour(1);
        iteDe = jeuBunco.getLstDeEnJeu().creerIterateur();
        int i = 2;
        while (iteDe.hasNext()) {
            iteDe.next().setFaceJouer(i);
            i++;
        }
        boolean joueurRejoue = jeuBunco.getTypeStrategieCalcul().calculerScoreTour(jeuBunco);
        assertFalse(joueurRejoue);
    }

    @DisplayName("Chercher le vainqueur d'une fin de partie selon leur nombre de points")
    @Test
    public void testVainqueur() {
        Joueur J1 = new Joueur("Franco H.", 1, 0, true);
        Joueur J2 = new Joueur("Thiago F.", 2, 0, true);
        Joueur J3 = new Joueur("Gabriel M.", 3, 0, true);
        J1.setPoints(12);
        J2.setPoints(22);
        J3.setPoints(43);
        Joueur[] lstJoueur = {J1, J2, J3};
        jeuBunco.getLstJoueurEnJeu().setLstJoueur(lstJoueur);
        jeuBunco.calculerLeVainqueur(); //Classer ordre decroissant
        iterateurJoueur iteLstJoueur = jeuBunco.getLstJoueurEnJeu().creerIterateur();
        Joueur vainqueurPredefinis = J3; //Predefinir J3 comme gagnant avec 43 points
        Joueur vainqueurDefinis =iteLstJoueur.next();
        assertEquals(vainqueurPredefinis, vainqueurDefinis); //Meme Joueur (Predefinis et definis)
        assertEquals(0, vainqueurPredefinis.compareTo(vainqueurDefinis)); ///Egalite dans les 2 scores
    }

    @DisplayName("Classement Final")
    @Test
    public void testClassement() {
        Joueur J1 = new Joueur("Franco H.", 1, 0, true);
        Joueur J2 = new Joueur("Thiago F.", 2, 0, true);
        Joueur J3 = new Joueur("Gabriel M.", 3, 0, true);
        J1.setPoints(12);
        J2.setPoints(22);
        J3.setPoints(43);
        Joueur[] lstJoueur = {J1, J2, J3};
        jeuBunco.getLstJoueurEnJeu().setLstJoueur(lstJoueur);
        jeuBunco.calculerLeVainqueur(); //Classer ordre decroissant
        iterateurJoueur iteLstJoueur = jeuBunco.getLstJoueurEnJeu().creerIterateur();
        Joueur[] lstClassementDecroissantPredefinis = {J3, J2, J1}; //Predefinir J3 comme gagnant avec 43 points
        Joueur[] lstClassementDecroissantDefinis = jeuBunco.getLstJoueurEnJeu().getLstJoueur();
        assertEquals(lstClassementDecroissantPredefinis.length, lstClassementDecroissantDefinis.length); //Verifie la grandeur des tableaux
        assertArrayEquals(lstClassementDecroissantPredefinis, lstClassementDecroissantDefinis); //Verifie l'ordre et le contenue des tableaux
    }
}