package exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Exercise 1.1.139, page 62
 * Write a binarysearch client that takes int value T and runs T trials for the
 * experiments N = 10^3, 10^4, 10^5, 10^6: generate two arrays of size N with randomly
 * generated six-digit int values, and find the number of values that appear in both arrays.
 * Print a table giving the average value of this quantity over the T trials for each
 * value of N
 */
public class BinarySearchQuantities_1_1_139 {
    algorithms.BinarySearch bs = new algorithms.BinarySearch();
    private HashMap<Integer, Integer> doubleOccurrences = new HashMap<>();

    private static int[] buildNSizedArray(int nExponant) {
        int[] orderedInts = new int[(int) Math.pow(10, nExponant)];
        Random rand = new Random();

        for (int i = 0; i < orderedInts.length -1; i++) {
            int randomNum = 100000 + rand.nextInt((999999-100000) +1); // random six digit nr over 100000
            orderedInts[i] = randomNum;
        }
        Arrays.sort(orderedInts);
        return orderedInts;
    }

    private void findDoubleOccurrences(int[] firstArray, int[] secondArray, int nExponant) {
        int currentCount = 0;
        for (int i = 0; i< firstArray.length-1; i++) {
            if (bs.Search(firstArray[i], secondArray) != -1) {
                currentCount = getOrDefault(doubleOccurrences, nExponant, 0);
                doubleOccurrences.put(nExponant, currentCount);
            }
        }
    }

    private static <K, V> V getOrDefault(Map<K,V> map, K key, V defaultValue) {
        return map.containsKey(key) ? map.get(key) : defaultValue;
    }

    public void runTrial() {
        for (int n = 3; n < 6; n++) {
            int[] firstArray = buildNSizedArray(n);
            int[] secondArray = buildNSizedArray(n);
            findDoubleOccurrences(firstArray, secondArray, n);
        }
    }

    public HashMap<Integer, Integer> getDoubleOccurrences() {
        return doubleOccurrences;
    }
}
