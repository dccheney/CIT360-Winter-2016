import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Raycer
{
	public static void main(String[] args) 
	{
		Raycer myRacer = new Raycer(500000);
//		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Runnable myIncrementor = myRacer.new Incrementor();
//		executor.execute(myIncrementor);
		
		Runnable myDecrementor = myRacer.new Decrementor();
//		executor.execute(myDecrementor);


		Thread thread1 = new Thread(myIncrementor);
		Thread thread2 = new Thread(myDecrementor);
		
		thread1.start();
		thread2.start();		
	}
	
	public Raycer(int initialCounterValue)
	{
		counter = initialCounterValue;
	}
	
	public int counter;
	
	public class Incrementor implements Runnable
	{
		public Incrementor()
		{
			
		}

		public int incrementNumber()
		{
			 return ++counter;
		}
		
		public void run()
		{
			while (counter < 1000000) 
			{
				System.out.println("Value incremented from " + counter + " to " + incrementNumber());
			}
		}

	}
	
	public class Decrementor implements Runnable
	{
		public Decrementor()
		{
			
		}
		
		public int  decrementNumber()
		{
			return --counter;			
		}

		public void run()
		{
			while (counter > 0) 
			{
				System.out.println("Value decremented from " + counter + " to " + decrementNumber());
			}
		}

	}
}