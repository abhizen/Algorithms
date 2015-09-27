import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by abhinit on 9/26/15.
 */
public class BricksGameRecursive {
    private static enum Turn {PLAYER1, PLAYER2}
    private static int[] input = null;

    public static int process(int[] inputArr){
        int index = 0;
        input =inputArr;
        int score = getBricks(Turn.PLAYER1,index);
        return score;
    }
    private static int getBricks(Turn player,int index){
        int score = 0;
        int curScore= 0;
        ArrayList<Integer> scores = new ArrayList<>();

        if(index==input.length)
            return 0;

        if(player==Turn.PLAYER1){
            score = input[index];

            for(int curIndex=index;curIndex<(index+3>input.length?input.length:index+3);curIndex++){
                curScore = curScore + input[curIndex];
                score = curScore + (curIndex+1<input.length?getBricks(Turn.PLAYER2, curIndex + 1):0);
                scores.add(score);
            }

            if(scores.size()>0)
                score = getMax(scores);
            else
                return 0;

            return score;
        }
        else{

            for(int curIndex=index;curIndex<(index+3>input.length?input.length:index+3);curIndex++){
                score = (curIndex+1<input.length?getBricks(Turn.PLAYER1, curIndex + 1):0);
                scores.add(score);
            }

            if(scores.size()>0)
                score = getMin(scores);
            else
                return 0;

            return score;
        }


    }
    private static int getMin(ArrayList<Integer> scores){
        int min = 0;
        min = scores.get(0);
        for(int score : scores){
            if(min>score)
                min = score;
        }

        return min;
    }
    private static int getMax(ArrayList<Integer> scores){
        int max = 0;
        max = scores.get(0);
        for(int score : scores){
            if(max<score)
                max = score;
        }

        return max;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int noOfTestCases = in.nextInt();
        int inputSize = 0;
        int max = 0;
        ArrayList<Integer> results = new ArrayList<>();

        for(int i=0;i<noOfTestCases;i++){
            inputSize = in.nextInt();
            int[] input = new int[inputSize];

            for(int j=0;j<inputSize;j++) {
                input[j] = in.nextInt();
            }

            max = process(input);
            results.add(max);
        }

        for(int result : results){
            System.out.println(result);
        }
    }
}
