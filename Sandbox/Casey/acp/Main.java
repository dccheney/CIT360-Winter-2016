package acp;


import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * Created by ke7mzp on 2/10/2016.
 */
public class Main {
    private static ApplicationController acp;
    public static void main(String[] args) throws Exception {
        acp = new ApplicationController();
        acp.mapCommand("LOGIN", new LoginHandler());
        acp.mapCommand("LOGOUT", new LogoutHandler());

        ServerSocket listener = new ServerSocket(9094);
        try {
//            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintStream out =
                            new PrintStream(socket.getOutputStream(), true);
                    JSONOutputStream outClient = new JSONOutputStream(out);
                    JSONInputStream input = new JSONInputStream(socket.getInputStream());

                    HashMap dataMap = (HashMap)input.readObject();
                    System.out.println(dataMap);
//                    HashMap dataMap = (HashMap)JSONUtilities.parse(s);
                    dataMap.put("toClient", outClient);
                    acp.handleRequest("LOGIN", dataMap);
                    acp.handleRequest("LOGOUT", dataMap);
                } catch (Exception e){
                    e.printStackTrace();
                }
                socket.close();
//            }
        }
        catch (Exception e){
            listener.close();
        }
        finally {
            listener.close();
            System.out.println("Exinting Server");
        }

    }
}
