package JSON;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Exchanger;

/**
 * Created by Carissa on 3/3/2016.
 */

public class JSONsandbox {

    public static void main(String[] args) {

        File aFile = new File("D:\\CIT 360\\CIT 360\\test2.json");

        try {
            //sending a FileOutputStream object to the constructor of the JSONOutputStream.
            FileOutputStream aFileStream = new FileOutputStream(aFile);
            JSONOutputStream jsonOut = new JSONOutputStream(aFileStream);
            //Serializable aSerializableObject = null;
            //jsonOut.writeObject(aSerializableObject);

            JSONmovies movie1 = new JSONmovies("Raiders of the Lost Ark", "Action", "PG", 1981);
            JSONmovies movie2 = new JSONmovies("Pride and Prejudice", "Drama", "PG", 2005);
            JSONmovies movie3 = new JSONmovies("The Lego Movie", "Animation", "PG", 2014);
            JSONmovies movie4 = new JSONmovies("Monty Python and the Holy Grail", "Comedy", "PG", 1975);

            // writes data into a file
            jsonOut.writeObject(movie1);

            jsonOut.writeObject(movie2);
            jsonOut.writeObject(movie3);
            jsonOut.writeObject(movie4);
            jsonOut.close();

            try {
                FileInputStream aFileInStream = new FileInputStream(aFile);
                JSONInputStream jsonIn = new JSONInputStream(aFileInStream);

                //jsonIn.readObject reads data and store it to a hashmap
                HashMap jsonMap = (HashMap) jsonIn.readObject();
                HashMap jsonMap2 = (HashMap) jsonIn.readObject();
                HashMap jsonMap3 = (HashMap) jsonIn.readObject();
                HashMap jsonMap4 = (HashMap) jsonIn.readObject();
                System.out.println("**********************");
                System.out.println(jsonMap.toString());
                System.out.println(jsonMap2.toString());
                System.out.println(jsonMap3.toString());
                System.out.println(jsonMap4.toString());
                System.out.println("\n");

                //JSON String representation of an instance of the Movie class
                //keys == class attribute names
                //values == instances
                String jsonString = JSONUtilities.stringify(movie1);
                System.out.println(jsonString);
                String jsonString2 = JSONUtilities.stringify(movie2);
                System.out.println(jsonString2);
                String jsonString3 = JSONUtilities.stringify(movie3);
                System.out.println(jsonString3);
                String jsonString4 = JSONUtilities.stringify(movie4);
                System.out.println(jsonString4 + "\n\n\n");


                //To convert a JSON string to an instance you use the
                //JSONUtilities.parse method passing it the JSON string to be converted

                HashMap parseMap = (HashMap) JSONUtilities.parse(jsonString);
                System.out.println(parseMap);
                parseMap = (HashMap) JSONUtilities.parse(jsonString2);
                System.out.println(parseMap);
                parseMap = (HashMap) JSONUtilities.parse(jsonString3);
                System.out.println(parseMap);
                parseMap = (HashMap) JSONUtilities.parse(jsonString4);
                System.out.println(parseMap);
                System.out.println("\n\n");

                /******************Happy Path******************/
                Iterator it = jsonMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    System.out.println(pair.getKey() + " = " + pair.getValue());
                }
                System.out.println(jsonMap.get("title"));

                //comapares data
                JSONmovies readObject1 = new JSONmovies(jsonMap);

                System.out.println(readObject1.equals(movie1));
                System.out.println(readObject1.equals(movie2));
                System.out.println(readObject1.equals(movie3));
                System.out.println(readObject1.equals(movie4));
                System.out.println(readObject1);


                /*****************Nasty Paths*******************/
                System.out.println("/*************Nasty Path1**************/");
                try {
                    JSONmovies movie5 = new JSONmovies(null, null, null, null);
                    jsonOut.writeObject(movie5);

                    String jsonString5 = JSONUtilities.stringify(movie5);
                    System.out.println(jsonString5);
                } catch (Exception e) {
                    //e.printStackTrace();
                    System.out.println("Null does not work");
                }

                System.out.println("\n" + "/*************Nasty Path2**************/");
                try {
                    JSONmovies movie6 = new JSONmovies("", "Comedy", "PG", 200);
                    jsonOut.writeObject(movie6);

                    String jsonString6 = JSONUtilities.stringify(movie6);
                    System.out.println(jsonString6);
                } catch (Exception e) {
                    //e.printStackTrace();
                    System.out.println("Empty String does not work");
                }

                System.out.println("\n" + "/*************Nasty Path3**************/");
                try {
                    JSONmovies movie7 = new JSONmovies("\n", "Comedy", "PG", 200);
                    jsonOut.writeObject(movie7);

                    String jsonString7 = JSONUtilities.stringify(movie7);
                    System.out.println(jsonString7);
                } catch (Exception e) {
                    //e.printStackTrace();
                    System.out.println("New Line does not work");
                }
                System.out.println("\n" +"/********************Nasty Path 4************************/");
                try {
                    String movie8 = "{" +
                            "\"title\":\"Carissa\"," +
                            "\"genre\":\"Comedy\",&&#**(#@*($&#@$Globbity Gloop349827234";
                    HashMap parseMap8 = (HashMap) JSONUtilities.parse(movie8);
                    System.out.println(parseMap8);
                } catch (Exception ex) {
                    System.out.println("Globbity Gloop does not work as a JSON string");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
