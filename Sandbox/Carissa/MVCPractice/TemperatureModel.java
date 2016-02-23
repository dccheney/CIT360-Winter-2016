package MVCPractice;

/**
 * Created by Carissa on 2/10/2016.
 */
public class TemperatureModel {
    /******************** TemperatureModel *********************/
    // object or POJO carrying data
    // logic to update controller if its data changes
    // data and Methods used to work with it
    // holds calculations
    // doesn't know the view exists
    /**********************************************************/

    // the data
    private double calculateFValue;
    private double calculateCValue;

    // All the methods to perform the calculations on the data


    public void setCalculateFValue(double calculateFValue) {
        this.calculateFValue = calculateFValue;
    }

    public void setCalculateCValue(double calculateCValue) {
        this.calculateCValue = calculateCValue;
    }

    // access to the data
    public double getCalculateFValue() {
        return calculateFValue;
    }

    public double getCalculateCValue() {
        return calculateCValue;
    }
}
