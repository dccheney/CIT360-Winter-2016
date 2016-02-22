/**
 * 
 */
package MVC;

import MVC.control.CalcControler;
import MVC.model.CalcModel;
import MVC.view.CalcViewCMD;
import MVC.view.CalcViewFX;

/**
 * @author Casey Moffett
 * @Date Jan 19, 2016
 *
 * @Copywright 2016
 */
public class Calculator {
	static CalcControler c;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		boolean gui = true;
		boolean gui = false;
		c = new CalcControler();
		c.regesterModel(new CalcModel());
		if (gui)
			c.regesterView(new CalcViewFX());
		else
			c.regesterView(new CalcViewCMD());
		c.showView();

	}
	public static CalcControler getActiveControler() {
		return c;
	}

}
