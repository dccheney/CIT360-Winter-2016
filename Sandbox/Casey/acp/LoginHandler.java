package acp;

import org.quickconnectfamily.json.JSONOutputStream;

import java.util.HashMap;

/**
 * Created by ke7mzp on 2/10/2016.
 */
public class LoginHandler implements Handler {
    static{
        System.out.println("Hello Regester");
    }

    @Override
    public void handleIt(HashMap<String, Object> dataMap) {
        System.out.println("Hello test");
        try{
            JSONOutputStream outToClient = (JSONOutputStream)dataMap.remove("toClient");
            System.out.println("Just got:" + dataMap + " from client");
            dataMap.put("command", "Done");
            outToClient.writeObject(dataMap);
            System.out.println("just sent "+dataMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dataMap);
    }
}
