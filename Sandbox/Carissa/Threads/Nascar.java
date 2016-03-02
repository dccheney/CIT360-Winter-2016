package Threads;

/**
 * Created by Carissa on 2/25/2016.
 */
public class Nascar implements RunTest {

        public static String talladegaWinner;

        public void talladega(){

            for(int laps = 0; laps <= 188; laps++){
                double miles = Math.round((laps * 2.66));
                System.out.println("Talladega competitor "+Thread.currentThread().getName()+" is "+ laps +" laps or " + miles + " miles.");

                //sees if the races has come to a finish with a winner
                boolean isTalladegaWinner = this.isTalladegaWinner(laps);
                if(isTalladegaWinner){
                    break;
                }
            }

        }

        private boolean isTalladegaWinner(int laps){
            boolean isTalladegaWinner = false;
            if((Nascar.talladegaWinner == null)&&(laps == 188)){
                String winner = Thread.currentThread().getName();
                Nascar.talladegaWinner = winner; //setting the winner name)
                System.out.println("\n");
                System.out.println("2016 Talladega Sprint Cup winner goes to...... " + Nascar.talladegaWinner);
                System.out.println();
                isTalladegaWinner = true;
            }
            else if(Nascar.talladegaWinner == null){

//                System.out.println("\n");
//                System.out.println("2016 Talladega Sprint Cup winner goes to......no one....");
//                System.out.println();
                isTalladegaWinner = false;
            }
            return isTalladegaWinner;
        }

    @Override
    public void run() {
        this.talladega();
    }
}
