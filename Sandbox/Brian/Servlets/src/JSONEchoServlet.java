import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;


@WebServlet(name = "JSONEchoService", urlPatterns = {"/json"})
public class JSONEchoServlet extends HttpServlet
{
    private ApplicationController theAppController = new ApplicationController();

    public void init()
    {
        theAppController.mapCommand("Speak", new SpeakHandler());
        theAppController.mapCommand("web", new WebHandler());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getHeader("User-Agent"));

        try
        {
            HashMap<String, Object> dataMap;

            if (request.getHeader("User-Agent".toLowerCase()).matches("(java)|(android)"))
            {
                JSONInputStream inFromClient = new JSONInputStream(request.getInputStream());
                JSONOutputStream outToClient = new JSONOutputStream(response.getOutputStream());

                dataMap = (HashMap) inFromClient.readObject();

                dataMap.put("toClient", outToClient);
            }
            else
            {
                dataMap = new HashMap<>();
                dataMap.put("toClient", response);
                dataMap.put("command", request.getParameter("command"));
            }

            String aCommand = (String) dataMap.get("command");
            theAppController.handleRequest(aCommand, dataMap);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
//        System.out.println(request.getHeader("User-Agent"));
//
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<h1>Some Text</h1>");
    }
}
