package exercises.Chapter2_1;

/**
 * Created by BSijtsma on 10-10-2016.
 */
public class SortTemplate {

    public static void sort(Comparable[] a) {

    }

    private static boolean isLess(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (isLess(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static void Main(String[] args) {
        String[] a = new String[]{"s", "t", "r", "i", "n", "g"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
