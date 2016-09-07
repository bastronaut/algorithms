package exercises.Chapter1_4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bas on 7-9-2016.
 */
public class Exc_1_4_12_PrintSortedDuplicatesTest {

    @Test
    public void testPrintSortedDoubles() throws Exception {
        int[] firstArray =  new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 20};
        int[] secondArray = new int[]{1, 4, 4, 7, 8, 11, 14, 16, 17, 20};
        Exc_1_4_12_PrintSortedDuplicates psd = new Exc_1_4_12_PrintSortedDuplicates(firstArray, secondArray);
        assertTrue(psd.printSortedDoubles().equals("1,7,11,17,20"));
    }
}