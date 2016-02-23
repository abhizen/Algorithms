import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhinit on 2/12/16.
 */
public class BasicCalculator {
    public int calculate(String s){
        StringBuilder output = new StringBuilder();
        int index = process(s,0,output);
        return Integer.parseInt(output.toString());
    }

    private int process(String s,int index,StringBuilder output) {
        char letter = '\0';
        boolean sign = true;
        int sum = 0;
        String num = "";
        int i=0;


        for(i=index;i<s.length();i++){
            letter = s.charAt(i);

            if(letter==' ')
                continue;

            if(letter==')')
                break;


            num = "";
            while(i<s.length() && letter!='(' && letter!=')' && letter!='+' && letter!='-'){

                if(letter!=' '){
                    num = num+letter;

                }

                i++;
                if(i<s.length())
                    letter = s.charAt(i);
            }

            if(letter=='('){
                i = process(s,i+1,output);
                num = output.toString();
                output.delete(0,output.length());
            }

            if(num.length()>0){
                if(sign)    sum = sum + Integer.parseInt(num);
                else  sum = sum - Integer.parseInt(num);
            }

            if(letter=='+'){
                sign = true;
            }
            else if(letter=='-')
                sign = false;

            if(letter==')')
                break;

        }

         output.append(Integer.toString(sum));
        return i;
    }
    public static void main(String[] args){
        BasicCalculator instance = new BasicCalculator();
        String str= "(7)-(0)+(4)";
        int output = instance.calculate(str);
        System.out.println(output);
        Map<Integer,Boolean> map = new HashMap();
        
    }
}
