import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

/**
 * Created by Carissa on 1/20/2016.
 */
public class Maps extends Time {

    public static void main(String[] args) {
        HashMap <Integer, String> map = new HashMap<Integer, String>();

        /********************** Happy Path ********************/
        // Add elements to the Hash Map
        map.put(22, "Stephanie");
        map.put(45, "Candice");
        map.put(13, "Mitch");
        map.put(24, "Ernie");
        map.put(30, "Michael");
        map.put(1, "Carissa");

        // Display the content using an iterator
        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry)iterator.next();
            System.out.println("The key is: " + mapEntry.getKey() + " & the value is: ");
            System.out.println(mapEntry.getValue());
        }

        /*********************** Happy Path************************/
        // Get values based on the key
        String var = map.get(30);
        System.out.println("Value at index 30 is: " + var);
        System.out.println();


        map.put(5, "Maleah");

        Set sets = map.entrySet();
        Iterator iterators = sets.iterator();

        while(iterators.hasNext()) {
            Map.Entry mapEntry = (Map.Entry)iterators.next();
            System.out.println("The key is: " + mapEntry.getKey() + " & the value is: ");
            System.out.println(mapEntry.getValue());
        }


        /************** Nasty Paths ****************/

        // Nasty Path 1:
        try {
            map.put(-9, null);
            Set set1 = map.entrySet();
            Iterator iterator1 = sets.iterator();

            while(iterator1.hasNext()) {
                Map.Entry mapEntry = (Map.Entry)iterator1.next();
                System.out.println("The key is: " + mapEntry.getKey() + " & the value is: ");
                System.out.println(mapEntry.getValue());
            }

        }
        catch (Exception e) {
            System.out.println("Doesn't work");
        }

        //Nasty Path 2: Duplicates
        map.put(1, "Carissa");
        while(iterators.hasNext()) {
            Map.Entry mapEntry = (Map.Entry)iterators.next();
            System.out.println("The key is: " + mapEntry.getKey() + " & the value is: ");
            System.out.println(mapEntry.getValue());
        }



        // Nasty Path 2:
        HashMap <Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Time t1 = new Time();
        t1.setMinute(2);
        t1.setHour(1);

        Time t2 = new Time();
        t2.setMinute(3);
        t2.setHour(4);

        map1.put(t1.getMinute(), t1.getHour());
        map1.put(t1.getMinute(), t1.getHour());
        map1.put(t2.getMinute(), t2.getHour());

        System.out.println(map1.get(t1.compareTo(t2)));
        System.out.println(map1.get(t2.compareTo(t1)));

        map1.clear();
        System.out.println(map1.get(t1.compareTo(t2)));



        // Nasty Path 3:
        Maps m = new Maps();
        m.setHashMappyValues();
        m.getHashMappyValues();

        // Nasty Path 4:
        HashMap hahashMap = new HashMap();
        String[] chicken = {"Bob", "Sue"};
        String[] flamingo = {"Sally", "Billy"};

        hahashMap.put(chicken, "Happy");
        hahashMap.put("keys2", flamingo);
        System.out.println(hahashMap.get(chicken));
        System.out.println(hahashMap.get("keys2"));

    }
    HashMap hashMappy = new HashMap();
    private void setHashMappyValues() {
        hashMappy.put("Key1", "Value1");
        hashMappy.put("Key2", "Value2");
        Object obj = hashMappy.get("Key1");
        //obj = hashMappy.get("Value1");
        hashMappy.put("Key3", obj);
    }
    private void getHashMappyValues() {
        System.out.println("Value Stored for Key1: "+hashMappy.get("Key1"));
        System.out.println("Value Stored for Key2: "+hashMappy.get("Key2"));
        System.out.println("Value Stored for Key3: "+hashMappy.get("Key3"));

    }
}
