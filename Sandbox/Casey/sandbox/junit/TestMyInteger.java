/**
 * 
 */
package sandbox.junit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.lang.reflect.Field;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * @author Casey Moffett
 * @Date Dec 10, 2015
 *
 * @Copywright 2015
 */
public class TestMyInteger {
	public static MyInteger x;
	public static MyInteger y;
	public static MyInteger z;

	@Before
	public void setUp() {
		x = new MyInteger(16);
		y = new MyInteger(751);
		z = new MyInteger(-751);
	}

	@Test
	public void testIsPrime() {
		assertFalse("X is not prime", x.isPrime());
		assertTrue("Y is prime", y.isPrime());
		assertTrue("Z is prime", z.isPrime());
	}

	@Test
	public void testParseInt() throws ParseException {
		assertThat("Parse int with String failed with a negitive number",
				-5134, is(MyInteger.parseInt("-5134")));
		assertThat("Parse int with String failed with a positive number", 5134,
				is(MyInteger.parseInt("5134")));
	}

	@Test
	public void testParseIntChar() throws ParseException {
		assertThat("Parse int with char[] failed with a negitive number",
				-5134, is(MyInteger.parseInt("-5134".toCharArray())));
		assertThat("Parse int failed with Char[] a positive number", 5134,
				is(MyInteger.parseInt("5134".toCharArray())));
	}

	@Test
	public void testIsEven() {
		assertTrue("X should not be odd", x.isEven());
		assertFalse("Y is not even", y.isEven());
		assertFalse("Z is not even", z.isEven());
	}
	
	@Test
	public void testIsEvenMyIntIn() {
		assertTrue("12 should not be odd", MyInteger.isEven(new MyInteger(12)));
		assertFalse("15 is not even", MyInteger.isEven(new MyInteger(15)));
		assertTrue("-12 should not be odd", MyInteger.isEven(new MyInteger(-12)));
	}
	
	@Test
	public void testSetValue() {
		MyInteger i1 = new MyInteger(10);
		assertEquals(10, i1.getValue());
		i1.setValue(11);
		try {
			Field f = MyInteger.class.getDeclaredField("value");
			f.setAccessible(true);
			assertEquals(11, f.get(i1));
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testNulls() {
		MyInteger i1 = null;
		assertNull(i1);
		i1 = new MyInteger(15);
		assertNotNull(i1);
	}
	
	@Test
	public void testNotSame() {
		MyInteger i1 = new MyInteger(15);
		MyInteger i2 = new MyInteger(i1.getValue());
		assertNotSame(i1, i2);
	}
	
	@Test
	public void testSame() {
		MyInteger i1 = new MyInteger(15);
		MyInteger i2 = i1;
		assertSame(i1, i2);
	}
	
	@Test
	public void testArray() {
		int[] a1 = new int[15];
		int[] a2 = new int[15];
		
		for (int i = 0; i < a2.length; i++) {
			a1[i] = i;
			a2[i] = i;
		}
		assertArrayEquals(a1, a2);
	}
	@Ignore
	@Test
	public void testArray2() {
		MyInteger[] a1 = new MyInteger[15];
		MyInteger[] a2 = new MyInteger[15];
		
		for (int i = 0; i < a2.length; i++) {
			a1[i] = new MyInteger(i);
			a2[i] = new MyInteger(i);
		}
		assertArrayEquals(a1, a2);
	}
	
	@Test
	public void testArray3() {
		MyInteger[] a1 = new MyInteger[15];
		MyInteger[] a2 = new MyInteger[15];
		
		for (int i = 0; i < a2.length; i++) {
			a1[i] = new MyInteger(i);
			a2[i] = a1[i];
		}
		assertArrayEquals(a1, a2);
	}
	
	
	

}
