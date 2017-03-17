import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    //logname,resource,time(s)
    private static String configuration = "\ConfigAndLog\\Log.txt\n20\n60"; //declare configuration and path to the file
    private static String  config="\ConfigAndLog\\config.txt";
    public static void main(String[] args)throws FileNotFoundException {

        //for control time
        Calendar dating = Calendar.getInstance();
        SimpleDateFormat formating = new SimpleDateFormat("mm:ss:SSS");

        //read and split file
        FileWorker.write(config, configuration);
        String textFromFile = FileWorker.read(config);
        String[] configSettings = textFromFile.split("\n");

        //creat new Server
        new ServerThread(configSettings[2],configSettings[1],configSettings[0]).start();
        System.out.println( formating.format(dating.getTime()) +" Server Up");

        //print text from answer-file to console
        String textFromFile1 = FileWorker.read(configSettings[0]);
        System.out.println(textFromFile1);
    }
}
