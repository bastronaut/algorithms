package exercises.Chapter1_4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 13-09-2016.
 */
public class Exc_1_4_14_4SumTest {
    @Test
    public void count4Sum() throws Exception {
        // 4sums: ]
        // -9 2 3 4
        // -9 1 2 6
        // -9 1 3 5
        // -9 -1 6 4
        // -9 -2 5 6
        // -10 1 4 5
        // -10 2 3 5
        // -10 1 3 6
        // -10 -1 5 6
        int[] sortedArray = new int[]{ -10, -9, -2, -1, 1, 2, 3, 4, 5, 6};
        Exc_1_4_14_4Sum fSum = new Exc_1_4_14_4Sum(sortedArray);
        assertTrue(fSum.count4Sum() == 9);
    }

}