/**
 * Created by abhinit on 2/6/16.
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        boolean[][] matrix = new boolean[s.length()][s.length()];
        int len = s.length();
        int max = 1;
        String result = null;

        for(int i=0;i<len;i++){
            matrix[i][i] = true;
        }

        for(int i=0;i<len-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                matrix[i][i+1] = true;
                max = 2;
                result = s.substring(i,i+2);
            }
        }


            for(int j=2;j<len;j++){
                for(int i=0;i<len-1;i++){
                if(i+j<len && s.charAt(i)==s.charAt(i+j)
                        && matrix[i+1][i+j-1]==true){
                    matrix[i][i+j] = true;
                    if(j+1>max){
                        result = s.substring(i,i+j+1);
                        max = j;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        String input = "ccc";
        String output = longestPalindrome(input);
        System.out.println(output);
    }
}
