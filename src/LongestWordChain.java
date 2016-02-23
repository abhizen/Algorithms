import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by abhinit on 10/29/15.
 */
public class LongestWordChain {
    private HashMap<String,Integer> inputMap = new HashMap<>();
    private String[] inputList = null;

    private int process(String[] inputList){

        this.inputList = inputList;

        for(String input : inputList){
            inputMap.put(input, 1);
        }

        Arrays.sort(this.inputList,new StringLengthCompare());


        int max = 0;
        int length = 0;
        String input = null;

        for(int index = this.inputList.length-1;index>=0;index--){
            input = this.inputList[index];
                length = this.getWordSubstringChainLength(input);
                if(max==0)
                    max = length;
                else if(max<length)
                    max = length;
        }

        return max;
    }

    private int getWordSubstringChainLength(String word){
        char[] charArray = word.toCharArray();
        StringBuilder substring = null;
        int length = 1;
        int maxLength = 1;
        int currentLength = 0;

        for(int i=0;i<word.length();i++) {
            if (i <= word.length() - 2) {
                substring = new StringBuilder(word.substring(0, i));
                substring.append(word.substring(i + 1, word.length()));
            } else {
                substring = new StringBuilder(word.substring(0, i));
            }

            /*this condition checks if string is present in
            *map and if string has max chain length*/
                //System.out.println("string:" +substring.toString());
                if (this.inputMap.get(substring.toString()) != null) {
                    length = this.inputMap.get(substring.toString());
                    currentLength = 1 + length;
                    maxLength = this.inputMap.get(word);

                    if(maxLength==1){
                        maxLength = currentLength;
                    }
                    else if(maxLength<currentLength){
                        maxLength = currentLength;
                    }

                    this.inputMap.put(word, maxLength);
                    //System.out.println(word + " :" + substring.toString() + maxLength);
                }
            }


        return this.inputMap.get(word);
    }



    private class StringLengthCompare implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
                return o2.length()-o1.length();
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int noOfInputStrings = in.nextInt();
        String[] inputList = new String[noOfInputStrings];

        for(int i=0;i<noOfInputStrings;i++){
            inputList[i] = in.next();
        }

        LongestWordChain instance = new LongestWordChain();
        System.out.println(instance.process(inputList));
    }
}
