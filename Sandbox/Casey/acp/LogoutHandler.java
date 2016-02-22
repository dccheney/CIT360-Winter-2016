package acp;

import java.util.HashMap;

/**
 * Created by ke7mzp on 2/10/2016.
 */
public class LogoutHandler implements Handler{
    @Override
    public void handleIt(HashMap<String, Object> data) {
        System.out.println("User Logged out");
    }
}
