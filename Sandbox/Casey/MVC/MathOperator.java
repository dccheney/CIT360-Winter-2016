package MVC;

public enum MathOperator {
	ADD('+'), SUBTRACT('-'), MULTIPY('*'), DIVIDE('/'), MOD('%');
	
	private char symbol;
	private MathOperator(char c) {
		symbol = c;
	}
	
	public String getSymbol() {
		return " " + symbol + " ";
	}

}
