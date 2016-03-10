import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by brian on 3/9/16.
 */
public class WebHandler implements Handler
{
    @Override
    public void handleIt(HashMap<String, Object> data)
    {
        HttpServletResponse outToClient = (HttpServletResponse)data.remove("toClient");
        PrintWriter out = null;
        try
        {
            out = outToClient.getWriter();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        outToClient.setContentType("text/html");
        out.println("<h1>HelloWorld</h1>");

    }
}
