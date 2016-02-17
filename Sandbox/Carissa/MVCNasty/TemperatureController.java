package MVCNasty;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Carissa on 2/10/2016.
 */
public class TemperatureController {
    /************************* TemperatureController *************************/
    // Acts on both the model and the view
    // controls data flow into model object
    // updates the view whenever data changes
    // keeps view and model seperate
    // handle actions between everything
    /**************************************************************************/

    private TemperatureModel theModel;
    private TemperatureView theView;

    public TemperatureController(TemperatureView theView, TemperatureModel theModel) {
        this.theView  = theView;
        this.theModel = theModel;

        //Whenever the button is clicked to execute the action performed method
        // refer to the object version of the view not the one passed into the constructor
        this.theView.addCelsiusListener(new CelsiusListener());
        this.theView.addFahrenheitListener(new FahrenheitListener());
    }

    // listen to the view
    class CelsiusListener implements ActionListener {



        // all the interaction is going to occur
        @Override
        public void actionPerformed(ActionEvent e) {

           double celsiusTemp = 0;

            try {
                //get whatever is in the View and store it
                celsiusTemp = theView.getCelsiusTemp();

                // has the model do its job of calculating
                theView.calcToFahrenheit(celsiusTemp);

                // go to the view in order to set the new solution but you
                // have to get the calculation from the model
                theView.setFahrenheitAns(Math.round(theModel.getCalculateFValue()*100.00)/100.0);
            }
            catch (NumberFormatException ex) {
                theView.displayErrorMessage("Must enter a value for Celsius Temperature!");
            }

        }
    }

    class FahrenheitListener implements ActionListener {

        public void calcToCelsius(double fahrenheitTemp) {

            theModel.setCalculateCValue((fahrenheitTemp - 32.0) * (5/9.0));
        }

        // all the interaction is going to occur
        @Override
        public void actionPerformed(ActionEvent e) {

            double fahrenheitTemp = 0;

            try {
                //get whatever is in the View and store it
                fahrenheitTemp = theView.getFahrenheitTemp();

                // has the model do its job of calculating
                calcToCelsius(fahrenheitTemp);

                // go to the view in order to set the new solution but you
                // have to get the calculation from the model
                theView.setCelsiusAns(Math.round(theModel.getCalculateCValue()*100.0)/100.0);
            }
            catch (NumberFormatException ex) {
                theView.displayErrorMessage("Must enter a value for Fahrenheit Temperature!");
            }

        }
    }
}
