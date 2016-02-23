import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by abhinit on 8/30/15.
 */
public class RedJohnisBack {
    private static BigInteger[][] process(BigInteger maxDim){
        BigInteger noOfBlocks = maxDim.divide(BigInteger.valueOf(4));
        BigInteger[][] combinations = new BigInteger[maxDim.intValue()+1][noOfBlocks.intValue()+1];
        BigInteger verticalBricks = BigInteger.ZERO;
        BigInteger combination = BigInteger.ZERO;
        combinations[0][0] = BigInteger.ONE;

        for(BigInteger blocks=BigInteger.ZERO;blocks.compareTo(noOfBlocks)<=0;blocks=blocks.add(BigInteger.ONE)){
            for(BigInteger dim=BigInteger.ONE;dim.compareTo(maxDim)<=0;dim=dim.add(BigInteger.ONE)){
                if(dim.compareTo(blocks.multiply(BigInteger.valueOf(4)))<0){
                    combinations[dim.intValue()][blocks.intValue()] = BigInteger.ZERO;
                }
                else{
                    verticalBricks = dim.subtract(blocks.multiply(BigInteger.valueOf(4)));
                    combination = factorial(verticalBricks.add(blocks)).divide(
                            (factorial(verticalBricks).multiply(factorial(blocks))));
                    combinations[dim.intValue()][blocks.intValue()] = combination;
                }

            }
        }

        return combinations;
    }
    private static BigInteger factorial(BigInteger number) {
        if (number.compareTo(BigInteger.ONE)<=0)
            return BigInteger.ONE;
        else
            return number.multiply(factorial(number.subtract(BigInteger.ONE)));
    }
    private static int getNoOfPrimeNos(int n){
        int count =0;
        for(int i=0;i<=n;i++){
            if(isPrime(i)) {
                count++;
            }
        }

        return count;
    }
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <=Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int noOfTestCases = in.nextInt();
        int[] dimensions = new int[noOfTestCases];
        int maxDim = 0;
        for(int i=0;i<noOfTestCases;i++){
            dimensions[i] = in.nextInt();
            if(maxDim<dimensions[i])
                maxDim = dimensions[i];
        }


        BigInteger[][] combinations = process(BigInteger.valueOf(maxDim));
        int noOfBlocks = (int)maxDim/4;
        BigInteger sum = BigInteger.ZERO;
        for(int dim : dimensions){
            sum = BigInteger.ZERO;
            for(int i = 0;i<=noOfBlocks;i++){
                sum = sum.add(combinations[dim][i]);
            }

            System.out.println(getNoOfPrimeNos(sum.intValue()));
        }
    }
}
