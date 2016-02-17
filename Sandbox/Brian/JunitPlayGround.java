import java.util.List;

public class JunitPlayGround 
{
	private String message;
	private String secretMessage = "I am a secret";

		
//	JunitPlayGround(String message);
//	{
//		this.message = message;
//	}
	
	boolean giveMeABool(Boolean boolVariable)
	{
		return boolVariable;
		
	}
	
	public String printMessage()
	{
		System.out.println(message);
		return message;
	}   

	long giveMeALong(long longVariable)
	{
		return longVariable;
	}
	
	int giveMeAChar(char someChar)
	{
		
		return someChar;
	}

	long addSomeLongs(long a, long b)
	{
		long sum = a + b;		
		return sum;
	}
	
	double addSomeDoubles(double a, double b)
	{
		double sum = a + b;
		return sum;
	}

	String giveMeAString(String someString)
	{
		return someString;
	}
	
	int[] giveMeAnIntArray(int[] intArray)
	{
		return intArray;
	}
	
	List giveMeAList(List myList)
	{
		return myList;
	}

	double funDivide(double a, double b) throws Exception
	{
		if (b == 0)
		{
			throw new Exception("Don't Divide by 0");
		}	
		
		return a/b;
	}


}
