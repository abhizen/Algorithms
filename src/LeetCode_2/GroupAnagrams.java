import java.util.*;

/**
 * Created by abhinit on 1/3/16.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        String token = null;
        Map<String,List<String>> map = new LinkedHashMap<String, List<String>>();
        List<String> anagrams = null;
        char[] arr = null;

        Arrays.sort(strs);

        for(String elem : strs){

            if(elem.length()==0)
                token = "";
            else {
                token = elem;
                arr = token.toCharArray();
                Arrays.sort(arr);
                token = toString(arr);
            }

            if(map.get(token)==null){
                anagrams = new ArrayList();
                anagrams.add(elem);
                map.put(token,anagrams);
            }
            else{
                anagrams = map.get(token);
                anagrams.add(elem);
                map.put(token,anagrams);
            }
        }

        List<List<String>> list = new ArrayList();
        for(String elem : map.keySet()){
            list.add(map.get(elem));
        }

        return list;
    }

    private String toString(char[] letters){
        StringBuilder str = new StringBuilder();

        for(char letter : letters){
            str = str.append(letter);
        }

        return str.toString();

    }
    public static void main(String[] args){
        GroupAnagrams instance = new GroupAnagrams();
        String[] strs = {"aba","acd","baa"};
        List<List<String>> list = instance.groupAnagrams(strs);

        for(List<String> tuple : list){
            for(String elem : tuple) {
                System.out.print(elem + " ");
            }
            System.out.println("");
        }
    }
}
