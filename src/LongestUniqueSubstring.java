

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhinit on 11/18/15.
 */
public class LongestUniqueSubstring {
    private int[][] memo = null;
    private List<String> substrList = new ArrayList<>();

    public String process(String input){
        memoize(input);
        String result = getMax();
        return result;
    }

    private void memoize(String input){
        //initialization
        memo = new int[input.length()][input.length()];

        for(int i=0;i<input.length();i++){
            memo[0][i] = 1;

            substrList.add(Character.toString(input.charAt(i)));
        }

        char letter = '\0';
        String substr = null;
        //memoization
        for(int i=1;i<input.length();i++){
            for(int j=0;j<input.length();j++){
                if(i+j<input.length()) {
                    letter = input.charAt(j + i);
                    substr = substrList.get(j);
                    if (substr.indexOf(letter) < 0 && ((i > 1 && memo[i - 1][j] != memo[i - 2][j])
                            || i <= 1)) {

                        substr = substr.concat(Character.toString(letter));
                        memo[i][j] = memo[i - 1][j] + 1;
                        //substrList.add(j,substr);
                        substrList.set(j, substr);
                    } else
                        memo[i][j] = memo[i - 1][j];
                }
                else{
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
    }

    private String getMax(){
        int max = 0;
        int maxj = 0;
        String elem = null;

        for(int j=0;j<memo[0].length;j++){
            elem = this.substrList.get(j);
            if(j==0){
                max = memo[memo.length-1][j];
            }
            else if(max<memo[memo.length-1][j]){
                max = memo[memo.length-1][j];
                maxj = j;
            }
        }

        return this.substrList.get(maxj);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        LongestUniqueSubstring instance = new LongestUniqueSubstring();
        System.out.println(instance.process(input));
    }

}
