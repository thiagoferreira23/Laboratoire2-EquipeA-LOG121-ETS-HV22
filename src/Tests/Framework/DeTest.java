package Framework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeTest {
    @Test
    void testRemplissageDe6Faces(){
        De de = new De(6);
        assertEquals(6, de.getNbFacesDe());
    }
    @Test
    void testRoulerDe(){
        De de = new De(6);

    }

}