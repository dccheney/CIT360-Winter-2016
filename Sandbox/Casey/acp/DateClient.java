package acp;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONUtilities;
import org.quickconnectfamily.json.ParseException;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

import javax.swing.JOptionPane;

/**
 * Trivial client for the date server.
 */
public class DateClient {

    /**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the date server, then connects to it and displays the date that
     * it serves.
     */
    public static void main(String[] args) throws IOException, JSONException, ParseException {
        String serverAddress = JOptionPane.showInputDialog(
                "Enter IP Address of a machine that is\n" +
                        "running the date service on port 9090:");
        Socket s = new Socket(serverAddress, 9090);
        JSONInputStream input = new JSONInputStream(s.getInputStream());
//        BufferedReader input =
//                new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out =
                new PrintWriter(s.getOutputStream(), true);
        Login userL = new Login();
        userL.setuName("User");
        userL.setPassword("pa$$w0rd");
        String userDataToSend = JSONUtilities.stringify(userL);
        out.print(userDataToSend);
        HashMap answer = (HashMap) input.readObject();
        System.out.println(answer);
        s.close();
        System.exit(0);
    }
}