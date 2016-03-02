package APCdemo;

/**
 * Created by Carissa on 2/26/2016.
 */
public class Divide implements Handler{
    @Override
    public void execute(Integer num1, Integer num2) {
        Integer sum = num1 / num2;
        System.out.println(sum);
    }
}
