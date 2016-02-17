import static org.junit.Assert.*;
import java.lang.reflect.*;

import org.junit.Test;


public class JunitPlayGroundTest 
{

	String message = "Hello Mars";
	JunitPlayGround myPlayGround = new JunitPlayGround();
	Class myOtherPlayGround = JunitPlayGround.class; 
	
	@Test
	public void testTheBool()
	{
		Boolean testBool = true;
		assertFalse(myPlayGround.giveMeABool(testBool));
	}
	
	@Test
	public void testTheBool2()
	{
		Boolean testBool = true;
		assertTrue(myPlayGround.giveMeABool(testBool));
	}
	
	@Test
	public void testTheLong()
	{
		long testLong = 7;
		assertEquals(7, myPlayGround.giveMeALong(testLong));
	}
	
	@Test
	public void testTheChar()
	{
		char testChar = 'c'; 
		assertNotNull(myPlayGround.giveMeAChar(testChar));
	}
	
	@Test
	public void testSameness()
	{
		assertNotSame(message + "s", myPlayGround.giveMeAString(message));
		
	}
	
	@Test
	public void checkAddition()
	{
		long numA = 10;
		long numB = 21;
		long sum  = 30;
		assertNotEquals(sum, myPlayGround.addSomeLongs(numA, numB));
	}
	
	@Test
	public void theCatcher()
	{
		try
		{
			assertEquals("AssertionError",13, myPlayGround.giveMeALong(13));
		}
		catch(AssertionError e)
		{	
			System.err.println(e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void throwTheZero()
	{
		try
		{
			myPlayGround.funDivide(2, 0);
			fail("This should have failed when you passed in a zero");
		}
		catch (Exception e)
		{
			
		}
	}


	@Test
	public void makeItPublic()
	{
		
		try 
		{
			Field field1 = JunitPlayGround.class.getDeclaredField("secretMessage");
			String name = field1.getName();
			System.out.println("My secret attribute is called " + name);
			field1.setAccessible(true);
			assertEquals("I am a secret", (field1.get(myPlayGround)));
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 				
	}

}
