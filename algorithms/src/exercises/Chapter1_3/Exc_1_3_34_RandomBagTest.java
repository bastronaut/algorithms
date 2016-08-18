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

        assertTrue(!extractedNumbers.equals(addedNumbers));

        // Traverse trough all extractedNumbers, and verify
        // that theyre present in addednumbers. If found, it is
        // replaced with -1 to allow for verifying double occurrences
        // of an int. If in the end all of extractedNumbers is
        // set to -1, all of the items put in the RandomBag
        // were successfully returned and test case passes
        for (int j = 0; j < extractedNumbers.length; j++) {
            for (int k = 0; k < addedNumbers.length; k++) {
                if (extractedNumbers[j] == addedNumbers[k]) {
                    extractedNumbers[j] = -1;
                    break;
                }
            }
        }

        boolean allfound = true;
        for (i = 0; i < extractedNumbers.length; i++) {
            if (extractedNumbers[i] != -1) {
                allfound = false;
            }
        }
        assertTrue(allfound);
    }

}