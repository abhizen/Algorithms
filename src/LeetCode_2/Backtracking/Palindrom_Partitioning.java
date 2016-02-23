package Backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 12/31/15.
 */
public class Palindrom_Partitioning {
    public List<List<String>> partition(String s) {

        List<List<String>> list = createPartition(s,0);
        return list;
    }

    private List<List<String>> createPartition(String s,int index) {
        String subString = null;
        List<List<String>> partitionList = null;
        List<List<String>> tempList = new ArrayList();
        List<String> list= null;

        if(index==(s.length()))
            return new ArrayList();

        for(int i=index;i<s.length();i++){
            subString = s.substring(index, i + 1);
            if(subString!=null && subString.length()>0 && checkPalindrome(subString)){
                partitionList = createPartition(s,i+1);

                if(partitionList==null)
                    continue;

                if(partitionList.isEmpty()){
                    list = new ArrayList();
                    list.add(subString);
                    partitionList.add(list);
                }
                else {
                    for (List<String> tuple : partitionList) {
                        tuple.add(subString);
                    }
                }

                for(List<String> tuple : partitionList){
                    if(!tuple.isEmpty()) {
                        tempList.add(tuple);
                    }
                }
            }
        }

        if(tempList.isEmpty())
            return null;

        return tempList;
    }

    private boolean checkPalindrome(String token){

        if(token==null || token.length()==0)
            return false;

        for(int i=0;i<token.length();i++){
            if(token.charAt(i) != token.charAt(token.length()-i-1))
                return false;
        }

        return true;
    }
   /* private boolean checkPalindrome(String token){
        HashMap<Character,Integer> map = new HashMap();
        Character letter = '\0';
        int count = 0;
        int odd = 0;
        int even = 0;

        for(int i=0;i<token.length();i++){

            letter = token.charAt(i);
            if(map.get(letter)==null){
                count = 1;
                map.put(letter,count);
            }
            else{
                count = map.get(letter)+1;
                map.put(letter,count);
            }
        }

        for(Character l : map.keySet()){

            count = map.get(l);
            if(count%2==0)
                even++;
            else
                odd++;
        }

        if(odd<=1)
            return true;
        else
            return false;
    }*/
    public static void main(String[] args){
        Palindrom_Partitioning instance = new Palindrom_Partitioning();
        String str = "aab";
        List<List<String>> list =  instance.partition(str);

        for(List<String> tuple : list){
            for(String elem : tuple){
                System.out.print(elem + ",");
            }
            System.out.println("");
        }
    }
}
