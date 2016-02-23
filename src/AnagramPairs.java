import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by abhinit on 10/15/15.
 */
public class AnagramPairs {
    HashMap<String,Integer> countMap = new HashMap<>();

    public long  process(int lowerLimit,int upperLimit){
        String num = null;
        long count = 0;
        char[] numArray = null;
        int root = 0;

        for(int key=lowerLimit;key<upperLimit;key++){
            num = Integer.toString(key);
            numArray = num.toCharArray();
            Arrays.sort(numArray);
            root = Integer.parseInt(toString(numArray));

            updateMap(toString(numArray),1);
        }

        for(String key : this.countMap.keySet()){
            count = count
                    + getNumberofPairs(this.countMap.get(key));
        }

        return count;
    }

    private String toString(char[] sequence){
        StringBuilder stringKey = new StringBuilder();

        for(char key : sequence){
            stringKey.append(key);
        }

        return stringKey.toString();
    }

    private int getNumberofPairs(int number){
        int count  = number * (number-1)/2;
        return count;
    }
    private void updateMap(String num,int value){
        int count = 0;
        if(countMap.get(num)==null)
            countMap.put(num,value);
        else{
            count = countMap.get(num);
            countMap.put(num,count+1);
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int lower = in.nextInt();
        int upper = in.nextInt();

        AnagramPairs instance = new AnagramPairs();
        long startTime  = System.currentTimeMillis();

        System.out.println(instance.process(lower,upper));

        long endTime  = System.currentTimeMillis();
        System.out.println("Time taken: "+(endTime-startTime));
    }
}
