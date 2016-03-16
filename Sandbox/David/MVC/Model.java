package MVCPractice;

/**
 * Created by David on 3/2/2016.
 */
public class Model {
    // data
    private double inchesValue;
    private double cmValue;
    private double yardsValue;

    // methods to do calculations on the data
    public void setCalculateInches(double inchesValue) { this.inchesValue = inchesValue;}
    public void setCalculateCM(double cmValue) { this.cmValue = cmValue;}
    public void setCalculateYards(double yardsValue) { this.yardsValue = yardsValue;}

    // access data
    public double getInchesVal() { return inchesValue; }
    public double getCMValue() { return cmValue; }
    public double getYardsValue() { return yardsValue; }
}
