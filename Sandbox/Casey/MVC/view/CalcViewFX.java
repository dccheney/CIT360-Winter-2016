/**
 * 
 */
package MVC.view;

import MVC.Calculator;
import MVC.MathOperator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Casey Moffett
 * @Date Jan 19, 2016
 *
 * @Copywright 2016
 */
public class CalcViewFX extends Application implements CalcView {
	private Button btnEquals;
	private Button[] modelButtons;
	private TextField currentEq;
	private TextArea history;
	private boolean dump;

	public CalcViewFX() {
		dump = false;
	}

	public static void launchCalcViewFX(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage1) throws Exception {
		GridPane root = new GridPane();

		history = new TextArea();
		history.setMinHeight(100);
		history.setMaxWidth(150);
		root.add(history, 1, 0);
		currentEq = new TextField();
		root.add(currentEq, 1, 1);
		GridPane number = new GridPane();
		modelButtons = new Button[15];
		for (int i = 0; i < 10; i++) {
			modelButtons[i] = new Button(i + "");
		}
		MathOperator[] list = MathOperator.values();
		for (int i = 10; i < list.length + 10; i++) {
			modelButtons[i] = new Button(list[i - 10].getSymbol());
		}
		for (int i = 0, j = 9; i < 3; i++) {
			for (int k = 0; k < 3 && j > 0; ++k, --j) {
				number.add(modelButtons[j], k, i);
			}
		}
		number.add(modelButtons[0], 1, 3);
		number.add(modelButtons[10], 4, 0);
		number.add(modelButtons[11], 4, 1);
		number.add(modelButtons[12], 4, 2);
		number.add(modelButtons[13], 0, 3);
		number.add(modelButtons[14], 2, 3);
		btnEquals = new Button(" = ");
		number.add(btnEquals, 4, 3);
		regesterModelButtonsListener();
		regesterProcessListener();
		root.add(number, 1, 2);
		Scene s1 = new Scene(root);
		stage1.setScene(s1);
		stage1.setTitle("MVC Calculator");
		stage1.show();
	}

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

	private void regesterProcessListener() {
		btnEquals.setOnAction(e -> {
			dump = true;
			currentEq.setText(Calculator.getActiveControler().calculate(
					currentEq.getText()));
			history.setText(Calculator.getActiveControler().getHistory());
//			System.out.println(Calculator.getActiveControler().getHistory());
		});
	}

	private void regesterModelButtonsListener() {
		for (int i = 0; i < modelButtons.length; i++) {
			modelButtons[i].setOnAction(e -> {
				if (this.dump) {
					if (((Button) e.getSource()).getText().trim().matches(
							"(\\+|\\-|\\*|\\/|\\%)")) {
						System.out.println("True");
						dump = false;
					}else {
						dump = false;
						this.currentEq.setText("");
					}
				}
				currentEq.setText(currentEq.getText()
						+ ((Button) e.getSource()).getText());

			});
			modelButtons[i].setMinWidth(30);
		}
	}

	@Override
	public void showCurrentEquation(String eq) {
		currentEq.setText(eq);

	}

	@Override
	public void launchView() {
		CalcViewFX.launchCalcViewFX(new String[1]);

	}

}
