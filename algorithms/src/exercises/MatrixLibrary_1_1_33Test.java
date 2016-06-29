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

        assertArrayEquals(ml.dot(x, y), testresult, 0);
    }

    @org.junit.Test
    public void testMultMatrixMatrix() throws Exception {

    }

    @org.junit.Test
    public void testTranspose() throws Exception {

    }

    @org.junit.Test
    public void testMultMatrixVector() throws Exception {

    }

    @org.junit.Test
    public void testVectorMatrix() throws Exception {

    }
}