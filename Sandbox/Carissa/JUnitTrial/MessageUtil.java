package JUnitTrial;

/**
 * Created by Carissa on 2/8/2016.
 */
public class MessageUtil {
    private String message;

    //Contructor
    public MessageUtil(String message) {
        this.message = message;
    }

    //prints the message
    public String printMessage(){
        System.out.println(message);
        return message;
    }

}
