package exercises;

import static org.junit.Assert.*;

/**
 * Write an Interval1D client that takes int value N , creates N intervals
 * (pair of double values), and print all the pairs that intersect
 */
public class Exc_122Interval2DTest {

    Exc_1_2_2_Interval2D i1d = new Exc_1_2_2_Interval2D();

    @org.junit.Test
    public void testDoesIntersect() {
        Point2D a = new Point2D(1, 2.0, 4.0);
        Point2D b = new Point2D(2, 4.0, 2.0);
        Point2D c = new Point2D(3, 5.0, 5.0);
        Point2D d = new Point2D(4, 0.5, 10.1);
        assertTrue(i1d.doesIntersect(a, b));
        assertTrue(i1d.doesIntersect(b, a));
        assertTrue(i1d.doesIntersect(d, a));
        assertTrue(i1d.doesIntersect(d, c));
        assertFalse(i1d.doesIntersect(c, a));
        assertFalse(i1d.doesIntersect(c, b));
    }

    @org.junit.Test
    public void testGenerateIntervals() {
        Point2D[] intervals = i1d.generateIntervals(5);
        assertTrue(intervals.length == 5);
    }

}