package MVCPractice;

import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Created by David on 3/2/2016.
 */
public class View extends JFrame{

    private JTextField inchesVal    = new JTextField(10);
    private JLabel inchesLabel      = new JLabel("Inches:");
    private JButton inchesButton    = new JButton("Calculate CM & Yards");
    private JTextField inchesAns    = new JTextField(10);
    private JLabel inchesAnsLabel   = new JLabel("Inches:");

    private JTextField cmVal        = new JTextField(10);
    private JLabel cmLabel          = new JLabel("CM:");
    private JButton cmButton        = new JButton("Calculate Inches & Yards");
    private JTextField cmAns        = new JTextField(10);
    private JLabel cmAnsLabel       = new JLabel("CM:");

    private JTextField yardsVal     = new JTextField(10);
    private JLabel yardsLabel       = new JLabel("Yards:");
    private JButton yardsButton     = new JButton("Calculate Inches & CM");
    private JTextField yardsAns     = new JTextField(10);
    private JLabel yardsAnsLabel    = new JLabel("Yards:");


    View() {
        JPanel convPanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(1000, 100);

        convPanel.add(inchesLabel);
        convPanel.add(inchesVal);
        convPanel.add(inchesButton);


        convPanel.add(cmLabel);
        convPanel.add(cmVal);
        convPanel.add(cmButton);


        convPanel.add(yardsLabel);
        convPanel.add(yardsVal);
        convPanel.add(yardsButton);


        convPanel.add(inchesAnsLabel);
        convPanel.add(inchesAns);
        convPanel.add(cmAnsLabel);
        convPanel.add(cmAns);
        convPanel.add(yardsAnsLabel);
        convPanel.add(yardsAns);


        this.add(convPanel);
    }

    public double getInchesVal()              { return Double.parseDouble(inchesVal.getText()); }
    //public double getInchesAns()              { return Double.parseDouble(inchesAns.getText()); }
    public void setInchesAns(double iAnswer)  { inchesAns.setText(Double.toString(iAnswer)); }
    public double getCMVal()                  { return Double.parseDouble(cmVal.getText()); }
    //public double getCMAns()                  { return Double.parseDouble(cmAns.getText()); }
    public void setCMAns(double cmAnswer)     { cmAns.setText(Double.toString(cmAnswer)); }
    public double getYardsVal()                  { return Double.parseDouble(yardsVal.getText()); }
    //public double getYardsAns()                  { return Double.parseDouble(yardsAns.getText()); }
    public void setYardsAns(double yAnswer)     { yardsAns.setText(Double.toString(yAnswer)); }


    void addInchesListener(ActionListener listenForInchesButton) { inchesButton.addActionListener(listenForInchesButton); }
    void addCMListener(ActionListener listenForCMButton) { cmButton.addActionListener(listenForCMButton); }
    void addYardsListener(ActionListener listenForYardsButton) { yardsButton.addActionListener(listenForYardsButton); }

    void displayErrorMessage(String errorMessage) { JOptionPane.showMessageDialog(this, errorMessage); }
}
