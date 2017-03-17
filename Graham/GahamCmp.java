import java.util.Comparator;


public class GrahamCmp implements Comparator<Point> {
    double EPS = 1e-7;
    @Override
    public int compare(Point p1, Point p2) {
        if (p1.a < p2.a - EPS)
            return -1;
        if (p1.a > p2.a + EPS)
            return 1;
        return p1.d < p2.d ? -1 : 1;
    }
}
