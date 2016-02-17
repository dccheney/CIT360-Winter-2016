package MVCNasty;

/**
 * Created by Carissa on 2/10/2016.
 */
public class MVC {

    /**************************** MVC *******************************/
    // Seperates the calculations and interface from each other
    /****************************************************************/

    public static void main(String[] args) {

        TemperatureView theView   = new TemperatureView();
        TemperatureModel theModel = new TemperatureModel();
        TemperatureController theController = new TemperatureController(theView, theModel);

        theView.setVisible(true);
    }
}
