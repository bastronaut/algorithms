package exercises;

import java.util.Arrays;

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

    // matrix * matrix
    public static double[][] mult(double[][] a, double [][] b) {
        if (a.length <= 0 || b.length <= 0) { throw new IllegalArgumentException("matrix must have at least 1 row");}
        if (a[0].length != b.length) { throw new IllegalArgumentException("columns in A must match rows in B " + a[0].length +" " +  b.length);}
        int columnSizeA = a[0].length;
        for (double[] row : a) {
            if (row.length != columnSizeA) throw new IllegalArgumentException("Columns in A must be of equal length");
        }
        int columnSizeB = b[0].length;
        for (double[] row : b) {
            if (row.length != columnSizeB) throw new IllegalArgumentException("Columns in B must be of equal length");
        }

        double[][] result = new double[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                for (int k = 0; k < b[0].length; k ++) {

                    result[i][k] += a[i][j] * b[j][k];
                }
            }
        }
        return result;
    }

    public static double[][] transpose(double[][] a) {
        if (a.length <= 0) { throw new IllegalArgumentException("matrix must have at least 1 row");}
        if (a[0].length <= 0) { throw new IllegalArgumentException("column must have at least 1 value");}

        double[][] transposed = new double[a[0].length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++){
                transposed[j][i] = a[i][j];
            }
        }
        return transposed;
    }


    // matrix * vector can be viewed as matrix * singlecolumn matrix.
    // http://mathinsight.org/matrix_vector_multiplication
    public static double[] mult(double[][] a, double[] x) {
        double[][] singlecolumnmatrix = new double[x.length][1];
        for (int i = 0; i < x.length; i ++) {
            singlecolumnmatrix[i][0] = x[i];
        }

        double[][] multicolumnresult = mult(a, singlecolumnmatrix);

        // flatten the 1-column multiple rows into a single array
        double[] result = new double[multicolumnresult.length];
        for (int i = 0; i < multicolumnresult.length; i ++) {
            result[i] = multicolumnresult[i][0];
        }
        return result;
    }

    // vector * matrix
    public static double[] mult(double[] x, double[][] a) {
        if (a.length <= 0 || x.length <= 0) { throw new IllegalArgumentException("matrix must have at least 1 row");}
        if (x.length != a.length) throw new IllegalArgumentException("columns in A must match rows in B " + x.length +" " +  a.length);
        double[] result = new double[a[0].length];
        for (int i = 0; i < a[0].length; i++)
            for (int j = 0; j < a[0].length; j++)
                result[i] += a[j][i] * x[j];
        return result;
//        int m = a.length;
//        int n = a[0].length;
//        if (x.length != m) throw new RuntimeException("Illegal matrix dimensions.");
//        double[] y = new double[n];
//        for (int j = 0; j < n; j++)
//            for (int i = 0; i < m; i++)
//                y[j] += a[i][j] * x[i];
//        return y;
    }

}
