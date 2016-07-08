package exercises;

import algorithms.BinarySearch;

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
public class Exc_1_1_139_BinarySearchQuantities {

    BinarySearch bs = new algorithms.BinarySearch();
    private HashMap<Integer, Integer> doubleOccurrences = new HashMap<>();

    private static int[] buildOrderedArray(int nExponant) {
        int[] orderedInts = new int[(int) Math.pow(10, nExponant)];
        Random rand = new Random();

        for (int i = 0; i < orderedInts.length -1; i++) {
            orderedInts[i] = 100000 + rand.nextInt((999999-100000) +1); // random six digit nr over 100000
        }
        Arrays.sort(orderedInts);
        return orderedInts;
    }

    private void findDoubleOccurrences(int[] firstArray, int[] secondArray, int nExponant) {
        int count = 0;
        for (int i = 0; i< firstArray.length-1; i++) {
            if (bs.Search(firstArray[i], secondArray) != -1) {
                count++;
            }
        }
        doubleOccurrences.put(nExponant, count +1);
    }

    public void runTrial(int nMin, int nMax) {
        if (nMin > nMax || nMin < 0 || nMax < 0) { return; }
        for (int n = nMin; n <= nMax; n++) {
            int[] firstArray = buildOrderedArray(n);
            int[] secondArray = buildOrderedArray(n);
            findDoubleOccurrences(firstArray, secondArray, n);
        }
    }

    public HashMap<Integer, Integer> getDoubleOccurrences() {
        return doubleOccurrences;
    }
}
