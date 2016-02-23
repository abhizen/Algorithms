/**
 * Created by abhinit on 12/24/15.
 */
public class MaximumProductofWordLengths {
    public static int maxProduct(String[] words) {
        int[] wordMap  = new int[words.length];
        int k = 0;
        int j = 0;

        for(String word : words){
            k = 0;
            for(int i=0;i<word.length();i++){
                k = k | (1<<(char)word.charAt(i)); //Shifts the bits of 1 by word.charAt(i) number of times

            }

            wordMap[j] = k;
            j++;
        }

        int prod = 0;
        int maxProd = 0;

        for(int i =0;i<words.length;i++){
            k = wordMap[i];
            for(j=i+1;j<words.length;j++){
                if((k&wordMap[j])==0)
                    prod = words[i].length()*words[j].length();
                if(prod>maxProd)
                    maxProd = prod;
            }
        }

        return maxProd;
    }

    public static void main(String[] args){
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        int maxProd = maxProduct(words);
        System.out.println(maxProd);
    }
}
