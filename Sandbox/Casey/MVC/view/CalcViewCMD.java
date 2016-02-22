/**
 * 
 */
package MVC.view;

import java.util.Scanner;

import MVC.Calculator;

/**
 * @author Casey Moffett
 * @Date Jan 20, 2016
 *
 * @Copywright 2016
 */
public class CalcViewCMD implements CalcView {
	Scanner input;

	@Override
	public void showHistory(String[] hist) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showHistory(String hist) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showHistory(int x, String[] hist) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showAnswer(String ans) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showCurrentEquation(String eq) {
		// TODO Auto-generated method stub

	}

	@Override
	public void launchView() {
		input = new Scanner(System.in);
		System.out.println("Lets do some Math:");
		boolean cont = true;
		do {
			System.out.println("Enter E to exit");
			System.out.print("Enter an equation: ");
			String s = input.nextLine();
			if (s.toUpperCase().trim().charAt(0) == 'E') {
				cont = false;
			}else if (s.toUpperCase().trim().charAt(0) == 'V') {
				Calculator.getActiveControler().regesterView(new CalcViewFX());
				Calculator.getActiveControler().showView();
			}else {
				String v = Calculator.getActiveControler().calculate(s);
				System.out.println(v);
			}
				
		} while(cont);
	}
}
