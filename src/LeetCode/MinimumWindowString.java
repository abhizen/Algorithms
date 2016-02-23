import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhinit on 12/2/15.
 */
public class MinimumWindowString {

    private int begin = 0;
    private int end = 0;
    private int alphaCount = 0;

    public int process(String a,String b){
        Map<Character,Integer> map = getCountMap(b);

        int count = 0;
        int  j = 0;
        alphaCount = 0;
        int min =-1;
        for(int i=0;i<a.length();i++){

            if(map.get(a.charAt(i))!=null) {
                count = map.get(a.charAt(i)) - 1;
                map.put(a.charAt(i), count);

                if (count >= 0) {
                    alphaCount++;
                }
                else if (count < 0) {

                    while( j<a.length()) {
                        if(map.get(a.charAt(j))!=null &&
                                map.get(a.charAt(j))<0) {
                            count = map.get(a.charAt(j));
                            map.put(a.charAt(j),count+1);
                            j++;
                        }
                        else if(map.get(a.charAt(j))==null){
                            j++;
                        }
                        else
                            break;
                    }

                    if(j==a.length())
                        j--;
                }
            }
            else if(map.get(a.charAt(i))==null){

                while (j<a.length() && map.get(a.charAt(j))==null){
                    j++;
                }

                if(j==a.length())
                    j--;
            }

            if(alphaCount==b.length()){
                // map = getCountMap(b);

                if(min>=(i-j+1)){
                    begin = j;
                    end = i;
                    min = i-j+1;
                }
                else if(min==-1){
                    begin = j;
                    end = i;
                    min = i-j+1;
                }

                //j = i+1;
                //alphaCount = 0;
            }
        }

        return min;
    }

    private Map<Character,Integer> getCountMap(String b){
        Map<Character,Integer> map = new HashMap<>();
        int count = 0;

        for(char letter : b.toCharArray()){
            if(map.get(letter)==null)
                map.put(letter,1);
            else{
                count = map.get(letter);
                map.put(letter,count+1);
            }
        }
        return map;
    }
    public String minWindow(String s, String t) {

        if(s==null || t==null)
            return null;
        else if(s.length()<t.length())
            return "";

        int count = process(s, t);
        StringBuilder str = new StringBuilder();

        if(this.alphaCount==t.length()){
            for(int index=begin;index<=end;index++){
                str = str.append(s.charAt(index));
            }

            return str.toString();
        }
        else
            return "";


    }

    public static void main(String[] args){
        MinimumWindowString instance = new MinimumWindowString();

        String output = null;

        output = instance.minWindow("dbcdabc", "abc");
        System.out.println(output);

        output = instance.minWindow("dbcdaefbcda", "abc");
        System.out.println(output);
        output = instance.minWindow("aa", "aa");
        System.out.println(output);

    }

}
