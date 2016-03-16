package APC;

import java.util.HashMap;

/**
 * Created by David on 3/15/2016.
 */
public class ApplicationController {
    public static HashMap<String, Handler> handlerHashMap = new HashMap<String, Handler>();

    public ApplicationController() {
        handlerHashMap.put("Tuneup", new Tuneup());
        handlerHashMap.put("Advanced Tuneup", new AdvancedTuneup());
        handlerHashMap.put("Screen Replacement", new ScreenReplacement());
        handlerHashMap.put("Reinstall OS", new ReinstallOS());
        handlerHashMap.put("250GB SSD upgrade", new SSDUpgrade());
    }
    public static void handleUserCommand(String command, HashMap parameters) {
        Handler handler = handlerHashMap.get(command);
        if(handler != null) {
            handler.handleIt(parameters);
        }
    }
}
