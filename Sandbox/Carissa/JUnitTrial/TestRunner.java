package JUnitTrial;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Carissa on 2/9/2016.
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JunitTutorial.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
