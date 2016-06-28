import java.util.Arrays;
import java.util.Random;


/**
 * Created by Bas on 26-6-2016.
 */
public class BinarySearch {
//    returns the index of the word to be searched in an ordered list. Returns -1 if not in list
    public static int Search(int key, int[] orderedInts) {
        return Search(key, orderedInts, 0, orderedInts.length-1, 0);
    }

    public static int Search(int key, int[] orderedInts, int low, int high, int nrofsplits) {
        int mid = ((high - low) / 2) + low;
        if (orderedInts.length < 0 || high < 0 || high == low || low == mid || key > orderedInts[high] || key < orderedInts[low]) {
            System.out.println("Key "+ key +" not found in array");
            return -1;
        }
        if (key == orderedInts[mid]) {
            System.out.println("Found "+ key + " at index: " + mid + " after " + nrofsplits + " splits.");
            return mid;
        } else if (key > orderedInts[mid]) {
            return Search(key, orderedInts, mid, high, nrofsplits + 1);
        } else  {
            return Search(key, orderedInts, low, mid, nrofsplits + 1);
        }
    }

    public static void main(String args[]) {

    }
}
