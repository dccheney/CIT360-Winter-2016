import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class PlayWithThreads
{
	public static void main(String[] args) 
	{
		//Create a fixed thread pool with a maximum number of threads passed into the constructor
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		//Submit runnable tasks to the executor
		executor.execute(new PrintChar('a', 100));
		executor.execute(new PrintChar('b', 100));
		executor.execute(new PrintChar('c', 100));
		executor.execute(new PrintChar('d', 100));		
		executor.execute(new PrintChar('e', 100));		
		executor.execute(new PrintNum(100));
		
		//Shutdown the executor
		executor.shutdown();
	}
}

class PrintChar implements Runnable 
{
	/* Class attirbutes (member variables) */
	private char charToPrint; // The character to print
	private int times; // The number of times to repeat

	/** 
	 * Construct a task with specified character and number of
	 */
	public PrintChar(char c, int t) 
	{
		charToPrint = c;
		times = t;
	}

	@Override 
	/** 
	 * Override the run() method to tell the system
	 * what task to perform
	 */
	public void run()
	{
		for (int i = 0; i < times; i++)
		{
			System.out.print(charToPrint);
		}
	}
}

// The task class for printing numbers from 1 to n for a given n
class PrintNum implements Runnable 
{
	private int lastNum;

	/** Construct a task for printing 1, 2, ..., n */
	public PrintNum(int n) 
	{
		lastNum = n;
	}

	@Override /** Tell the thread how to run */
	
	public void run() 
	{
		for (int i = 1; i <= lastNum; i++)
			{
				System.out.print(" " + i);
			}
	}
}
