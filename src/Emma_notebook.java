/**
 * Created by abhinit on 10/30/15.
 */
import java.math.BigInteger;
import java.util.Scanner;

public class Emma_notebook {
    public static String process(int time){
        BigInteger sum = BigInteger.ONE;
        int temp = 0;

        for(int i=2;i<=time;i++){
            if(i%2==0){
                temp = (int)Math.ceil((double)i/2) + 1;
            }
            else
                temp = (int)Math.ceil((double)i/2);
            sum  = sum.add(BigInteger.valueOf(temp));
        }

        return sum.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String sum = process(t);
        System.out.println(sum);
        // your code goes here
    }
}
