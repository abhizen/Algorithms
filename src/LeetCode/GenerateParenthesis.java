import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by abhinit on 12/9/15.
 */
public class GenerateParenthesis {

    public static List<String> generate(String seed,int count){
        List<String> list = null;

        if(count==0){
            list = new ArrayList();
             list.add(seed);
               return list;
        }

        if(seed.length()==0)
            list = generate(seed+"(",count-1);
        else{
            List<String> list1 = generate(seed+"(",count-1);
            List<String> list2 = generate(seed+")",count-1);

            list = new ArrayList<String>();

            for(String elem : list1){
                if(checkParenthesis(elem))
                    list.add(elem);
            }

            for(String elem : list2){
                if(checkParenthesis(elem))
                    list.add(elem);
            }
        }

        return list;
    }

    private static boolean checkParenthesis(String parenthesis){
        int open = 0;
        int close = 0;
        Stack<Character> stack = new Stack<>();
        Character elem = '\0';

        for(int i=0;i<parenthesis.length();i++){
            elem = parenthesis.charAt(i);

            if(elem.equals('(')){
                stack.push(elem);
                open++;
            }
            else if(elem.equals(')')){
                close++;
                while (!stack.isEmpty() && (elem=stack.pop())!='(');

                if(!elem.equals('(') && stack.isEmpty())
                    return false;
            }

        }

        if(open!=close)
            return false;
        else
            return true;
    }

    public static void main(String[] args){
        List<String> list = generate("",6);

        for(String elem : list){
            System.out.println(elem+" ");
        }
    }
}
