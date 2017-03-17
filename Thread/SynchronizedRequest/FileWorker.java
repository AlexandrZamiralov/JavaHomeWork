import java.io.*;

public class FileWorker {
    public static void write(String fileName, String text) {
        //Create new File
        File file = new File(fileName);

        try {
            //if file not exists, lets create them
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter help us to write in file
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Lets print!
                out.print(text);
            } finally {
                //We need(!) close file
                //because else nothing print
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String read(String fileName) throws FileNotFoundException {
        //StringBuilder not re-creates itself in contrast to the String
        StringBuilder stringBuilderForFile = new StringBuilder();

        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }

        try {
            //BufferedReader help us to read file
            BufferedReader bufferedTextInFile = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //read file
                String stringInFile;
                while ((stringInFile = bufferedTextInFile.readLine()) != null) {
                    stringBuilderForFile.append(stringInFile);
                    stringBuilderForFile.append("\n");
                }
            } finally {
                //close file
                bufferedTextInFile.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //return readed text
        return  stringBuilderForFile.toString();
    }
}
