package MVCPractice;

// catch events
import java.awt.event.ActionListener;

// make an interface
import javax.swing.*;



/**
 * Created by Carissa on 2/10/2016.
 */
public class TemperatureView extends JFrame {
    /********************* TemperatureView **********************/
    // The Interface
    // visualization of the data that model contains
    /************************************************************/

    private JTextField celsiusTemp    = new JTextField(10);
    private JLabel celsiusLabel       = new JLabel("Celcius Temperature:");
    private JButton celsiusButton     = new JButton(" Calculate Fahrenheit");
    private JTextField fahrenheitAns  = new JTextField(10);
    private JLabel fahrenheitAnsLabel = new JLabel("Fahrenheit Temperature:");

    private JTextField fahrenheitTemp = new JTextField(10);
    private JLabel fahrenheitLabel    = new JLabel("Fahrenheit Temperature:");
    private JButton fahrenheitButton  = new JButton(" Calculate Celcius");
    private JTextField celsiusAns     = new JTextField(10);
    private JLabel celsiusAnsLabel    = new JLabel("Celcius Temperature:");

    TemperatureView() {

        // interface that is going to display on the screen
        JPanel tempPanel = new JPanel();

        // The application will close
        //The exit application default window close operation.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set size of pixels
        this.setSize(810, 200);

        // creates the display in the exact order added
        tempPanel.add(celsiusLabel);
        tempPanel.add(celsiusTemp);
        tempPanel.add(celsiusButton);
        tempPanel.add(fahrenheitAnsLabel);
        tempPanel.add(fahrenheitAns);

        tempPanel.add(fahrenheitLabel);
        tempPanel.add(fahrenheitTemp);
        tempPanel.add(fahrenheitButton);
        tempPanel.add(celsiusAnsLabel);
        tempPanel.add(celsiusAns);

        // add the panel to the JFrame
        this.add(tempPanel);

    }

    public double getCelsiusTemp() {
        return Double.parseDouble(celsiusTemp.getText());
       // return Integer.parseInt(celsiusTemp.getText());
    }

    public double getFahrenheitAns() {
        return Double.parseDouble(fahrenheitAns.getText());
    }

    public void setFahrenheitAns(double fAnswer) {
        fahrenheitAns.setText(Double.toString(fAnswer));
    }

    public double getFahrenheitTemp() {
        return Double.parseDouble(fahrenheitTemp.getText());
    }

    public double getCelsiusAns() {
        return Double.parseDouble(celsiusAns.getText());
    }
    public void setCelsiusAns(double cAnswer) {
        celsiusAns.setText(Double.toString(cAnswer));
    }

    // add a way whenever a button is clicked, the controller will be altered
    // not the view's job
    void addCelsiusListener(ActionListener listenerForCelsiusButton) {
        celsiusButton.addActionListener(listenerForCelsiusButton);
    }
    void addFahrenheitListener(ActionListener listenerForFahrenheitButton) {
        fahrenheitButton.addActionListener(listenerForFahrenheitButton);
    }

    //If the user clicks on the button without entering data
    //It(this) works as a reference to current object whose method
    // or constructor is being invoked. this keyword can be used to
    // refer any member of current object from within an instance
    // method or a constructor
    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }




}
