package Threads;



/**
 * Created by Carissa on 2/25/2016.
 */
public class Deadlock {
    //private static Object block1 = new Object();
    //private static Object block2 = new Object();

    final static String lock1 = "Waiting for my long lost lover, bob";
    final static String lock2 = "Waiting for my darling, Anne";

    public static void main(String[] args) {

        LoveStoryOne longLostLover1 = new LoveStoryOne();
        LoveStoryTwo longLostLover2 = new LoveStoryTwo();

        longLostLover1.start();
        longLostLover2.start();
    }

    private static class LoveStoryOne extends Thread {
// thread one tries to lock lock1 then lock2
        public void run() {
            //synchromized
            synchronized (lock1) {
                System.out.println("Thread 1: locking lock1 ");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 1: Waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock1 and lock2");
                }
            }
        }
    }

    private static class LoveStoryTwo extends Thread {
// thread two tried to lock lock2 then lock1
        public void run() {
            //synchromized
            synchronized (lock2) {
                System.out.println("Thread 1: Holding lock1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 1: Waiting for lock 2");
                synchronized (lock1) {
                    System.out.println("Thread 1: Holding lock 1 & 2");
                }
            }
        }
    }
}
