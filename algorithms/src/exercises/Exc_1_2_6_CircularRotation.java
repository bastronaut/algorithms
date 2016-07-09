package exercises;

/**
 * A string is a circular rotation of a string if it
 * matches when the characters are circularly shifted by any  nr
 * of positions: ACTGACG is a circular shift of TGACGAC
 * (and vice versa). Write a fn that checks if the given
 * two strings are circular shifts of one another
 */
public class Exc_1_2_6_CircularRotation {

    public boolean isCircularRotation(String a, String b) {
        if (a.length() != b.length()) return false;
        return (a.length() == b.length() && a.concat(a).indexOf(b) >= 0);
    }
}
