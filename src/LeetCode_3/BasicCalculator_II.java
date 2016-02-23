import java.math.BigInteger;
import java.util.Stack;

/**
 * Created by abhinit on 1/26/16.
 */
public class BasicCalculator_II {
    public int calculate(String s) {

        if(s==null)
            return 0;

        String str = s.trim();
        Stack<String> stack = new Stack();
        String elem = null;
        char letter = '\0';

        for(int i=0;i<str.length();i++){
            letter = str.charAt(i);

            if(letter==' ')
                continue;

            if(stack.isEmpty()){
                elem = Character.toString(letter);
                stack.push(elem);
            }
            else if(!stack.isEmpty() && ((letter=='+')
                    ||(letter=='-')||(letter=='*')||(letter=='/'))){
                //elem = Character.toString(letter);
                elem = operate(stack);
                stack.push(elem);
                stack.push(Character.toString(letter));
            }
            else if(!stack.isEmpty() && !((letter=='+')
                    ||(letter=='-')||(letter=='*')||(letter=='/'))){
                elem = stack.peek();
                if(elem.equals("+")
                        ||elem.equals("-")||elem.equals("*")||elem.equals("/")) {
                    stack.push(Character.toString(letter));
                }
                else {
                    //elem = operate(stack,elem,letter);
                    //elem = elem+letter;
                    elem = stack.pop() + letter;
                    stack.push(elem);
                }
            }
        }

        elem = operate(stack);

        return Integer.parseInt(elem);
    }

    private String operate(Stack<String> stack){
        String str = null;
        String opt=  null;
        BigInteger a = null , b=null;

        str = stack.pop();

        if(!stack.isEmpty()){
            opt = stack.pop();
            a = new BigInteger(str);
            b = new BigInteger(stack.pop());
            if(opt.equals("+"))
                return a.add(b).toString();
            else if(opt.equals("-"))
                return a.subtract(b).toString();
            else if(opt.equals("*"))
                return a.multiply(b).toString();
            else if(opt.equals("/"))
                return a.divide(b).toString();
        }

        return str;
    }
    public static void main(String[] args){
        BasicCalculator_II instance = new BasicCalculator_II();
        int count = instance.calculate("1+10+100+1000+10000");
        System.out.println(count);
    }
}
