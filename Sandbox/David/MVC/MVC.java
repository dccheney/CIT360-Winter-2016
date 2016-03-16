package MVCPractice;

/**
 * Created by David on 3/2/2016.
 */
public class MVC {
    public static void main(String[] args) {
        Model theModel = new Model();
        View theView = new View();
        Controller theController  = new Controller(theView, theModel);


        theView.setVisible(true);
    }
}
