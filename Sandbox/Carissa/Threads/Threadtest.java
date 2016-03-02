package Threads;

/**
 * Created by Carissa on 2/24/2016.
 */
public class Threadtest extends Thread{



    public void run() {
        for (int i = 0; i < 3; i++) {
            String currThread =  Thread.currentThread().getName();
            int active = Thread.activeCount();
            System.out.println(i + " " + currThread + "                 Thread active count: " + active);
            try {
                Thread.currentThread().sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int threadCount= 0; threadCount < 3; threadCount++) {

            //start() overrides run()
            //Happy Pathes
            Threadtest threadOne = new Threadtest();
            threadOne.setName("Thread 1");
            threadOne.start();

            Threadtest threadTwo = new Threadtest();
            threadTwo.setName("Thread 2");
            threadTwo.start();

            Threadtest threadThree = new Threadtest();
            //threadThree.run();
            threadThree.setName("Thread 3");
            threadThree.start();



            /**********Nasty Path****************/
            try {

                threadThree.interrupt();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Interruption Exception");
            }

        }

    }
}