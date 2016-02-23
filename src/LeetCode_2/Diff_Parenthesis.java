import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by abhinit on 12/26/15.
 */
public class Diff_Parenthesis {
    //public List<String> list = new ArrayList<String>();
    public HashMap<String,Boolean> optMap = new HashMap<String, Boolean>();

    public List<Integer> diffWaysToCompute(String input) {
        return null;
    }

    public void generatePerm(String input,int index,int numOpen,int numClose,String opt){
        String temp = null;


        if(index>(input.length()-1) && numClose!=0 && numClose==numOpen && checkBalanced(opt)) {
            //list.add(opt);
            if(optMap.get(opt)==null){
                optMap.put(opt,true);
            }
            return;
        }
        else if(index>(input.length()-1))
            return;

        for(int i=index;i<input.length();i++){

            if(i==0){
                generatePerm(input,i+1,numOpen,numClose,"("+opt+input.charAt(i));
            }
            else if(i==(input.length()-1)){
                generatePerm(input,i+1,numOpen,numClose,opt+input.charAt(i)+")");
            }
            else if(input.charAt(i)=='-' || input.charAt(i)=='*' || input.charAt(i)=='+'){
                generatePerm(input,i+1,numOpen+1,numClose,opt+input.charAt(i)+"(");
                generatePerm(input,i+1,numOpen,numClose+1,opt+")"+input.charAt(i));
                opt = opt+input.charAt(i);
            }
            else{
                opt = opt+input.charAt(i);
                generatePerm(input,i+1,numOpen,numClose,opt);
                generatePerm(input,i+1,numOpen+1,numClose,"("+opt);
            }

        }

    }

    public boolean checkBalanced(String opt){
        Stack<Character> stack = new Stack<Character>();
        Character elem = '\0';

        for(int i=0;i<opt.length();i++){

            if(opt.charAt(i)==')'){

                while (!stack.isEmpty()){
                    elem = stack.pop();
                    if(elem=='(')
                        break;
                }

                if(stack.isEmpty() && elem!='(')
                    return false;
            }
            else {
                stack.push(opt.charAt(i));
            }
        }

        return true;
    }

    /*private int process(String opt){
        Stack<Character> stack = new Stack<Character>();
        Character elem = '\0';
        int result = 0;
        int digit = 0;
        char operator = '\0';

        for(int i=0;i<opt.length();i++){

            if(opt.charAt(i)==')'){

                while (!stack.isEmpty()){
                    elem = stack.pop();
                    if(elem=='(') {
                        break;
                    }
                    else if(elem=='-' || elem=='*' || elem=='+'){
                        operator = elem;
                    }
                    else
                        digit = Character.valueOf(elem);
                }

                if(stack.isEmpty() && elem!='(')
                    return false;
            }
            else {
                stack.push(opt.charAt(i));
            }
        }

        return true;
    }*/

    public static void main(String[] args){
        Diff_Parenthesis instance = new Diff_Parenthesis();
        String input = "2-1-1";
        instance.generatePerm(input,0,0,0,"");
        HashMap<String,Boolean> output = instance.optMap;

        for(String elem : output.keySet())
            System.out.println(elem);

    }
}
