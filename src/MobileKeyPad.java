import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by abhinit on 9/12/15.
 */
public class MobileKeyPad {
    private HashMap<Integer,ArrayList<Character>> keyCharListMap
            = new HashMap<>();

    private ArrayList<Integer> keyList = new ArrayList<>();

    public MobileKeyPad(){
        loadKeyPadMap();
    }

    private void loadKeyPadMap(){
        ArrayList<Character> charList = null;
        this.keyCharListMap.put(1,(charList = new ArrayList()));
        charList = new ArrayList<>();
        charList.add('A');
        charList.add('B');
        charList.add('C');
        this.keyCharListMap.put(2,charList);
        charList = new ArrayList<>();
        charList.add('D');
        charList.add('E');
        charList.add('F');
        this.keyCharListMap.put(3, charList);
        charList = new ArrayList<>();
        charList.add('G');
        charList.add('H');
        charList.add('I');
        this.keyCharListMap.put(4, charList);
        charList = new ArrayList<>();
        charList.add('J');
        charList.add('K');
        charList.add('L');
        this.keyCharListMap.put(5,charList);
        charList = new ArrayList<>();
        charList.add('M');
        charList.add('N');
        charList.add('O');
        this.keyCharListMap.put(6,charList);
        charList = new ArrayList<>();
        charList.add('P');
        charList.add('R');
        charList.add('S');
        this.keyCharListMap.put(7,charList);
        charList = new ArrayList<>();
        charList.add('T');
        charList.add('U');
        charList.add('V');
        this.keyCharListMap.put(8,charList);
        charList = new ArrayList<>();
        charList.add('W');
        charList.add('X');
        charList.add('Y');
        this.keyCharListMap.put(9,charList);
    }

    private Character getLetter(ArrayList<Character> charList,int index,
                                HashMap<Character,Boolean> charMap){

        for(Character letter : charList){
            if(charMap.get(letter)!=null){
                return letter;
            }
        }

        return null;
    }
    public void printCombinations(String combination,ArrayList<Integer> keyList,
                                  int index,
                                  HashMap<Character,Boolean> charMap){
        if(keyList.size()==index) {
            System.out.println(combination);
            return;
        }

        ArrayList<Character> charList = this.keyCharListMap.get(keyList.get(index));

        HashMap<Character,Boolean> newCharMap = null;
        String newCombo = null;

        if(charList.size()==0) {
            newCombo = combination.concat(keyList.get(index).toString());
            newCharMap = ( HashMap<Character,Boolean>)charMap.clone();
            int key = keyList.get(index);
            newCharMap.put((char)key, true);
            index++;
            printCombinations(newCombo,keyList,index,newCharMap);
        }

        index++;
        for(Character letter : charList){
            if(charMap.get(letter)==null) {
                newCombo = combination.concat(letter.toString());
                newCharMap = (HashMap<Character, Boolean>) charMap.clone();
                newCharMap.put(letter, true);
                printCombinations(newCombo, keyList, index, newCharMap);
            }
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> keyList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        for(int i=0;i<2;i++){
            keyList.add(in.nextInt());
        }
        String combination = new String();
        MobileKeyPad mobKeyPad = new MobileKeyPad();
        mobKeyPad.printCombinations(combination,keyList,
        0,
        new HashMap<Character,Boolean>());
    }
}
