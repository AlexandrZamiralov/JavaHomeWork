import java.util.Arrays;
import static java.lang.Math.*;


public class Graham {
    
    public Point[] graham (Point[] p) {
        Arrays.sort(p);

        int n = p.length;
        for (Point cp : p) {
            cp.a = atan2(cp.y - p[0].y, cp.x - p[0].x);
            cp.d = dist(cp, p[0]);
        }
        p[0].a = -1;
        Arrays.sort(p, new GrahamCmp());

        Point[] res = new Point [n];
        int k = -1;
        for (Point cp : p) {
           ¸
            if (k > 0 && cross(res[k], res[k - 1], cp) >= 0){
                System.out.println("nonconvex "+cp.toString()+" doing wrong");
            break;}
            res[++k] = cp;
        }
        return Arrays.copyOf(res, k + 1);
    }
    
    double dist(Point p1, Point p2) {
        return sqrt((p2.x - p1.x) ^ 2 + (p2.y - p1.y) ^ 2);
    }
  
    double cross(Point p0, Point p1, Point p2) {
        return (p1.x - p0.x) * (p2.y - p0.y) - (p2.x - p0.x) * (p1.y - p0.y);
    }

    public static void main(String[] args) {
        Graham g= new Graham();
        Point[] points = new Point[4];
        Point[] convexHull ;


        points[0]= new Point(1,1);
        points[1]= new Point(2,1);
        points[2]= new Point(2,3);
        points[3]= new Point(1,3);
        //points[3]=new Point(3,1);


        convexHull=g.graham(points);
        System.out.println(Arrays.toString(convexHull));

        }
    }
