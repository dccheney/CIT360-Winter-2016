package JUnitTrial;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Carissa on 2/8/2016.
 */
public class JunitTutorial {

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

    String message = "I love pasta";
    MessageUtil messageUtil = new MessageUtil(message);

//    @Test
//    public void testPrintMessage() {
//        assertEquals("I love pizza", messageUtil.printMessage());
//    }

}
