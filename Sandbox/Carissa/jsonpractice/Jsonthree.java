package jsonpractice;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;
import org.quickconnectfamily.json.ParseException;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

/**
 * Created by Carissa on 2/3/2016.
 */
public class Jsonthree extends CustomerOne {
    public static void main(String[] args) throws JSONException, ParseException {
        Item item1 = new Item("baseball", 3);
        CustomerOne carissa = new CustomerOne("Carissa", 22, "United States", item1);



        try {
            String jsonString = JSONUtilities.stringify(carissa);
            System.out.println(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String obj1 = "{" +
                "\"user\":\"Carissa\"," +
                "\"age\":22," +
                "\"country\":\"United States\",\"item\":{\"product\":\"hammer\",\"amount\":23}" +
                "}";
        String obj2 = "{" +
                "\"user\":\"Bob\"," +
                "\"age\":25," +
                "\"country\":\"Norway\", \"item\":{\"product\":\"wrench\",\"amount\":2}" +
                "}";

        System.out.println(obj1);
        System.out.println(obj2);

            HashMap aMap = (HashMap) JSONUtilities.parse(obj1);
            String user    = (String)aMap.get("user");
            long age       = (Long)aMap.get("age");
            String country = (String)aMap.get("country");
            String product = (String)aMap.get("product");
//            long amount    = (Long)aMap.get("amount");
//
            CustomerOne aNewCustomer = new CustomerOne(user, age, country, item1);


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


    }
}
