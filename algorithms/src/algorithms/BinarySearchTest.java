package algorithms;

import org.junit.Before;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 28-06-2016.
 */
public class BinarySearchTest {

    @Before
    public void setUp() throws Exception {
    }

    // positive test case
    @org.junit.Test
    public void searchPositive() throws Exception {
        final int n = 500; // arbitrary size of array and max size of array entries
        final int key = 137; // arbitrary key to find
        BinarySearch bs = new BinarySearch();
        int[] orderedInts = buildOrderedArrayWithKey(n, key);
        // As the index that it returns is based on a random list
        // can not predetermine what the index will be. As long as it is smaller than n and over 0
        assertNotEquals(bs.Search(key, orderedInts), -1);
        int keyindex = bs.Search(key, orderedInts);
        assertTrue(keyindex > 0);
        assertTrue(keyindex < n);
    }

    // negative test case
    @org.junit.Test
    public void searchNegative() throws Exception {
        final int n = 500; // arbitrary size of array
        final int key = 137; // arbitrary key to find
        BinarySearch bs = new BinarySearch();
        int[] orderedInts = buildOrderedArrayWithoutKey(n, key);

        assertEquals(bs.Search(key, orderedInts), -1);
        assertEquals(bs.Search(999, orderedInts), -1);
        assertEquals(bs.Search(-1, orderedInts), -1);
        int[] empty = new int[0];
        assertEquals(bs.Search(key, empty), -1);
    }

    private int[] buildOrderedArrayWithKey(int n, int key) {
        int[] orderedInts = new int[n];
        Random rand = new Random();
        // add key to array and seed array
        orderedInts[0] = key;
        for (int i = 1; i < n; i++ ) {
            int randomNum;
            randomNum = rand.nextInt(n);
            orderedInts[i] = randomNum;
        }
        Arrays.sort(orderedInts);
        return orderedInts;
    }

    private int[] buildOrderedArrayWithoutKey(int n, int key) {
        Random rand = new Random();
        int[] orderedInts = new int[n];
        // seed array
        for (int i = 0; i < n; i++ ) {
            int randomnr;
            randomnr = rand.nextInt(n);
            if (randomnr == key) {
                continue;
            } else orderedInts[i] = randomnr;
        }
        Arrays.sort(orderedInts);
        return orderedInts;
    }

}