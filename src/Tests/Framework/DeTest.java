package Framework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeTest {

    private static De de; //Test des valeurs par défaut du constructeur
    private static De de1; // Test des valeurs avec un dé où on set la valeur à chaque test

    @BeforeAll
    public static void initParDefaut() {
        de = new De();
        de1 = new De();
    }

    @Test
    @DisplayName("Taille du nb de faces lors de la création d'un " +
            "nouveau dé sans paramètres")
    void testDeNouveau() {
        assertEquals(0, de.getNbFacesDe());
    }

    @Test
    @DisplayName("Taille du tableau lors de la création d'un " +
            "nouveau dé sans paramètres")
    void testTableauDeNouveau() {
        assertEquals(0, de.getaDe().length);
    }

    @Test
    @DisplayName("Vérification du Setter")
    void testRemplissageDe6Faces() {
        de1.setNbFacesDe(6);
        assertEquals(6, de1.getNbFacesDe());
    }

    @Test
    @DisplayName("Vérification du remplissage du tableau")
    void testRemplissageTableau() {
        de1.setaDe(new int[6]);
        de1.remplissageDe(de1.getaDe());

        assertEquals(6, de1.getaDe().length);
    }


    @Test
    public void memeDeTest() {
        de1.setNbFacesDe(4);
        assertEquals(0, de1.compareTo(de1));
    }

    @Test
    void roulerDe() {
        de1.setNbFacesDe(3);
        assertTrue(de1.roulerDe() > 0);
    }
}