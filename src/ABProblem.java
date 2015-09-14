import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by abhinit on 9/13/15.
 */
public class ABProblem {
    private ArrayList<Character> newCombination = null;
    private static final int after = 1;
    private static final int before = -1;

    private Boolean createCombination(ArrayList<Character> combination,int N,int K){
        int count = countABCombinations(combination);

        if(count==K && combination.size()==N){
            newCombination = combination;
            return true;
        }
        else if(combination.size()>N || count>=K){
            return false;
        }


        return  createCombination(getNewCombination(combination,'A',after), N, K) ||
                createCombination(getNewCombination(combination,'B',after), N, K) ||
                createCombination(getNewCombination(combination,'A',before), N, K)||
                createCombination(getNewCombination(combination,'B',before), N, K);
    }
    private ArrayList<Character> getNewCombination(ArrayList<Character> combination,
                                                   Character letter,
                                                   int position){
        ArrayList<Character> newCombination = null;
        if(position==1) {
            newCombination = (ArrayList<Character>)combination.clone();
            newCombination.add(letter);
        }
        else if(position==-1){
            newCombination = new ArrayList<Character>();
            newCombination.add(letter);
            newCombination.addAll(combination);
        }

        return newCombination;
    }

    private String transformToString(ArrayList<Character> combination){
        String strCombination = "";
        for(Character c : combination){
            strCombination = strCombination + c;
        }
        return strCombination;
    }

    public String createString(int N, int K){
        ArrayList<Character> combination = new ArrayList();
        combination.add('A');
        createCombination(combination, N, K);

        return this.newCombination!=null?transformToString(this.newCombination):"";
    }

    private int countABCombinations(ArrayList<Character> combination){
        int count = 0;
        int index = 0;

        for(char c : combination){
            if(c=='A'){
                for(int i=index;i<combination.size();i++){
                    if(combination.get(i)=='B')
                        count++;
                }
            }
            index++;
        }

        return count;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String N = in.nextLine();
        String K = in.nextLine();
        ABProblem obj = new ABProblem();
        String combination =  obj.createString(Integer.parseInt(N), Integer.parseInt(K));
        if(combination!=null) {
            System.out.println(combination.toString());
        }
        else
            return;
    }
}
