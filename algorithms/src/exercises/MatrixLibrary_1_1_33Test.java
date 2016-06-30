package exercises;

import static org.junit.Assert.*;

/**
 Write a library 'Matrix' that implements the following API:

 static double dot(double[] x, double[] y) vector dot product
 static double mult(double[][] a , double[][] b) matrix matrix product
 static double transpose(double[][] a) transpose
 static double mult(double[][] a , double[] x) matrix-vector product
 static double mult(double[] y , double[][] a) vector-matrix product
 */

public class MatrixLibrary_1_1_33Test {
    MatrixLibrary_1_1_33 ml = new MatrixLibrary_1_1_33();

    @org.junit.Test
    public void testDot() throws Exception {
        double[] x = new double[]{1, 2, 3, 4, 5};
        double[] y = new double[]{1, 2, 3, 4, 5};
        double[] testresult = new double[]{1, 4, 9, 16, 25};

        assertArrayEquals(testresult, ml.dot(x, y), 0);
    }

    @org.junit.Test
    public void testMultMatrixMatrix() throws Exception {
        double[][] x = new double[2][3];
        double[][] y = new double[3][2];
        double[][] testresult = new double[][]{
                {9, 12, 15},
                {19, 26, 33},
                {29, 40, 51} };
        assertTrue(assertDoubleArrayEquals(testresult, ml.mult(x, y)));

    }

    @org.junit.Test
    public void testTranspose() throws Exception {
        double[][] x = new double[][]{
                {1, 1},
                {2, 2},
                {3, 3} };
        double [][] testresult = new double[][]{
                {1, 2, 3},
                {1, 2, 3} };
        assertTrue(assertDoubleArrayEquals(testresult, ml.transpose(x)));
    }

    @org.junit.Test
    public void testMultMatrixVector() throws Exception {
        double[] x = new double[]{};
        double[][] y = new double[][]{{}};
        double[] testresult = new double[]{};
        assertArrayEquals(testresult, ml.mult(y, x), 0);

    }

    @org.junit.Test
    public void testVectorMatrix() throws Exception {
        double[] x = new double[]{3, 4, 2};
        double[][] y = new double[][]{
                {13, 9, 7, 15},
                {8, 7, 4, 6},
                {6, 4, 0, 3} };
        double[] testresult = new double[]{83, 63, 37, 75};
        assertArrayEquals(testresult, ml.mult(x, y), 0);


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
        System.out.println("assertDoubleArrayEquals passed successfully");
        return true;
    }
}