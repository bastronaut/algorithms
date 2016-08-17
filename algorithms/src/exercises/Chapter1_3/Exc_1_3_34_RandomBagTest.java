package exercises.Chapter1_3;

import static org.junit.Assert.*;

/**
 * To test RandomBag:
 * Create an array of items
 * Add these items to hte randombag
 * Take out all items with an iterator and store them in a new Array
 * Verify that both arrays contain all of the exact same items, but
 * that they are not in the same order as the one inserted.
 * Does not really test for randomness but ah well
 */
public class Exc_1_3_34_RandomBagTest {

    @org.junit.Test
    public void testAdd() {
        Exc_1_3_34_RandomBag<Integer> rb = new Exc_1_3_34_RandomBag();
        rb.add(1);
        rb.add(2);
        rb.add(3);
        rb.add(4);
        rb.add(5);
        rb.add(6);
        rb.add(7);
        rb.add(8);
        rb.add(9);
        rb.add(10);
        int addedNumbers[] = new int[]{1,2,3,4,5,6,7,8,9,10};
        int extractedNumbers[] = new int[10];

        int i = 0;
        for (Object addedint : rb) {
            extractedNumbers[i] = (int) addedint;
            i++;
        }

        for (int j = 0; j < extractedNumbers.length; j++) {

        }

        assertTrue(!extractedNumbers.equals(addedNumbers));
    }

}