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

    private static Joueur joueur1;
    private static Joueur joueur2;
    private static Joueur joueur3;


    @BeforeAll
    public static void initParametresParDefauts(){

        /*Création des instances par défaut des objets Joueur
        avec leurs paramètres par défaut.*/

        joueur1 = new Joueur();
        joueur2 = new Joueur();
        joueur3 = new Joueur();

    }

    @Test
    @DisplayName("")
    void test123(){

    }

}