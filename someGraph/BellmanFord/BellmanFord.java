import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class BellmanFord {
    final Graph graph;
    int src = -1;
    int nVert;
    double[] weight;
    int[] tree;

    public BellmanFord(Graph g) {
        graph = g;
        nVert = g.getCount();
        weight = new double[nVert];
        tree = new int[nVert];
    }

    public int[] getTree(int u) {
        if (u < 0 || u >= nVert) return null;
        if (u != src) {
            bellmanFord(u);
        }
        return tree;
    }

    public Stack<Integer> getAnswer(int to,int[] tree){
        int a = to;
        Stack<Integer> answer = new Stack<>();
        answer.add(a);
        while (a != -1){
            answer.add(tree[a]);
            a=tree[a];
        }
        return answer;
    }

    
    public double[] getWeight(int u) {
        if (u < 0 || u >= nVert) return null;
        if (u != src) {
            bellmanFord(u);
        }
        return weight;
    }

    
    private boolean relax(int from, Graph.Arc fromTo) {
        int to = fromTo.to();
        double newMaxMinWeight = Math.min(weight[from],fromTo.weight);
        if (weight[to] < newMaxMinWeight) {
            weight[to] = newMaxMinWeight;
            tree[to] = from;
            return true;
        } else {
            return false;
        }
    }


    private boolean bellmanFord(int s) {
        src = s;
       
        for (int i = 0; i < nVert; ++i) {
            weight[i] = -1;
            tree[i] = -1;
        }
        weight[s] = Double.POSITIVE_INFINITY;

        
        boolean changed = true;
        
        for (int step = 0; step <= nVert && changed; ++step) {
            changed = false;
            for (int u = 0; u < nVert; ++u) {
                if (weight[u] != -1) {
                    for (Iterator<Graph.Arc> iArc = graph.arcs(u); iArc.hasNext(); ) {
                        Graph.Arc arc = iArc.next();
                        if (relax(u, arc)) {
                            changed = true;
                        }
                    }
                }
            }
        }
        return !changed;
    }


    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addArc(1, 0, 5);
        g.addArc(1, 6, 1);
        g.addArc(1, 3, 3);
        g.addArc(3, 4, 2);
        g.addArc(4, 2, 5);
        g.addArc(2, 3, 4);
        g.addArc(2, 7, 5);
        g.addArc(2, 6, 2);
        g.addArc(6, 7, 3);
        g.addArc(7, 5, 3);

        int from=1;
        int to=6;



        BellmanFord bellmanFord = new BellmanFord(g);
        System.out.println("Tree: " + Arrays.toString(bellmanFord.getTree(from)));
        System.out.println("Weight: " + Arrays.toString(bellmanFord.getWeight(from)));
        System.out.print("Prath from " + from + " to " + to + " : ");
        if(bellmanFord.getWeight(from)[to]!=-1) {
            Stack<Integer> answer = bellmanFord.getAnswer(to, bellmanFord.getTree(from));answer.pop();
            while ((!answer.isEmpty())) {
                System.out.print(answer.pop() + " ");
            }
        }
        else{
            System.out.print("Way not found exeption");
        }

    }
}
