import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by abhinit on 1/2/16.
 */
public class Phone_number {
    Map<Integer,List<Character>> map = new HashMap();


    Phone_number(){
        map.put(1, new ArrayList<Character>());
        ArrayList list = new ArrayList();
        list.add('a');
        list.add('b');
        list.add('c');
        map.put(2, list);
        list = new ArrayList();
        list.add('d');
        list.add('e');
        list.add('f');
        map.put(3, list);
        list = new ArrayList();
        list.add('g');
        list.add('h');
        list.add('i');
        map.put(4, list);
        list = new ArrayList();
        list.add('j');
        list.add('k');
        list.add('l');
        map.put(5, list);
        list = new ArrayList();
        list.add('m');
        list.add('n');
        list.add('o');
        map.put(6, list);
        list = new ArrayList();
        list.add('p');
        list.add('q');
        list.add('r');
        list.add('s');
        map.put(7, list);
        list = new ArrayList();
        list.add('t');
        list.add('u');
        list.add('v');
        map.put(8, list);
        list = new ArrayList();
        list.add('w');
        list.add('x');
        list.add('y');
        list.add('z');
        map.put(9, list);
    }

    public List<String> letterCombinations(String digits) {
        List<Character> tuple = null;
        Integer digit = 0;
        List<String> result = new ArrayList();
        List<String> tempResult = null;
        String temp = "";

        for(int i=0;i<digits.length();i++){
            digit = Character.getNumericValue(digits.charAt(i));
            tuple = map.get(digit);

            tempResult = new ArrayList<String>();

            for(Character elem : tuple) {

                if(result.isEmpty()){
                    temp = "" + elem;
                    tempResult.add(temp);
                }
                else {
                    for (String token : result) {
                        temp = token + elem;
                        tempResult.add(temp);
                    }
                }
            }

            result = getCopy(tempResult);
        }

        return result;
    }

    private List<String> getCopy(List<String> list){
        List<String> copy = new ArrayList();

        for(String elem : list){
            copy.add(elem);
        }

        return copy;
    }

    public static void main(String[] args){
        Phone_number instance = new Phone_number();
        List<String> list = instance.letterCombinations("123");

        for(String tuple : list)
            System.out.println(tuple);
    }
}
