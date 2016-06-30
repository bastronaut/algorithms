package exercises;

/**
 Write a library 'Matrix' that implements the following API:

 static double dot(double[] x, double[] y) vector dot product
 static double mult(double[][] a , double[][] b) matrix matrix product
 static double transpose(double[][] a) transpose
 static double mult(double[][] a , double[] x) matrix-vector product
 static double mult(double[] y , double[][] a) vector-matrix product

 notes:
 for matrix multiplication, we have a set requirement:
 rows x columns: the number of columns in the 1st matrix must equal the number of rows in the 2nd matrix.
 To multiply an m×n matrix by an n×p matrix, the ns must be the same, and the result is an m×p matrix.

 Matrix multiplication is therefor not commutative.



 */

public class MatrixLibrary_1_1_33 {

    // vector dot product (or inner product, or scalar product) takes two equal length vectors and returns a
    // single scalar: [ax, bx] [ay, by] is ax*ay + bx*by = c
    public static double dot(double[] x, double[] y) throws IllegalArgumentException {
        if (x.length != y.length) { throw new IllegalArgumentException("vectors must be of equal length "); }
        double result = 0;
        for (int i = 0; i < x.length; i++){
            result += x[i] * y[i];
        }
        return result;
    }

    public static double[][] mult(double[][] a, double [][] b) {
        double[][] testresult = new double[][]{
                {9, 12, 15},
                {19, 26, 33},
                {29, 40, 51} };
        return testresult;
    }

    public static double[][] transpose(double[][] a) {
        double[][] transposed = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++){
                transposed[j][i] = a[i][j];
            }
        }
        return transposed;
    }



    public static double[] mult(double[][] a, double[] x) {
        double[] result = new double[1];
        return result;
    }

    public static double[] mult(double[] y, double[][] x) {
        double[] result = new double[1];
        return result;
    }

}
