/**
 * Created by abhinit on 12/11/15.
 */
public class JumpGame {
    public static int[][] process(int[] input){
        int[][] memoize = new int[input.length+1][input.length+1];

        for(int i=0;i<input.length+1;i++){
            memoize[i][0] = -1;
            memoize[0][i] = -1;
        }




        memoize[1][1] = 0;

        for(int i=1;i<input.length+1;i++){
            for(int j=1;j<input.length+1;j++){
                if(j>i){
                    memoize[i][j] = -1;
                }
                else if(i==1 && j ==1) {
                    memoize[i][j] = 0;
                }
                else{

                    if(input[j-1]+j>=i && memoize[i][j-1]>=0 && i!=j)
                        memoize[i][j] = Math.min(memoize[j][j]+1,memoize[i][j-1]);
                    /*else if(input[j-1]+j>=i && memoize[i][j-1]>=0 && i==j)
                        memoize[i][j] = memoize[i][j-1];
                    else if(input[j-1]+j<i && memoize[i][j-1]>=0 && i!=j)
                        memoize[i][j] = memoize[i][j-1];*/
                    else if(memoize[i][j-1]>=0)
                        memoize[i][j] = memoize[i][j-1];
                    else if(memoize[i][j-1]<0 && input[j-1]+j>=i && i!=j)
                        memoize[i][j] = memoize[j][j]+1;
                    else
                        memoize[i][j] = -1;
                }

            }
        }

        return memoize;
    }

    /*alternate way*/
    public static int countSteps(int[] input){
        int destination = 0;
        int stepCount = 0;

        destination = input[0];

        for(int i=1;i<input.length;i++){

            if(input[i]!=0 && destination<(i + input[i])) {
                destination = input[i] + i;
                stepCount++;
            }
            else if(destination<=i && input[i]==0)
                break;

            if(destination>=input.length-1)
                return stepCount;

        }

        if(destination>=input.length-1)
            return stepCount;
        else
            return -1;
    }

    public static void main(String[] args){
        int[] input = {1,1,2,1,2,3};
        int[][] memoize = process(input);

        for(int i = input.length;i>=0;i--){
            for(int j = 0;j<input.length+1;j++){
                System.out.print(memoize[i][j]+" ");
            }
            System.out.println("");
        }

        int[] input1 = {2,5,0,0};
        int steps = countSteps(input);
        System.out.println("steps"+steps);
    }
}
