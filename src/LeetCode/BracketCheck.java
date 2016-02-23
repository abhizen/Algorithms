import java.util.Stack;

/**
 * Created by abhinit on 11/26/15.
 */
public class BracketCheck {
    public static boolean isValid(String s) {

        if(s==null)
            return true;
        else if(s.length()==0)
            return true;

        Stack<Character> stack = new Stack();
        char letter = '\0';

        for(int i=0;i<s.length();i++){
            letter = s.charAt(i);

            if(letter=='}') {
                while(!stack.isEmpty() && letter!='{') {

                    if(letter=='(' || letter=='[')
                        return false;

                    letter = stack.pop();
                }

                if(letter!='{')
                    return false;
            }
            else if(letter==')') {
                while(!stack.isEmpty() && letter!='(') {

                    if(letter=='{' || letter=='[')
                        return false;

                    letter = stack.pop();
                }

                if(letter!='(')
                    return false;
            }
            else if(letter==']') {
                while(!stack.isEmpty() && letter!='[') {

                    if(letter=='{' || letter=='(')
                        return false;

                    letter = stack.pop();
                }

                if(letter!='[')
                    return false;
            }
            else{
                stack.push(letter);
            }
        }

        if(!stack.isEmpty())
            return false;


        return true;
    }

    public static void main(String[] args){
        String input = "([])";

        if(isValid(input))
            System.out.println("Valid");
    }
}
