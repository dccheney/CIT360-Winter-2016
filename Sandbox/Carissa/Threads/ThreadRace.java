package Threads;

/**
 * Created by Carissa on 2/25/2016.
 */
public class ThreadRace {
    public static void main(String[]args){
        Nascar raceCar = new Nascar();
        Thread number18 = new Thread(raceCar,"Number 18");
        Thread number40 = new Thread(raceCar,"Number 40");

        //Nascar Race begins

        number18.start();
        number40.start();
    }
}
