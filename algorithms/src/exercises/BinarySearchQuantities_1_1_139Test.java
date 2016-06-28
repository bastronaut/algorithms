package exercises;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Exercise 1.1.139, page 62
 * Write a binarysearch client that takes int value T and runs T trials for the
 * experiments N = 10^3, 10^4, 10^5, 10^6: generate two arrays of size N with randomly
 * generated six-digit int values, and find the number of values that appear in both arrays.
 * Print a table giving the average value of this quantity over the T trials for each
 * value of N
 */
public class BinarySearchQuantities_1_1_139Test {
    @Test
    public void runTrial() throws Exception {
        BinarySearchQuantities_1_1_139 BSQ = new BinarySearchQuantities_1_1_139();
        final int T = 5; // number of times to run trial
//        Random rand = new Random();
//        int randomNum = 100000 + rand.nextInt((999999-100000) +1); // random six digit nr over 100000
//        System.out.println(randomNum);
        for (int i = 0; i < T; i++) {
            BSQ.runTrial();
        }
        HashMap results = BSQ.getDoubleOccurrences();
        printResultTable(results);

    }

    public void printResultTable(HashMap quantities) {
        quantities.forEach((k, v) -> System.out.println("key" + k + "value" + v));
    }
}