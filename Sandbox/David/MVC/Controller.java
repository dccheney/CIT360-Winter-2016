package MVCPractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by David on 3/2/2016.
 */
public class Controller {

    private Model theModel;
    private View theView;

    public Controller(View theView, Model theModel){
        this.theView  = theView;
        this.theModel = theModel;

        this.theView.addInchesListener(new InchesListener());
        this.theView.addCMListener(new CMListener());
        this.theView.addYardsListener(new YardsListener());
    }

    class InchesListener implements ActionListener {
        public void calcToCM(double inches) {
            theModel.setCalculateCM(inches * 2.54);
        }
        public void calcToYards(double inches) { theModel.setCalculateYards(inches * .027); }

        @Override
        public void actionPerformed(ActionEvent e) {
            double inches = 0;

            try {
                inches = theView.getInchesVal();
                calcToCM(inches);
                theView.setCMAns(Math.round(theModel.getCMValue()*100.00)/100.0);
                calcToYards(inches);
                theView.setYardsAns(Math.round(theModel.getYardsValue()*100.00)/100.0);
                theView.setInchesAns(Math.round(inches*100.00)/100.0);
            }
            catch (NumberFormatException ex) {
                theView.displayErrorMessage("Must enter a value for Inches!");
            }
        }
    }

    class CMListener implements ActionListener {
        public void calcToInches(double cm) {
            theModel.setCalculateInches(cm * .394);
        }
        public void calcToYards(double cm) { theModel.setCalculateYards(cm * .0109361); }

        @Override
        public void actionPerformed(ActionEvent e) {
            double cm = 0;

            try {
                cm = theView.getCMVal();
                calcToInches(cm);
                theView.setInchesAns(Math.round(theModel.getInchesVal()*100.00)/100.0);
                calcToYards(cm);
                theView.setYardsAns(Math.round(theModel.getYardsValue()*100.00)/100.0);
                theView.setCMAns(Math.round(cm*100.00)/100.0);
            }
            catch (NumberFormatException ex) {
                theView.displayErrorMessage("Must enter a value for CM!");
            }
        }
    }

    class YardsListener implements ActionListener {
        public void calcToCM(double yards) {
            theModel.setCalculateCM(yards * 91.44);
        }
        public void calcToInches(double yards) { theModel.setCalculateInches(yards * 36); }

        @Override
        public void actionPerformed(ActionEvent e) {
            double yards = 0;

            try {
                yards = theView.getYardsVal();
                calcToCM(yards);
                theView.setCMAns(Math.round(theModel.getCMValue()*100.00)/100.0);
                calcToInches(yards);
                theView.setInchesAns(Math.round(theModel.getInchesVal()*100.00)/100.0);
                theView.setYardsAns(Math.round(yards*100.00)/100.0);
            }
            catch (NumberFormatException ex) {
                theView.displayErrorMessage("Must enter a value for Yards!");
            }
        }
    }

}
