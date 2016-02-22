package MVC.view;

public interface CalcView {
	public void showHistory(String[] hist);
	public void showHistory(String hist);
	public void showHistory(int x, String[] hist);
	public void showAnswer(String ans);
	public void showCurrentEquation(String eq);
	public void launchView();
}
