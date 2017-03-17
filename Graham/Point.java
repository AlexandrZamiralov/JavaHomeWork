
public class Point implements Comparable<Point> {


     int x;
     int y;
     double d;
     double a;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Point)) return false;
        Point other = (Point) o;
        return x == other.x && y == other.y;
    }

    @Override
    public int compareTo(Point other) {
        if (y == other.y) return other.x - x;
        return y - other.y;
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
