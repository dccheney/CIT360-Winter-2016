package jsonpractice; /**
 * Created by Carissa on 1/26/2016.
        */
import org.quickconnectfamily.json.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.HashMap;


public class Jsontwo extends Customer {

    public static void main(String[] args) {
        Customer carissa = new Customer("Carissa", 22, "United States");

    try {
        String jsonString = JSONUtilities.stringify(carissa);
        System.out.println(jsonString);
    }
    catch (JSONException e) {
        e.printStackTrace();
    }

        // opens more possibilities of data indexing
        try {
            String obj1 = "{" +
                    "\"user\":\"Carissa\"," +
                    "\"age\":22," +
                    "\"country\":\"United States\" " +
                    "}";
            String obj2 = "{\"user\":\"Bob\",\"age\":\"22\"," +
                    "\"country\":\"United States\"}";

            HashMap aMap = (HashMap) JSONUtilities.parse(obj1);
            String user = (String)aMap.get("user");
            long age = (Long) aMap.get("age");
            String country = (String)aMap.get("country");

            Customer aNewCustomer = new Customer(user, age, country);
            System.out.println(obj1);
            System.out.println(obj2);

            File aFile = new File("D:\\CIT 360\\CIT 360\\test.txt");
            try {
                FileOutputStream aFileStream = new FileOutputStream(aFile);
                JSONOutputStream jsonOut = new JSONOutputStream(aFileStream);
                jsonOut.writeObject(aNewCustomer);
                jsonOut.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


        } catch (JSONException e1) {
            e1.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }




    }
}
