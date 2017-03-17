import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ServerThread extends Thread {
    //another time control
    Calendar dating = Calendar.getInstance();
    SimpleDateFormat formating = new SimpleDateFormat("mm:ss:SSS");

    //answer-string
    StringBuilder toLog = new StringBuilder();
    //most important in server. maybe we can declare "volontile"?

    public  int resource;
    //for generation requests

    public int maxResource;

    public  long time;
    //path to the file-answer
    public  String logName;
    public  long startTime = System.currentTimeMillis();
    //constructor
    public ServerThread(String startResource,String livingTime,String logName){
        this.resource=Integer.valueOf(startResource);
        this.time=Long.valueOf(livingTime);
        this.logName=logName;
        this.maxResource=Integer.valueOf(startResource);
    }

    @Override
    public void run(){
        //new generator for this server
        new RequestsGenerator(time,maxResource,this).start();
        try {
            Thread.sleep(time);
            //we can write next 2 string in another place
            FileWorker.write(logName, toLog.toString());
            System.out.println(formating.format(dating.getTime()) + " Server Down");
        }
        catch(InterruptedException e){
            System.out.println("something(Server) doing wrong");
        }
    }

//add new request to answer
    synchronized public void setToLog(Request request,String string){
        toLog.append("Time: "+(time-(System.currentTimeMillis() - startTime))+" Reuired resource: "+request.requiredResource+" Reuired time: "
                +request.requiredTime+" Resource: "+request.server.resource+string+"\n");
    }
    //-res
    synchronized public boolean resourceSteal(Request request){
        if (((resource - request.requiredResource)>0)&&(((System.currentTimeMillis() - startTime)) +request.requiredTime)<time) {
            setToLog(request, " +");
        resource-=request.requiredResource;
            return true;
    }
        else {
            setToLog(request," -");
            return false;
        }
    }

    //+res
    synchronized public void resourceReturn(Request request){
        resource+=request.requiredResource;
    }
    }
