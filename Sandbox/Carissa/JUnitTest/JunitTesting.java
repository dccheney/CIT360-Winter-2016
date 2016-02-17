package JUnitTest;
import org.junit.Test;
import org.junit.*;
import org.omg.IOP.ExceptionDetailMessage;

import java.lang.reflect.Field;

import static org.junit.Assert.*;


/**
 * Created by Carissa on 2/8/2016.
 */
public class JunitTesting {

    // execute before class
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    // Execute after class
    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @Before
    public void before() {
        System.out.println();;
        System.out.println("Before");
    }

    @After
    public void  after() {
        System.out.println("After");
    }

    //Test Case
    @Test
    public void test() {
        System.out.println("in Test");
    }

    //Test Case ignore and will not execute
    @Ignore
    public void ignoreTest() {
        System.out.println("In ignore test");
    }

    /**************************assertEquals***************************/

        int amount = 22;
        AmountEquals amountTest = new AmountEquals(amount);

        @Test
        public void testPrintEquals() {
            assertEquals(22, amountTest.printAmount());
        }


    /************************assertNotEquals****************************/
    int theCoolAmount = 55;
    AmountEquals  amountEqualsTest = new AmountEquals(theCoolAmount);

    @Test
    public void testNotEquals() {
        assertNotEquals(66, amountEqualsTest.printAmount());
    }

    /*************************assertArrayEquals**************************/
    String [] bunnies = {"Floppy", "Hoppy", "Cotton Tail"};
    EqualArray arrayEquals = new EqualArray(bunnies);

    @Test
    public void testEqualArray() {
        assertArrayEquals(new String[]{"Floppy", "Hoppy", "Cotton Tail"}, arrayEquals.printBunnies());

    }

    /***************************assertNotNull**************************/
    @Test
    public void testNotNull() {
        String song = "Na na na na na na na Batman";
        Lyrics newSong = new Lyrics(song);

        String notNullMessage = "This is a Not Null Assertion.";
        assertNotNull(notNullMessage, newSong);


    }

    /**************************assertFalse*****************************/
    int totalNumChickens = 5;
    int totalNumTurkeys  = 4;

    @Test
    public void testAssertFalse() {
        System.out.println("AssertFalse");
        assertFalse(totalNumChickens == totalNumTurkeys);
    }

    /**************************assertTrue*****************************/
   @Test
    public void testAssertTrue() {
       System.out.println("AssertTrue");
        assertTrue(totalNumChickens != totalNumTurkeys);
    }

    /***************************assertSame**************************/
    // Two objects are the same object

    @Test
    public void testAssertSame() {
        System.out.println("AssertSame");
        assertSame(JunitTesting.class,getClass());
    }

    /****************************assertNotSame*************************/
    @Test
    public void testAssertNotSame() {
        System.out.println("AssertNotSame");
        assertNotSame(Lyrics.class, getClass());
    }

    /***************************assert Exception**************************/
    public double divide(double dividend, double divisor) throws Exception{
        if (divisor == 0) {
            throw new Exception("Throwing the exception");
        }
        return dividend / divisor;
    }
   @Test
   public void testException() {

       try {
            divide(7.0,0.0);
           fail("Blah blah blah");

       } catch (Exception e) {

       }
   }

    /*************************** assert Reflections **************************/
    @Test
    public void testReflection() throws Exception {
        try {

            Reflection reflect = new Reflection("Chicken Pot Pie");
            reflect.changeString("ducks");
            // creates the "box"
            Field grass = reflect.getClass().getDeclaredField("cantTouchThis");
            grass.setAccessible(true);
            // gets the value in the "box" --> grass
            assertNotNull(grass.get(reflect));


        } catch (Exception e) {
            System.out.println("Throws an Exception\n"+e);
        }
    }


}
