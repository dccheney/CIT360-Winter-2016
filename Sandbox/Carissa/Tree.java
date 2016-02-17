import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * Created by Carissa on 1/21/2016.
 */
public class Tree {
    public static void main (String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();

        /**************** happy Path *********************/

        // Add elements to the Hash Map
        treeMap.put(1, "Carissa");
        treeMap.put(30, "Michael");
        treeMap.put(22, "Stephanie");
        treeMap.put(45, "Candice");
        treeMap.put(13, "Mitch");
        treeMap.put(24, "Ernie");

        // Display the content using an iterator
        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry)iterator.next();
            System.out.println("The key is: " + mapEntry.getKey() + " & the value is: ");
            System.out.println(mapEntry.getValue());
        }

        // Get values based on the key
        String var = treeMap.get(30);
        System.out.println("Value at index 30 is: " + var);
        System.out.println("\n");

        /****************** Nasty Path*****************************/
        try {
            treeMap.put(null, "Turkey");
            System.out.println("\n\n\n");
            while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
                System.out.println("The key is: " + mapEntry.getKey() + " & the value is: ");
                System.out.println(mapEntry.getValue());
            }
        }
        catch (Exception ex) {
            System.out.println("Cannot use null as Key value");
        }

        /****************** Nasty Path*****************************/
        try {
            treeMap.put(444, null);
            System.out.println("\n\n\n");
            String var1 = treeMap.get(444);
            System.out.println("Value at index 444 is: " + var1);
            System.out.println("\n");
        }
        catch (Exception ex) {
            System.out.println("Cannot use null for value");
        }


        /****************** Nasty Path*****************************/
        try {
            treeMap.put(-33, "Sunshine");
            System.out.println("\n\n\n");
            String var2 = treeMap.get(-33);
            System.out.println("Value at index -33 is: " + var2);
            System.out.println("\n");
        }
        catch (Exception ex) {
            System.out.println("Cannot use negative number for Key value");
        }
        /************************** Tree Set Objects Nasty Path ****************************/
        TreeSet <Time> tSet = new TreeSet<Time>();
        Time t1 = new Time();
        t1.setMinute(2);
        t1.setHour(1);

        Time t2 = new Time();
        t2.setMinute(3);
        t2.setHour(4);

        tSet.add(t2);
        tSet.add(t1);

        System.out.println(tSet);


        /****************** Happy Path *******************/
        TreeMap treee = new TreeMap();
        String[] legoColors = {"blue","yellow", "red"};

        treee.put("Key1", "Value1");
        treee.put("Key2", "Value2");

        System.out.println("Key1 Value: "+treee.get("Key1"));
        System.out.println("Key2 Value: "+treee.get("Key2"));

        /********************** Nasty Path***********************/

        try {
            treee.put(legoColors, "Value3");
            System.out.println("Lego Value: " + treee.get(legoColors));
        } catch (Exception e) {
           System.out.println("Can't add an array as a key....:\n"+e);
        }

        /************************* Nasty Path **************************/

        try {
            treee.put("Key3", legoColors);
            System.out.println("Key3 Value: " + treee.get(legoColors));
        } catch (Exception e) {
            System.out.println("Can't use an array for Values:\n"+e);
        }

    }
}
