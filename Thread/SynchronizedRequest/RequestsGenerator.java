import java.util.Random;

public class RequestsGenerator extends Thread {
    long maxTime;
    int maxResource;
    ServerThread server;

    final Random random = new Random();
    //constructor
  public RequestsGenerator(long maxTime, int maxResource,ServerThread server){
        this.maxTime=maxTime;
        this.maxResource=maxResource;
        this.server=server;
    }
    @Override
    public void run() {
        //while server isAlive
        while((System.currentTimeMillis() - server.startTime)<server.time){
            //generate new request
                new Request(random.nextInt(maxResource), (long)(random.nextDouble()*maxTime), server).start();
        }

    }
}
