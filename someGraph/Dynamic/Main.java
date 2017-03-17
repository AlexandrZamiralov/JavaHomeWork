import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import static com.company.Main.writer;
import static java.lang.Integer.min;

public class Main {

    public static void main(String[] args) {
                int n = 3;
        int m = 3;
        Vertices [][] matrixOfDistance = new Vertices [n][m];
        int[][] matrixOfValues = new int[n][m];
        System.out.println("Исходная матрица");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixOfValues[i][j] = randomNumbers();
                matrixOfDistance[i][j] = new Vertices(i,j);
                System.out.print(matrixOfValues[i][j] + " ");
            }
            System.out.println();
        }

        
        matrixOfDistance[0][0] =new Vertices(matrixOfValues[0][0],0,0);
        Queue<Vertices> distancesPriorityQueue = new PriorityQueue<>(1, distanceComparator);        distancesPriorityQueue.add(matrixOfDistance[0][0]);

       
        //WARNING!!! 4 COPY-PASTE
        while (!distancesPriorityQueue.isEmpty()) {
            Vertices vertx = distancesPriorityQueue.poll();
            if(vertx.i-1>0){
                int a =vertx.distance + matrixOfValues[vertx.i-1][vertx.j];
                matrixOfDistance[vertx.i-1][vertx.j].distance= min(matrixOfDistance[vertx.i-1][vertx.j].distance, a);
                if (matrixOfDistance[vertx.i-1][vertx.j].distance==a){
                    matrixOfDistance[vertx.i-1][vertx.j].previous=vertx;
                }
                matrixOfDistance[vertx.i-1][vertx.j].i=vertx.i-1;
                matrixOfDistance[vertx.i-1][vertx.j].j=vertx.j;
                if(matrixOfDistance[vertx.i-1][vertx.j].flag) {
                    distancesPriorityQueue.add(matrixOfDistance[vertx.i - 1][vertx.j]);
                }

            }
            if(vertx.i+1<n){
               int b = vertx.distance + matrixOfValues[vertx.i+1][vertx.j];
                matrixOfDistance[vertx.i+1][vertx.j].distance= min(matrixOfDistance[vertx.i+1][vertx.j].distance, b);
                if(matrixOfDistance[vertx.i+1][vertx.j].distance==b){
                    matrixOfDistance[vertx.i+1][vertx.j].previous=vertx;
                }
                matrixOfDistance[vertx.i+1][vertx.j].i=vertx.i+1;
                matrixOfDistance[vertx.i+1][vertx.j].j=vertx.j;
                if(matrixOfDistance[vertx.i+1][vertx.j].flag) {
                    distancesPriorityQueue.add(matrixOfDistance[vertx.i + 1][vertx.j]);
                }

            }
            if(vertx.j-1>0){
                int c =vertx.distance + matrixOfValues[vertx.i][vertx.j-1];
                matrixOfDistance[vertx.i][vertx.j-1].distance= min(matrixOfDistance[vertx.i][vertx.j-1].distance, c);
                if(matrixOfDistance[vertx.i][vertx.j-1].distance==c){
                    matrixOfDistance[vertx.i][vertx.j-1].previous=vertx;
                }
                matrixOfDistance[vertx.i][vertx.j-1].i=vertx.i;
                matrixOfDistance[vertx.i][vertx.j-1].j=vertx.j-1;
                if(matrixOfDistance[vertx.i][vertx.j-1].flag) {
                    distancesPriorityQueue.add(matrixOfDistance[vertx.i][vertx.j - 1]);
                }

            }
            if(vertx.j+1<m){
                int d =vertx.distance + matrixOfValues[vertx.i][vertx.j+1];
                matrixOfDistance[vertx.i][vertx.j+1].distance=min(matrixOfDistance[vertx.i][vertx.j+1].distance, d);
                if(matrixOfDistance[vertx.i][vertx.j+1].distance==d){
                    matrixOfDistance[vertx.i][vertx.j+1].previous=vertx;
                }
                matrixOfDistance[vertx.i][vertx.j+1].i=vertx.i;
                matrixOfDistance[vertx.i][vertx.j+1].j=vertx.j+1;
            if(matrixOfDistance[vertx.i][vertx.j+1].flag) {
                    distancesPriorityQueue.add(matrixOfDistance[vertx.i][vertx.j + 1]);
                }
            }
            vertx.flag=false;
        }
        System.out.println("Матрица расстояний ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrixOfDistance[i][j].distance + " ");
            }
            System.out.println();
        }
        System.out.println(" Путь");
        writer(matrixOfDistance[n-1][m-1]);
    }




    public static int randomNumbers() {
        Random numbers = new Random();
        return numbers.nextInt(10);
    }
    public static void writer(Vertices vertx){
        while(!(vertx==null)){
            System.out.println("i= "+vertx.i+" j= "+vertx.j+" dist= "+vertx.distance);
            vertx=vertx.previous;
        }
    }
    
    public static Comparator<Vertices> distanceComparator = new Comparator<Vertices>() {

        @Override
        public int compare(Vertices c1, Vertices c2) {
            return (int) (c1.distance - c2.distance);
        }
    };

    }
