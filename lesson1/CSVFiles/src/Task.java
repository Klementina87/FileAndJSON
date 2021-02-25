import java.io.*;

public class Task {
    public static void main(String[] ar) {
        Task t = new Task();
        Database d = t.readCSV("./resources/iris.data");
    }

    public Database readCSV(String filename) {
        String contents = "";
        Database db = null;
        try
                (InputStream in = new BufferedInputStream(new FileInputStream(filename))){

                byte[] buffer = new byte[1024];
                int lengthRead;
                /*create a while loop to read the contents of the file and put them in the variable"contents" declared at the beginning*/
                while((lengthRead = in.read(buffer)) > 0){
                    String result = new String(buffer);
                    contents += result;
                }
               db = new Database(contents);

        }catch(IOException e){
                e.printStackTrace();
            }
        return db;/*must return a Database object initialized with the contents read*/
    }
}



















