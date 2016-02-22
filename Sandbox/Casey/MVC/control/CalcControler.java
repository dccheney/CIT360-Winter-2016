/**
 * 
 */
package MVC.control;

import MVC.model.CalcModel;
import MVC.view.CalcView;

/**
 * @author Casey Moffett
 * @Date Jan 19, 2016
 *
 * @Copywright 2016
 */
public class CalcControler {

	CalcModel mod;
	CalcView view;

	public CalcControler() {
		// this(new CalcModel(), new CalcViewFX());

	}

	public CalcControler(CalcModel c, CalcView v) {
		mod = c;
		view = v;
		this.view.launchView();
	}

	public void regesterView(CalcView v) {
		view = v;
	}

	public void showView() {
		view.launchView();
	}

	public String calculate(String eg) {
		String[] e = eg.split("(\\+|\\-|\\*|\\/|\\%)");
		String sym = eg.replaceAll("(\\d|\\.)", "");
		double one = Double.parseDouble(e[0]);
		double two = Double.parseDouble(e[1]);
		double rvalue = 0;
		switch (sym.trim()) {
		case "-":
			rvalue = one - two;
			break;
		case "+":
			rvalue = one + two;
			break;
		case "*":
			rvalue = one * two;
			break;
		case "/":
			rvalue = one / two;
			break;
		case "%":
			rvalue = one % two;
			break;
		}
		mod.processEq(eg);
		return rvalue + "";
		
	}
	
	public String getHistory() {
		return mod.getRHistory();
	}

	public void regesterModel(CalcModel m) {
		mod = m;
	}

}
