package APCsandbox;

import java.util.HashMap;


/**
 * Created by Carissa on 2/23/2016.
 */
public class ApplicationController {
    //Single handler for all kinds of requests coming to the
    // application (either web based/ desktop based).

    public static HashMap<String, Handler> handlerHashMap = new HashMap<String, Handler>();

    public ApplicationController() {
        handlerHashMap.put("Chocolate Chip", new ChocolateChip());
        handlerHashMap.put("Blueberry", new Blueberry());
        handlerHashMap.put("Banana Nut", new BananaNut());
        handlerHashMap.put("Apple Crumble", new AppleCrumble());


    }

   public static void handleUserCommand(String command, HashMap parameters) {

       Handler handler = handlerHashMap.get(command);
       if (handler != null) {
          handler.handleIt(parameters);
       }
   }























//    private Dispatcher dispatcher;
//    private HashMap<String,Handler> handlerHashMap = new HashMap();
//
//    public ApplicationController() {
//        dispatcher = new Dispatcher();
//    }
//
//    private boolean userAuthentication() {
//       // authentication logic
//        Scanner sc = new Scanner(System.in);
//        String password = "Muff!n$";
//        System.out.println("What is your password? ");
//        //ApplicationController controller = new ApplicationController();
//        //controller.dispatchRequest(sc.nextLine());
//        if (sc.nextLine() == password) {
//            System.out.println("Authenticated");
//            return true;
//        }
//        else {
//            System.out.println("Not Authenticated");
//            return false;
//        }
//    }
//
//    private void trackRequest(String request) {
//        System.out.println("Page requested: " + request);
//    }
//
//    public void dispatchRequest(String request) {
//        // log each request
//        trackRequest(request);
//
//        //user authentication
//        if(userAuthentication()) {
//            dispatcher.dispatch(request);
//        }
//    }

    //private void handleRequest(String request, HashMap<String, Obje>)


}
