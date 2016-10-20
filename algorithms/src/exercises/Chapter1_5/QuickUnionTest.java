package exercises.Chapter1_5;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 20-10-2016.
 */
public class QuickUnionTest {

    @org.junit.Test
    public void testQU() {
        //test case:
        QuickFind qf = new QuickFind(10);
        // already connected nodes: {8,9} , {1, 0}
        int[][] pairs = new int[][]{{4, 3},{3, 8}, {6,5}, {9,4}, {2,1}, {8, 9},{5,0}, {7,2}, {6,1}, {1,0}, {6,7}};
        // the test: do not print out the pair if it is connected.
        for (int[] pair : pairs) {
            if (qf.isConnected(pair[0], pair[1])) {
                continue;
            } else {
                qf.union(pair[0], pair[1]);
                System.out.println(pair[0]+ " "+ pair[1]);
            }
        }
    }

}