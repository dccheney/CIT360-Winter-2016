import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestJunit 
{
	
   String message = "Hello Mars";	
   MessageUtil messageUtil = new MessageUtil(message);

   @Test
   public void testPrintMessage() 
   {
      assertEquals("Hello Mars",messageUtil.printMessage());
   }
}