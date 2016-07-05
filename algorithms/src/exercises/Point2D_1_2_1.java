package exercises;

import java.util.ArrayList;
import java.util.Random;

/**
 * Write a point2D client thtat takes int value N and generates N random points in the unit square,
 * and compute the distance seperating the closest pair of points
 */
public class Point2D_1_2_1 {

    ArrayList<Point2D> points = new ArrayList<>();
    final int ARBITRARYINTLIMIT = 9999999;
    final int CLOSESTPOINTSXY = ARBITRARYINTLIMIT/2;
    public void generatePoints(int n) {
        Random rand = new Random();
        for (int i = 0; i < Math.pow(n, 2); i ++) {
            points.add(new Point2D(rand.nextInt(ARBITRARYINTLIMIT), rand.nextInt(ARBITRARYINTLIMIT)));
        }
    }

    // Adds two points with the same x/y for test purposes
    public void addClosePoints() {
        Point2D firstpoint = new Point2D(CLOSESTPOINTSXY, CLOSESTPOINTSXY);
        Point2D secondpoint = new Point2D(CLOSESTPOINTSXY, CLOSESTPOINTSXY);
        points.add(firstpoint);
        points.add(secondpoint);
    }

        // calculate euclidian distance between points and find the ones that are closest
    // probably good to do a hashmap of points and their distances
    // try to only do distance: a->b, and skip b->a;
    // returns x/y location of the two closest points
    public ArrayList<Point2D> getClosestPoints() {
        return points;
    }
}
