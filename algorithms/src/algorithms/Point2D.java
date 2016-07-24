package algorithms;

/**
 * Created by BSijtsma on 04-07-2016.
 */
public class Point2D {
    int id;
    int x;
    int y;
    double xx; // doubles for different exercise
    double yy; // doubles for different exercise

    public Point2D(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Point2D(int id, double x, double y) {
        this.id = id;
        this.xx = x;
        this.yy = y;
    }

    public int getId() { return id; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) { this.y = y;
    }

    public String toString() {
        return "id: "+this.id + " x:" + this.x + " y:"+ this.y;
    }
}
