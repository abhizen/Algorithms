import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by abhinit on 9/23/15.
 */
public class BricksGame {
    public static int process(int[] input){
        int[] states = new int[input.length];
        int[] count = new int[input.length];
        int index = 1;
        int max = 0;
        int stackCount = 0;
        int maxScore = 0;

        states[0] = input[0];
        count[0] = 1;

        while(index<states.length){

            if(count[index-1]>0 && count[index-1]<3) {

                if(maxScore<=states[index - 1] + input[index]){
                    maxScore = states[index - 1] + input[index];
                    stackCount = count[index-1] + 1;
                }
            }

            if(index-2>=0) {

                if(maxScore<=states[index - 2] + input[index]){
                    maxScore = states[index - 2] + input[index];
                    stackCount = 1;
                }
            }


            if(count[index-1]==3) {

                if(maxScore<=states[index - 1]){
                    maxScore = states[index - 1];
                    stackCount = 0;
                }
            }


            states[index] = maxScore;
            count[index] = stackCount;

            System.out.println(max);
            if(max<=maxScore)
                max = maxScore;

            index++;
        }

        return max;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int noOfTestCases = in.nextInt();
        int inputSize = 0;
        int max = 0;

        for(int i=0;i<noOfTestCases;i++){
            inputSize = in.nextInt();
            int[] input = new int[inputSize];

            for(int j=0;j<inputSize;j++) {
                input[j] = in.nextInt();
            }

            max = process(input);
            System.out.println(max);
        }
    }
}
