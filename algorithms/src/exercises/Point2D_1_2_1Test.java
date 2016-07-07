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
        p2d.generatePoints(10);
        p2d.addClosePoints();
        // what can we assert:
        // that two closest points have distance 0
        // that the two points returned are at location CLOSESTPOINTSXY
        // that the closest points have an id of p2d.CLOSESTPOINTID
        Point2D[] closestpoints = p2d.getClosestPoints();
        System.out.println("after getting its:" + closestpoints[0]);
        System.out.println("after getting its:" + closestpoints[1]);

        assertTrue(closestpoints[0].getId() == p2d.CLOSESTPOINTID);
        assertTrue(closestpoints[1].getId() == p2d.CLOSESTPOINTID);
        assertTrue(closestpoints[0].getX() == p2d.CLOSESTPOINTSXY);
        assertTrue(closestpoints[0].getY() == p2d.CLOSESTPOINTSXY);
        assertTrue(closestpoints[1].getX() == p2d.CLOSESTPOINTSXY+1);
        assertTrue(closestpoints[1].getY() == p2d.CLOSESTPOINTSXY+1);

    }


}