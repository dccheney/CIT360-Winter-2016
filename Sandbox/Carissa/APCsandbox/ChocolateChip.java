package APCsandbox;

import java.util.HashMap;

/**
 * Created by Carissa on 2/23/2016.
 */
public class ChocolateChip implements Handler {

    public void handleIt(HashMap parameters) {
        System.out.println("These muffins are made fresh daily.");
        System.out.println("Chocolate Chip muffin: $0.99");
        System.out.println("Chocolate Chip muffin 2 pack: $1.95");
        System.out.println("Chocolate Chip muffin 4 pack: $3.80");
        System.out.println("Chocolate Chip muffin 6 pack: $5.50");
        System.out.println("Chocolate Chip muffin dozen: $11.00");

    }
}
