import java.util.HashMap;

/**
 * Created by abhinit on 12/18/15.
 */
public class LongestStringWithoutRepeatition {
    public int lengthOfLongestSubstring(String s) {

        if(s==null)
            return 0;
        else if(s.length()==0)
            return 0;

        int beginIndex = 0;
        int endIndex = 0;
        int maxLength = 0;
        int length = 0;
        char letter = '\0';
        int count = 0;
        HashMap<Character,Integer> charMap = new HashMap();

        //charMap.put(s.charAt(beginIndex),1);

        while(beginIndex<s.length() && endIndex<s.length()){



            if(beginIndex==endIndex && beginIndex>0)
                endIndex++;
            else if(charMap.get(s.charAt(endIndex))==null){
                charMap.put(s.charAt(endIndex),1);
                length = endIndex - beginIndex + 1;

                if(length>maxLength)
                    maxLength = length;
                endIndex++;
            }
            else if(charMap.get(s.charAt(endIndex))!=null && charMap.get(s.charAt(endIndex))>0){

                count = charMap.get(s.charAt(endIndex));
                charMap.put(s.charAt(endIndex),count+1);

                count = charMap.get(s.charAt(beginIndex));
                charMap.put(s.charAt(beginIndex),count-1);

                beginIndex++;
            }
            else if(charMap.get(s.charAt(endIndex))!=null && charMap.get(s.charAt(endIndex))==0 && beginIndex!=endIndex){
                length = endIndex - beginIndex + 1;

                count = charMap.get(s.charAt(endIndex));
                charMap.put(s.charAt(endIndex),count+1);

                if(length>maxLength)
                    maxLength = length;
                endIndex++;
            }
            else
                endIndex++;
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring_new(String s) {
        int[] table = new int[95];
        int maxLength = 0;
        int curbegin = 0;
        int curLength = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int temp = s.charAt(i) - ' ';
            if (table[temp] - 1 >= curbegin)
            {
                maxLength = maxLength > curLength ? maxLength: curLength;
                curLength = i - table[temp] + 1;
                curbegin = table[temp];
            }
            else
                curLength++;
            table[temp] = i + 1;
        }

        return maxLength > curLength ? maxLength: curLength;
    }

    public static void main(String[] args){
        LongestStringWithoutRepeatition instance = new LongestStringWithoutRepeatition();
        String s = "abca";
        int len = instance.lengthOfLongestSubstring_new(s);
        System.out.println("length "+len);
    }
}
