import java.util.*;
import java.math.*;


public class Candies {

    private static String process(BigInteger[] ranks){
        BigInteger[] states = new BigInteger[ranks.length];
        int index = 0;
        int rankIndex = 0;
        BigInteger inc = null;
        states[0] = BigInteger.ONE;

        for(BigInteger rank : ranks){

            if(rankIndex > 0
                    && rank.compareTo(ranks[rankIndex - 1])>0) {
                /*inc = (index>=2)?(states[index - 1].subtract(states[index - 2])
                            .add(BigInteger.ONE)):BigInteger.ONE;*/
                inc = BigInteger.ONE;

                states[index] = states[index-1].add(inc);
            }
            else if(index>0 && index<ranks.length){
                if(rankIndex >= 2 && rank.compareTo(ranks[rankIndex - 1])<0
                        && ranks[rankIndex - 1].compareTo(ranks[rankIndex - 2])<0)
                    inc = BigInteger.ZERO;
                else
                    inc = BigInteger.ONE;

                states[index] = inc;
            }

            index++;
            rankIndex++;
        }

        if(states[states.length-1].equals(BigInteger.ZERO))
            states[states.length-1] = BigInteger.ONE;

        for(int i=ranks.length-1;i>=0;i--){

            if(i<ranks.length-1
                    && ranks[i].compareTo(ranks[i+1])>0) {
                states[i] = states[i].add((states[i].compareTo(states[i+1])<=0)
                        ?BigInteger.ONE:BigInteger.ZERO);
            }
        }

        BigInteger sum = BigInteger.ZERO;

        for(BigInteger state : states){
            sum = sum.add(state);
        }

        return sum.toString();
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int noOfChildren = in.nextInt();
        BigInteger[] ranks = new BigInteger[noOfChildren];

        for(int key=0;key<ranks.length;key++){
            ranks[key] = BigInteger.valueOf(in.nextInt());
        }

        String noOfCandies = process(ranks);
        System.out.println(noOfCandies);
    }
}