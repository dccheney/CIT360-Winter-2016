/**
 * Created by Carissa on 1/17/2016.
 */

import jdk.nashorn.internal.runtime.ECMAException;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        //doTimings("ArrayList", arrayList);
        doTimings("LinkedList", linkedList);

        //doRemove("ArrayList", arrayList);
        doRemove("LinkedList", linkedList);

        // doGet("ArrayList", arrayList);
        doGet("LinkedList", linkedList);

        //doaddAll("LinkedList", linkedList);
    }


    private static void doTimings(String type, List<Integer> list) {

        // Creates an array of 1x10^5 in length
        for (int i = 0; i < 1E5; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();

        /************ Happy Path 1 **************/
        // Add items at the end of the list
        try {

            for (int i = 0; i < 1E5; i++) {
                list.add(i);
            }
            System.out.println("Add at the end of a list:");
            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + (end - start) + " ms for " + type);
        } catch (Exception e) {
            System.out.println("Didn't add items to end of list");
        }
        System.out.println();

        /*************** Happy Path 2 ***************/
        // Add items elsewhere in the list
        try {
            for (int i = 0; i < 1E5; i++) {
                list.add(0, i);
            }
            System.out.println("Add at the beginning of the list:");
            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + (end - start) + " ms for " + type);
        } catch (Exception e) {
            System.out.println("Didn't add items to the beginning of the list");
        }

        System.out.println();

        /*************** Nasty Path 1 ******************/
        // Adds items to position negative two which doesn't exist

        try {
            for (int i = 0; i < 1E5; i++) {
                list.add(-2, i);
            }
            System.out.println("Add items to -2 position:");
            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + (end - start) + " ms for " + type);
        } catch (Exception e) {
            System.out.println("Tried to add items to postion -2 of the list but faaaiiilllleeedddd.");
        }

        System.out.println();

        /**************** Nasty Path 2 ****************/
        // Tries to add items to a null location

        try {
            for (int i = 0; i < 1E5; i++) {
                list.add(Integer.parseInt(null), i);
            }
            System.out.println("Add null:");
            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + (end - start) + " ms for " + type);
        } catch (Exception e) {
            System.out.println("Tried to add null");
        }
    }




    private static void doRemove(String type, List<Integer> list) {

        // create another list
        for (int i = 0; i < 1E3; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();


        /*********** Nasty Path 3? ****************/
        // Tries to remove items from the list that
        // is larger than the created list
        // This nasty path works

        try {
            for (int i = 0; i < 1E3; i++) {
                list.remove(1E5);
            }
            long end = System.currentTimeMillis();
            System.out.println();
            System.out.println("Remove bigger amount:");
            System.out.println("Time taken: " + (end - start) + " ms for " + type);
        } catch (Exception e) {
            System.out.println("Tried to remove larger amount");
        }


        /******************** Nasty Path 4 *********************/
        // Tries to remove a null index from the list
        try {
            for (int i = 0; i < 1E5; i++) {
                list.remove(Integer.parseInt(null));
            }
            long end = System.currentTimeMillis();
            System.out.println();
            System.out.println("Remove null value:");
            System.out.println("Time taken: " + (end - start) + " ms for " + type);
        } catch (Exception e) {
            System.out.println();
            System.out.println("Tried to remove a null value");
        }


        /**************** Happy Path 3 **************/
        // Tries to simply remove three items from the list
        try {
            for (int i = 0; i < 1E5; i++) {
                list.remove(3);
            }
            long end = System.currentTimeMillis();
            System.out.println();
            System.out.println("Remove three items:");
            System.out.println("Time taken: " + (end - start) + " ms for " + type);
        } catch (Exception e) {
            System.out.println("Tried to remove just three items.");
        }
    }

    private static void doGet(String type, List<Integer> list) {

        for (int i = 0; i < 1E5; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();

        /******************** Happy Path 4 **********************/
        //Tries to get two items
        try {
            for (int i = 0; i < 1E5; i++) {
                list.get(2);
            }
            long end = System.currentTimeMillis();
            System.out.println();
            System.out.println("Get two items:");
            System.out.println("Time taken: " + (end - start) + " ms for " + type);
            System.out.println(list.get(2));
        } catch (Exception e) {
            System.out.println("Tried to get just two items.");
        }

        /************** Nasty Path 5 *****************/
        // Tries to get items from -9 index
        try {
            for (int i = 0; i < 1E5; i++) {
                list.get(-9);
            }
            long end = System.currentTimeMillis();
            System.out.println();
            System.out.println("Get -9 items:");
            System.out.println("Time taken: " + (end - start) + " ms for " + type);
        } catch (Exception e) {
            System.out.println("Tried to get -9 items");

        }
    }

    private static void doaddAll(String type, List<Integer> list) {
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();

        for (int i = 0; i < 1E3; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();

        try {
            // Add items at the end of the list
            for (int i = 0; i < 1E3; i++) {
                list.add(3);
                list.add(19);
                list.add(6);
            }

            long end = System.currentTimeMillis();
            System.out.println();
            System.out.println("Get:");
            System.out.println("Time taken: " + (end - start) + " ms for " + type);
        } catch (Exception e) {
            System.out.println("Get ");
        }
    }
}