
public class GraphCentre {
    private double[][] paths;


    public GraphCentre(Graph g) {
        floyd(g);
    }

   
    private double[][] floyd(Graph g) {
        int nVert = g.getCount();

        paths = g.buildMatrix();


        for (int k = 0; k < nVert; ++k) {
            for (int i = 0; i < nVert; ++i) {
                if (i != k && paths[i][k] < Double.POSITIVE_INFINITY) {
                    for (int j = 0; j < nVert; ++j) {
                        double newPath = paths[i][k] + paths[k][j];
                        if (newPath < paths[i][j]) {
                            paths[i][j] = newPath;
                        }
                    }
                }
            }
        }
        return paths;
    }
    
    private double[] eccentricityFinder(double[][] paths) {
        double[] maxs= new double[paths.length];
        for (int i = 0; i < paths.length; i++) {
            for (int j =i+1; j < paths.length; j++) {
                if (paths[i][j] > maxs[i]) {
                    maxs[i] = paths[i][j];
                }
                if (paths[i][j]>maxs[j]){
                    maxs[j]= paths[i][j];
                }
            }
           System.out.println("eccentricity of "+i+" Vertex= " + maxs[i]);
        }
        System.out.println();
        return maxs;
    }
   
    private double radiusFinder(double[] maxs){
        double min=Double.POSITIVE_INFINITY;
        for (int i=0;i<maxs.length;i++){
            if (maxs[i]<=min){
                min=maxs[i];
            }
        }
        System.out.println("radius= "+min);
        return min;
    }
   
    public void printAnswer(double[] maxs, double min){
        for (int i=0; i<maxs.length;i++){
            if (maxs[i]==min){
                System.out.println("Vertex " + i + " is central");
            }
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addArc(0, 1, 1);
        g.addArc(0, 3, 1);
        g.addArc(1, 3, 1);
        g.addArc(1, 2, 1);
        g.addArc(1, 4, 1);
        g.addArc(2, 4, 1);
        g.addArc(3, 4, 1);

        GraphCentre graph = new GraphCentre(g);
        double[] eccentricitys = graph.eccentricityFinder(graph.floyd(g));
        double radius = graph.radiusFinder(eccentricitys);
        graph.printAnswer(eccentricitys,radius);
        
    }
}
