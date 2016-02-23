
import java.util.Scanner;
import java.util.HashMap;

/**
 * Created by abhinit on 9/5/15.
 */
public class StringPermutations {

    private  static void permutations(HashMap<Character,Boolean> charMap,int maxLength,int length,String result ){
        HashMap<Character,Boolean> newMap = null;
        if(length>maxLength) {
            System.out.println(result);
            return;
        }

        for(Character c : charMap.keySet()){
                if(charMap.get(c)==false) {
                    newMap = (HashMap<Character, Boolean>) charMap.clone();
                    newMap.put(c, true);
                    String newStr = result.concat(c.toString());
                    permutations(newMap, maxLength, length+1, newStr);
                }
        }

    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        HashMap<Character,Boolean> charMap = new HashMap<Character,Boolean>();
        for(Character c : name.toCharArray()){
            charMap.put(c,false);
        }
        permutations(charMap,name.length()-1,0,"");
    }
}
