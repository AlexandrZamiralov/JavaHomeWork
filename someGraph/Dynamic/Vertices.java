
import java.util.LinkedList;

import static java.lang.Integer.min;

public class Vertices {
    Vertices previous=null;
    int i;
    int j;
    boolean flag = true;
    int distance=Integer.MAX_VALUE;
    public Vertices(int distance,int i, int j){
        this.distance=distance;
        this.i=i;
        this.j=j;
    }
    public Vertices (int i, int j){
        this.i=i;
        this.j=j;

    }

}
