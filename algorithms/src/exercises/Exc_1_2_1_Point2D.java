package exercises;

import java.util.ArrayList;
import java.util.Random;

/**
 * Write a point2D client thtat takes int value N and generates N random points in the unit square,
 * and compute the distance seperating the closest pair of points
 * Distance will be (double) euclidean distance
 */
public class Exc_1_2_1_Point2D {

    ArrayList<Point2D> points = new ArrayList<>();
    final int ARBITRARYINTLIMIT = 9999999;
    final int CLOSESTPOINTSXY = ARBITRARYINTLIMIT/2;
    final int CLOSESTPOINTID = 99999991;

    public void generatePoints(int n) {
        Random rand = new Random();
        for (int i = 0; i < Math.pow(n, 2); i ++) {
            points.add(new Point2D(i, rand.nextInt(ARBITRARYINTLIMIT), rand.nextInt(ARBITRARYINTLIMIT)));
        }
    }

    // Adds two points with the same x/y for test purposes
    public void addClosePoints() {
        Point2D firstpoint = new Point2D(CLOSESTPOINTID, CLOSESTPOINTSXY, CLOSESTPOINTSXY);
        Point2D secondpoint = new Point2D(CLOSESTPOINTID, CLOSESTPOINTSXY+1, CLOSESTPOINTSXY+1);
        points.add(firstpoint);
        points.add(secondpoint);
    }

    // calculate euclidean distance between points and find the ones that are closest
    // returns the two closest points
    // euclidean distance is defined as root( (qx-rx)^2 + (qy - ry)^2 )
    public Point2D[] getClosestPoints() {
        double closestDistance = ARBITRARYINTLIMIT;
        Point2D[] closestPoints = new Point2D[2];

        for (int i = 0; i < this.points.size(); i ++) {
            for (int j = 0; j < this.points.size(); j++) {
                // by checking if i >= j, we save half of all operations. Can be seen as matrix,
                // where we can skip distance between a point itself ( = distance(a, a), and if
                // distance(a, b) is calculated, we can skip distance(b, a)
                if (i >= j ) continue;
                double distance = getEuclideanDistance(points.get(i), points.get(j));
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestPoints[0] = points.get(i);
                    closestPoints[1] = points.get(j);
                }
            }
        }
        return closestPoints;
    }

    private double getEuclideanDistance(Point2D a, Point2D b) {
        return Math.sqrt( Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2) );
    }
}
