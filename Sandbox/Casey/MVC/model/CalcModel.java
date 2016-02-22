/**
 * 
 */
package MVC.model;

import java.util.ArrayList;

/**
 * @author Casey Moffett
 * @Date Jan 19, 2016
 *
 * @Copywright 2016
 */
public class CalcModel {
	private ArrayList<String> history;
	public CalcModel() {
		history = new ArrayList<>();
	}
	public ArrayList<String> getHistory() {
		return history;
	}
	public void setHistory(ArrayList<String> history) {
		this.history = history;
	}
	
	
	public void processEq(String s) {
		history.add(s);
	}
	
	public String getRHistory() {
		StringBuilder sb = new StringBuilder();
		for (int i = history.size() - 1, j = 0; i > 0 && j < 5; i--, ++j) {
			sb.insert(0, history.get(i) + '\n');
		}
		return sb.toString();
	}

}
