package Executor;

import java.util.concurrent.*;

/**
 * Created by Carissa on 3/1/2016.
 */
public class execTest {
    public static void main(String[] args) {
        Executor anExecutor = Executors.newCachedThreadPool();
        for(int threadCnt = 0; threadCnt < 3; threadCnt++){
            RunnableExample aSillyRunnable =
                    new RunnableExample();
            anExecutor.execute(aSillyRunnable);
        }
        try {
            Thread.sleep(5000);
            System.out.println("Done Sleeping");
            for(int threadCnt = 0; threadCnt < 3; threadCnt++){
                RunnableExample aSillyRunnable =
                        new RunnableExample();
                anExecutor.execute(aSillyRunnable);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
