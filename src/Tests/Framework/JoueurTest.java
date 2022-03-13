package Framework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>Cette classe permet d'effectuer des tests de la classe Joueur faisant
 * partie du paquet Framework. Dans cette classe de test JUnit, nous testerons
 * les constructeurs, les getters et setters, ainsi que les méthodes toString()
 * et compareTo().</p>
 *
 * @author Franco Huynh, Gabriel M. Borges & Thiago Ferreira
 * @version 1.0
 * @since 2022-03-13 11:16 a.m.
 */
class JoueurTest {

    //Joueur 1 - Instance d'un joueur vide sans aucun paramètre
    private static Joueur joueur1;

    //Jouer 2 - Instance d'un joueur qui est initialisé avec ses setters
    private static Joueur joueur2;

    //Jouer 3 - Instance d'un joueur qui est initialisé avec le constructeur
    private static Joueur joueur3;


    @BeforeAll
    public static void initParametresParDefauts() {

        /*Création des instances par défaut des objets Joueur
        avec leurs paramètres par défaut.*/

        joueur1 = new Joueur();
        joueur2 = new Joueur();
        joueur3 = new Joueur("Gabriel M. Borges", 652564, 10, false);

    }

    @Test
    @DisplayName("[Constructeur par défaut] Test du nom du joueur vide")
    void nomCompletParDefaut() {
        assertEquals("", joueur1.getNomComplet());
    }

    @Test
    @DisplayName("[Constructeur par défaut] Test de l'ID vide")
    void idParDefaut() {
        assertEquals(0, joueur1.getIdJoueur());
    }

    @Test
    @DisplayName("[Constructeur par défaut] Test des points du joueur vide")
    void pointsParDefaut() {
        assertEquals(0, joueur1.getPoints());
    }

    @Test
    @DisplayName("[Constructeur par défaut] Test du status du joueur vide")
    void statusParDefaut() {
        assertEquals(false, joueur1.getStatus());
    }

    @Test
    @DisplayName("[Joueur 2] Test du setter setNomComplet()")
    void testSetNomComplet() {
        joueur2.setNomComplet("Thiago Ferreira");
        assertEquals("Thiago Ferreira", joueur2.getNomComplet());
    }

    @Test
    @DisplayName("[Joueur 2] Test du setter setIdJoueur()")
    void testSetIDJoueur() {
        joueur2.setIdJoueur(254364);
        assertEquals(254364, joueur2.getIdJoueur());
    }

    @Test
    @DisplayName("[Joueur 2] Test du setter setPoints()")
    void testSetPoints() {
        joueur2.setPoints(18);
        assertEquals(18, joueur2.getPoints());
    }

    @Test
    @DisplayName("[Joueur 2] Test du setter setStatus()")
    void testSetStatus() {
        joueur2.setStatus(true);
        assertEquals(true, joueur2.getStatus());
    }

    @Test
    @DisplayName("[Joueur 3] Test du getter getNomComplet()")
    void testGetNomComplet() {
        assertEquals("Gabriel M. Borges", joueur3.getNomComplet());
    }

    @Test
    @DisplayName("[Joueur 3] Test du getter getIdJoueur()")
    void testGetIDJoueur() {
        assertEquals(652564, joueur3.getIdJoueur());
    }

    @Test
    @DisplayName("[Joueur 3] Test du getter getPoints()")
    void testGetPoints() {
        assertEquals(10, joueur3.getPoints());
    }

    @Test
    @DisplayName("[Joueur 3] Test du getter getStatus()")
    void testGetStatus() {
        assertEquals(false, joueur3.getStatus());
    }

    @Test
    @DisplayName("[Joueur 1] Test de la méthode toString()")
    void testToStringJoueur1() {
        assertEquals(", le Joueur 0 a obtenu 0 points",
                joueur1.toString());
    }

    @Test
    @DisplayName("[Joueur 2] Test de la méthode toString()")
    void testToStringJoueur2() {
        assertEquals("Thiago Ferreira, le Joueur 254364 " +
                "a obtenu 18 points", joueur2.toString());
    }

    @Test
    @DisplayName("[Joueur 3] Test de la méthode toString()")
    void testToStringJoueur3() {
        assertEquals("Gabriel M. Borges, le Joueur 652564 " +
                "a obtenu 10 points", joueur3.toString());
    }

    @Test
    @DisplayName("Test de la méthode compareTo | Points du joueur 2 " +
            "égal au joueur 3")
    void testCompareToPointsEgal() {
        joueur2.setPoints(joueur3.getPoints());
        assertEquals(0, joueur2.compareTo(joueur3));
    }

    @Test
    @DisplayName("Test de la méthode compareTo | Points du joueur 2 " +
            "sont plus grand que le joueur 3")
    void testCompareToPointsPlusGrand() {
        joueur2.setPoints(18);
        assertEquals(1, joueur2.compareTo(joueur3));
    }

    @Test
    @DisplayName("Test de la méthode compareTo | Points du joueur 2 " +
            "sont plus petit que le joueur 3 ou nous avons reçu le paramètre" +
            "par défaut de cette méthode")
    void testCompareToPointsPlusPetitOuParDefaut() {
        joueur2.setPoints(5);
        assertEquals(-1, joueur2.compareTo(joueur3));
    }
}