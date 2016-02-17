import java.util.Set;
import java.util.HashSet;

/**
 * Created by Carissa on 1/24/2016.
 */
public class Hset {
    public static void main (String[] args) {
        Set<String> sets = new HashSet<String>();

        sets.add("chicken");
        sets.add("flamingo");
        sets.add("dolphin");
        sets.add("dog");
        sets.add("cheetah");
        sets.add("jelly fish");
        sets.add("jelly fish");
        // Iterations
        System.out.println();
        System.out.println("Simple Iteration Practice");
        for (String element : sets) {
            System.out.println(element);
        }

        /************* Nasty Path 1 **********************/
        // Searches through the hash set for the element "bison"
        // and determines if it is in there or not
        System.out.println();
        System.out.println(sets.contains("bison"));
        System.out.println();

        Set<String> sets1 = new HashSet<String>();

        sets1.add("chicken");
        sets1.add("flamingo");
        sets1.add("giraffe");
        sets1.add("goose");
        sets1.add("leopard");
        sets1.add("goat");

        System.out.println("sets1 HashSet");
        System.out.println(sets1);

        /*************** Intersections ****************/
        /*************** Happy Path 1  ***************/
        // creates another HashSet named intersection
        // this HashSet takes the sets HashSet as a parameter

        Set<String> intersection = new HashSet<String>(sets);

        // "Retains only the elements in this collection that are
        // contained in the specified collection (optional operation).
        // In other words, removes from this collection all of its
        // elements that are not contained in the specified collection."
        intersection.retainAll(sets1);


        System.out.println(intersection);



        Set<Integer> intSet = new HashSet<Integer>();

        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
        intSet.add(22);
        intSet.add(33);
        intSet.add(44);
        Set<Integer> intersections = new HashSet<Integer>(intSet);

        intersections.retainAll(sets1);
        System.out.println(intersections);


        /***********  Difference  ************/
        /*********** Happy Path 2 ************/
        // Similar to retainAll but finds the differences
        // between the two HashSets

        Set<String> difference = new HashSet<String>(sets);

        difference.removeAll(sets1);

        System.out.println(difference);


        /******** Nasty Paths 2 *********/

        // Nasty Path 2: Adding duplicate items does nothing
        sets.add("flamingo");

        System.out.println(sets);


        // Nasty Path 3
        // Tried to add null to the list and it did add null
        sets.add(null);
        System.out.println(sets);
        sets.remove(null);
        System.out.println(sets);


        // Nasty Path 4
        // Only wanted a hashSet of 3 elements
        // however, hashSets will lengthen the HashSet to
        // accommodate any other added items
        Set<String> set2 = new HashSet<String>(3);

        set2.add("pizza");
        set2.add("hot dog");
        set2.add("burger");
        set2.add("chocolate");
        set2.add("cake");
        set2.add("cheese");

        System.out.println();
        System.out.println("Nasty Path 4");
        System.out.println(set2);
        System.out.println();



        // Happy Path 3
        // Combines sets and set2 HashSets
        set2.addAll(sets);
        System.out.println(set2);
        set2.removeAll(sets);
        System.out.println(set2);
        System.out.println(sets.equals(sets1));

        // Nasty Path 5
        // Tries to remove the same item twice
        // it just removes it once
        System.out.println("Nasty Path 5");
        set2.remove("cheese");
        set2.remove("cheese");
        System.out.println(set2);

    }

}
