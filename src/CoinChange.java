import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class CoinChange {

    private static String process(int[] values,int sum){
        BigInteger [] states = new BigInteger[sum+1];
        states[0]= BigInteger.valueOf(1);

        for(int key=1;key<states.length;key++)
            states[key] = BigInteger.ZERO;

        for(int value : values){
            for(int key=0;key<states.length;key++)
                states[key] = states[key].add(((key - value >= 0) ? states[key - value] : BigInteger.ZERO));

        }

        return states[sum].toString();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int numOfCoins = in.nextInt();
        int[] values = new int[numOfCoins];
        String numOfComb = null;

        for(int key=0;key<numOfCoins;key++){
            values[key] = in.nextInt();
        }

        numOfComb = process(values,sum);
        System.out.println(numOfComb);
    }
}