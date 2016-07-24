package exercises.Chapter1_2;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 09-07-2016.
 */
public class Exc_1_2_6_CircularRotationTest {

    @org.junit.Test
    public void testIsCircularRotation() {
        Exc_1_2_6_CircularRotation cr = new Exc_1_2_6_CircularRotation();
        assertTrue(cr.isCircularRotation("test", "stte"));
        assertTrue(cr.isCircularRotation("a", "a"));
        assertTrue(cr.isCircularRotation("hithere", "rehithe"));
        assertTrue(cr.isCircularRotation("TGACGAC", "ACTGACG"));
        assertTrue(cr.isCircularRotation("ACTGACG", "TGACGAC"));

        assertFalse(cr.isCircularRotation("test", "nothing"));
        assertFalse(cr.isCircularRotation("test", "testing"));
        assertFalse(cr.isCircularRotation("a", "b"));
        assertFalse(cr.isCircularRotation("123", "456"));

    }
}