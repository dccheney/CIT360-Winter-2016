package JUnitTest;

import java.sql.Ref;

/**
 * Created by Carissa on 2/11/2016.
 */
public class Reflection {
    private String cantTouchThis = "Ha ha ha";

    Reflection() {
        String cantTouchThis = null;
    }

    Reflection(String cantTouchThis) {
        this.cantTouchThis = cantTouchThis;
    }

    public void changeString(String aString) {
        cantTouchThis = aString;

    }
}
