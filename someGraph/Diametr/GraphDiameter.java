import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphDiameter {
    private List<List<Integer>> graph;
    public boolean[] flags;
    public int diameter;
    public int eccentricityAnswer;
    public int[] distances;

    
    public GraphDiameter(int n, List<Edge> edges){
        graph = new ArrayList<>(n);
        for(int i = 0; i < n; ++i){
            graph.add(new ArrayList<>());
        }
        for(Edge edge : edges){
            graph.get(edge.from).add(edge.to);
            graph.get(edge.to).add(edge.from);
        }
    }
    
    
    private void bfs(int k){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        flags[k] = true;
        distances[k] = 0;
        while(!queue.isEmpty()){
            for(int v : graph.get(queue.peek())){
                if(!flags[v]) {
                    queue.add(v);
                    flags[v] = true;
                    distances[v] = distances[queue.peek()] + 1;
                }
            }
            queue.poll();
        }
    }
    
    private int eccentricityFinder(int k){
        int max=0;
        clear();
        bfs(k);
        for (int i=0; i<graph.size();i++){
            max = Math.max(max,distances[i]);
        }
        return max;
    }

    void diameterFinder(int k){

        for(int i = 0; i < graph.size(); ++i) {
            int eccentricity = eccentricityFinder(i);
            diameter = Math.max(diameter, eccentricity);
            if (i == k) {eccentricityAnswer = eccentricity;}
        }
    }

    private void clear(){
        flags = new boolean[graph.size()];
        distances = new int[graph.size()];
        for(int i = 0; i < graph.size(); i++){
            distances[i] = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        int vertex = 2;
        int vertex1 =3;
        int vertex2 =5;
        int n = 9;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1));
        edges.add(new Edge(0, 8));
        edges.add(new Edge(2, 5));
        edges.add(new Edge(3, 8));
        edges.add(new Edge(4, 6));
        edges.add(new Edge(4, 7));
        edges.add(new Edge(5, 7));
        edges.add(new Edge(5, 8));
        edges.add(new Edge(7, 0));
        GraphDiameter graph = new GraphDiameter(n, edges);

        graph.diameterFinder(vertex);
        System.out.println("Vertex " + vertex + " has " + graph.eccentricityAnswer + " Eccentricity and " + graph.diameter + " Diameter");
        graph.diameterFinder(vertex1);
        System.out.println("Vertex " + vertex1 + " has " + graph.eccentricityAnswer+" Eccentricity and "+graph.diameter+" Diameter");
        graph.diameterFinder(vertex2);
        System.out.println("Vertex " + vertex2 + " has " + graph.eccentricityAnswer+" Eccentricity and "+graph.diameter+" Diameter");




    }
}
