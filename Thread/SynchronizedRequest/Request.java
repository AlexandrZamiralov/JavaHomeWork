
public class Request extends Thread {
    public int requiredResource;
    public long requiredTime;
    public ServerThread server;

    //constructor
    public Request(int resource, long time,ServerThread server){
        this.requiredResource=resource;
        this.requiredTime=time;
        this.server=server;
    }

    @Override
    public void run() {

        if (server.resourceSteal(this)){
            try {
                Thread.sleep(requiredTime);
            } catch (InterruptedException e) {
                System.out.println("something(Request) doing wrong");
            }
            server.resourceReturn(this);
        }
    }

    }
