/**
 * 
 */
package sandbox.junit;

import java.text.ParseException;

/**
 * @author Casey Moffett
 * @Date Dec 10, 2015
 *
 * @Copywright 2015
 */
public class MyInteger implements Comparable<MyInteger>{
	private int value;
	private int abs;

	/**
	 * Creates an object MyInteger with a specified value
	 */
	public MyInteger(int i) {
		this.value = i;
		this.abs = Math.abs(i);
	}

	/**
	 * tests to see if this is even
	 * @return
	 */
	public boolean isEven() {
		return value % 2 == 0;
	}

	/**
	 * tests to see if this is odd
	 * @return
	 */
	public boolean isOdd() {
		return value % 2 == 1;
	}

	/**
	 * Tests to see if this is Prim
	 * @return
	 */
	public boolean isPrime() {
		int top = (int) Math.sqrt(value) + 1;
		if (isEven())
			return false;
		for (int i = 3; i < top; i += 2) {
			if (abs % i == 0)
				return false;
		}
		return true;
	}

	public static boolean isEven(MyInteger i) {
		return i.value % 2 == 0;
	}

	public static boolean isOdd(MyInteger i) {
		return i.value % 2 == 1;
	}

	/**
	 * Tests to see if an instance of MyInteer is prime
	 * @param i
	 * @return
	 */
	public static boolean isPrime(MyInteger i) {
		int top = (int) Math.sqrt(i.value) + 1;
		if (i.isEven()) {
			return false;
		}
		for (int j = 3; j < top; j += 2) {
			if (i.abs % j == 0)
				return false;
		}
		return true;
	}

	
	public static boolean isEven(int i) {
		return i % 2 == 0;
	}

	public static boolean isOdd(int i) {
		return i % 2 == 1;
	}
	public static int abs(int i) {
		if (i < 0) {
			i *= -1;
		}
		return i;
	}
	
	public static int abs(MyInteger i) {
		int x;
		if (i.value < 0) {
			x = i.value -1;
		}else {
			x = i.value;
		}
		return x;
	}
	
	public int abs() {
		return abs;
	}

	/**
	 * Tests to see if an instance of MyInteer is prime
	 * @param i
	 * @return
	 */
	public static boolean isPrime(int i) {
		int top = (int) Math.sqrt(i) + 1;
		if (isEven(i)) {
			return false;
		}
		for (int j = 3; j < top; j += 2) {
			if (abs(i) % j == 0)
				return false;
		}
		return true;
	}
	
	/**
	 * Tests to see if this instance is equal to an integer.
	 * @param i
	 * @return
	 */
	public boolean equals(int i) {
		if (i == this.value) {
			return true;
		}
		return false;
	}

	/**
	 * Tests to see if to instances of MyInteger are equal
	 * @param i
	 * @return
	 */
	public boolean equals(MyInteger i) {
		if (i.value == this.value) {
			return true;
		}
		return false;
	}
	
	
	
	public void setValue(int v) {
		value = v;
		this.abs = Math.abs(v);
	}
	public int getValue() {
		return value;
	}

	/**
	 * Converts a char array into an int
	 * @param x
	 * @return
	 * @throws ParseException
	 */
	public static int parseInt(char[] x ) throws ParseException {
		int rValue = 0;
		boolean negitive;
		if (x[0] == '-') {
			negitive = true;
		} else {
			negitive = false;
		}
		for (int i = x.length - 1, j = 0; i >= ((negitive) ? 1 : 0); --i, ++j) {
			if (Character.isDigit(x[i])) {
				rValue += (x[i] - '0') * Math.pow(10, j);
			} else {
				throw new ParseException("Found an illegal character", j);
			}
		}
		return (negitive) ? -1 * rValue : rValue;
	}
	


	/**
	 * Converts a string into an int
	 * @param s
	 * @return
	 * @throws ParseException
	 */
	public static int parseInt(String s) throws ParseException {
		return parseInt(s.toCharArray());
	}

	@Override
	public int compareTo(MyInteger i) {
		if(this.value > i.value)
			return 1;
		else if(this.value < i.value)
			return -1;
		return 0;
	}
}
