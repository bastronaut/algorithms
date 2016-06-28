import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Bas on 26-6-2016.
 */
public class BinarySearch {
//    returns the index of the word to be searched in an ordered list. Returns -1 if not in list
    public static int Search(int key, int[] orderedInts) {
        return Search(key, orderedInts, orderedInts.length, 0, 0);
    }

    public static int Search(int key, int[] orderedInts, int high, int low, int nrofsplits) {
        int mid = ((high - low) / 2) + low;
        if (high < low) return -1;
        if (key == orderedInts[mid]) {
            System.out.println("Found "+ key + " at index: " + mid + " after " + nrofsplits + " splits.");
            return mid;
        } else if (key > orderedInts[mid]) {
            return Search(key, orderedInts, high, mid, nrofsplits + 1);
        } else  {
            return Search(key, orderedInts, mid, low, nrofsplits + 1);
        }
    }

    public static void testBinarySearch(int key, int n) {
        Random rand = new Random();
        int[] orderedInts = new int[n];
        // add key to array and seed array
        orderedInts[0] = key;
        for (int i = 1; i < n; i++ ) {
            int randomnr;
            randomnr = rand.nextInt(n);
            orderedInts[i] = randomnr;
        }

        Arrays.sort(orderedInts);
        Search(key, orderedInts);
    }

    public static void main(String args[]) {
        testBinarySearch(134, 500);
    }
}
