package JUnitTest;

/**
 * Created by Carissa on 2/8/2016.
 */
public class EqualArray {

    private String[] bunnies;

    //Constructor
    public EqualArray(String[] bunnies) {
        this.bunnies = bunnies;
    }

    //prints the arrays
    public String[] printBunnies() {
        System.out.println(bunnies);
        return bunnies;
    }
}
