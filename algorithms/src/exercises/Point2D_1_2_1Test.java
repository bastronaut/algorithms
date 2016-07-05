package exercises;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 04-07-2016.
 */
public class Point2D_1_2_1Test {
    Point2D_1_2_1 p2d = new Point2D_1_2_1();

    @org.junit.Test
    public void testGeneratePoints() {
        p2d.generatePoints(10);
        assertTrue("100 points created:", p2d.points.size() == 100 );
        assertFalse("Not a 101 points created:", p2d.points.size() == 101 );

        p2d.generatePoints(5);
        assertTrue("100 points created:", p2d.points.size() == 125 );
    }

    @org.junit.Test
    public void testGetClosestPoints() {
        p2d.addClosePoints();
        // what can we assert:
        // that two closest points have distance 0
        // that the two points returned are at location CLOSESTPOINTSXY
        //

    }


}