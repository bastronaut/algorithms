package exercises.Chapter1_5;

import static org.junit.Assert.*;

/**
 * Created by Bas on 18-10-2016.
 */
public class QuickFindTest {

    @org.junit.Test
    public void testQF() {
        QuickFind qf = new QuickFind(10);
        // testcase: already connected nodes: {8,9} , {1, 0}
        int[][] pairs = new int[][]{{4, 3},{3, 8}, {6,5}, {9,4}, {2,1}, {8, 9},{5,0}, {7,2}, {6,1}, {1,0}, {6,7}};
        int[][] groundTruth = new int[][]{{4, 3},{3, 8}, {6,5}, {9,4}, {2,1}, {5,0}, {7,2}, {6,1}};
        int[][] testresult = new int[groundTruth.length][groundTruth[0].length];
        // the test: do not print out the pair if it is connected.
        for (int[] pair : pairs) {
            if (qf.isConnected(pair[0], pair[1])) {
                continue;
            } else {
                qf.union(pair[0], pair[1]);
                System.out.println(pair[0]+ " "+ pair[1]);
                // todo add pairs to testresult
            }
        }
        assertTrue(haveSamePairs(testresult, groundTruth));
    }

    public boolean haveSamePairs(int[][] testresult, int[][] groundtruth) {
        for (int i = 0; i < groundtruth.length; i++) {
            for (int j = 0; j < groundtruth[i].length; j++) {
                if (groundtruth[i][j] != testresult[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


}
