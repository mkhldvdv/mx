package interview;

/**
 * Created by mikhail.davydov on 29.09.2017.
 */

public class Point {
    private int x;
    private int y;
    private Point previous;

    public Point(int x, int y, Point previous) {
        this.x = x;
        this.y = y;
        this.previous = previous;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point getPrevious() {
        return previous;
    }

    public void setPrevious(Point previous) {
        this.previous = previous;
    }
}
