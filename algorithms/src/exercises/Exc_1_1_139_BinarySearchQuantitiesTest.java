package exercises;

import java.util.HashMap;


import static java.lang.Integer.parseInt;
import static org.junit.Assert.*;


/**
 * Exercise 1.1.139, page 62
 * Write a binarysearch client that takes int value T and runs T trials for the
 * experiments N = 10^3, 10^4, 10^5, 10^6: generate two arrays of size N with randomly
 * generated six-digit int values, and find the number of values that appear in both arrays.
 * Print a table giving the average value of this quantity over the T trials for each
 * value of N
 */
public class Exc_1_1_139_BinarySearchQuantitiesTest {
    @org.junit.Test
    public void runTrial() throws Exception {
        Exc_1_1_139_BinarySearchQuantities BSQ = new Exc_1_1_139_BinarySearchQuantities();
        final int T = 1; // number of times to run trial
        final int nMin = 3; // lowest exponent
        final int nMax = 6; // highest exponent
        for (int i = 0; i < T; i++) {
            BSQ.runTrial(nMin, nMax);
        }
        HashMap<Integer, Integer> results = BSQ.getDoubleOccurrences();
        printResultTable(results, nMax-nMin);
        results.forEach((k, v) -> assertTrue(v > 0));
        assertTrue(results.size() == (nMax - nMin + 1) );
    }


    public void printResultTable(HashMap<Integer, Integer> quantities, int n) {
        System.out.println("N\toccurrences\taverage\n---------------------------");
        quantities.forEach((k, v) -> System.out.println("10^" + k + "\t" + v + "\t\t" + (float)v/n));
    }
}