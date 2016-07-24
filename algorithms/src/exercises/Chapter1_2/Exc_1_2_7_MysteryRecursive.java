package exercises.Chapter1_2;

/**
 * Created by BSijtsma on 07-07-2016.
 */
public class Exc_1_2_7_MysteryRecursive {

    public static String mystery(String s) {
        System.out.println(s);
        int N = s.length();
        if ( N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        String r = mystery("ABCDEFGH");
        System.out.println("\n\n" + r);
    }
}
