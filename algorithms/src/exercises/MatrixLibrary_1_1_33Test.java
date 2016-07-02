package exercises;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 Write a library 'Matrix' that implements the following API:

 static double dot(double[] x, double[] y) vector dot product
 static double mult(double[][] a , double[][] b) matrix matrix product
 static double transpose(double[][] a) transpose
 static double mult(double[][] a , double[] x) matrix-vector product
 static double mult(double[] y , double[][] a) vector-matrix product

 assertEquals for doubles take an additional epsilon argument: as doubles may not be exactly equal
 the epsilon serves as a fuzzy factor
 */

public class MatrixLibrary_1_1_33Test {
    MatrixLibrary_1_1_33 ml = new MatrixLibrary_1_1_33();

    @org.junit.Test
    public void testDot() {
        double[] x = new double[]{1, 2, 3, 4, 5};
        double[] y = new double[]{1, 2, 3, 4, 5};
        double testResult = 55;

        assertEquals(testResult, ml.dot(x, y), 0);

        double[] xn = new double[]{0};
        double[] yn = new double[]{25};
        testResult = 0;
        assertEquals(testResult, ml.dot(xn, yn), 0);
    }

    @org.junit.Test
    public void testMultMatrixMatrix() throws Exception {
        double[][] x = new double[][]{
                {2, 3},
                {4, 2},
                {1, 3},
                {0, 2}, };
        double[][] y = new double[][]{
                {1, 2},
                {1, 2}};
        double[][] testResult = new double[][]{
                {5, 10},
                {6, 12},
                {4, 8},
                {2, 4} };

        assertTrue(assertDoubleArrayEquals(testResult, ml.mult(x, y)));

        double[][] xn = new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9} };
        double[][] yn = new double[][]{
                {5},
                {4},
                {3}};
        testResult = new double[][]{
                {22},
                {58},
                {94} };

        assertTrue(assertDoubleArrayEquals(testResult, ml.mult(xn, yn)));

    }

    @org.junit.Test
    public void testTranspose() throws Exception {
        double[][] x = new double[][]{
                {1, 1},
                {2, 2},
                {3, 3} };
        double [][] transposedx = new double[][]{
                {1, 2, 3},
                {1, 2, 3} };
        assertTrue(assertDoubleArrayEquals(transposedx, ml.transpose(x)));
        assertTrue(assertDoubleArrayEquals(transposedx, ml.transpose(x)));

        double[][] y = new double[][] {
                {1, 1, 1} };
        double[][] transposedy = new double[][]{
                {1},
                {1},
                {1} };
        assertTrue(assertDoubleArrayEquals(transposedy, ml.transpose(y)));
        assertTrue(assertDoubleArrayEquals(ml.transpose(y), transposedy));


    }

    @org.junit.Test
    public void testMultMatrixVector() throws Exception {
        double[] x = new double[]{2, 1, 0};
        double[][] y = new double[][]{
                {1, -1, 2},
                {0, -3, 1}};
        double[] testResult = new double[]{1, -3};
        assertArrayEquals(testResult, ml.mult(y, x), 0);

    }

    @org.junit.Test
    public void testVectorMatrix() throws Exception {
        double[] x = new double[]{3, 4, 2};
        double[][] y = new double[][]{
                {13, 9, 7, 15},
                {8, 7, 4, 6},
                {6, 4, 0, 3} };
        double[] testResult = new double[]{83, 63, 37, 75};
        assertArrayEquals(testResult, ml.mult(x, y), 0);


    }


    public boolean assertDoubleArrayEquals(double[][] expected, double[][] given) {
        if (expected.length != given.length) return false;
        try {
            for (int i = 0; i < expected.length; i++) {
                for (int j = 0; j < expected[i].length; j++){
                    if (expected[i][j] != given[i][j]) {
                        System.out.println("Double array not equal");
                        return false;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("error validating assertArrayEquals[][]" + e);
            return false;
        }
        return true;
    }
}