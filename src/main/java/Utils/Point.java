package Utils;

public class Point {
    private int x, y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addX(int increment) {
        this.x += increment;
    }

    public void addY(int increment) {
        this.y += increment;
    }

    public void setPoint(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    public boolean equals(Point point) {
        if ((x == point.getX()) && (y == point.getY())) {
            return true;
        }
        else {
            return false;
        }
    }
}
