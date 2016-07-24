package exercises.Chapter1_2;

import algorithms.Point2D;

import java.util.Random;

/**
 * Write an Interval1D client that takes int value N , creates N intervals
 * (pair of double values), and print all the pairs that intersect
 *
 */
public class Exc_1_2_2_Interval2D {

    final int MAXRANDOMNR = 10; // arbitrary

    public boolean doesIntersect(Point2D a, Point2D b) {
        return true;
    }

    public Point2D[] generateIntervals(int n) {
        Random rand = new Random();
        Point2D[] intervals = new Point2D[n];
        for (int i = 0; i < n; i++) {
            double x = rand.nextDouble() * MAXRANDOMNR;
            double y = rand.nextDouble() * MAXRANDOMNR;
            Point2D interval = new Point2D(i, x, y);
            intervals[i] = interval;
        }
        return intervals;
    }
}
