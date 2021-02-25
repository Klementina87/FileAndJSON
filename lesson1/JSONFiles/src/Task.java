import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import jdk.internal.access.JavaIOFileDescriptorAccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class Task {
    public static void main(String[] args) {
        Task t = new Task();
        JsonObject doc = t.readJson("./resources/restaurant-data.json");
        Database db = new Database(doc);
        System.out.println(db.getRestaurant("Hometown BBQ"));
        System.out.println(db.getAvgReviews("Casa Enrique"));
    }

    public JsonObject readJson(String filename) {

            String content = readFile(filename);
            JsonObject document = (JsonObject) Jsoner.deserialize(content, new JsonObject());
            JsonArray ja = (JsonArray) document.get("restaurants");
            JsonObject first = (JsonObject) ja.get(0);
            String name = (String)first.get("name");
            System.out.println(name);

        /* TODO: create a JSON object with the contents of  "filename". You can use the method below to help you read the file. */
        return document;
    }

  public String readFile(String filename){
      String content = "";
      try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
          String result = reader.readLine();
          while(result != null){
              content += result;
              result= reader.readLine();
          }
          /* Put in code to read the file line by line. */
      } catch(IOException e) {
          e.printStackTrace();
          System.exit(-1);
      }
      return content; /* Put in the variable that should be returned. */
  }
}