/**
 * Created by abhinit on 1/27/16.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        char ops = '+';
        int sign = 1, curr = 0, prev = 0, val = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 48 && c <= 57) {
                val = val*10 + (c - 48);
                continue;
            } else if(c == ' ') continue;
            curr = getCurrentVal(ops, val, curr);
            if(c == '+' || c == '-') {
                prev += curr * sign;
                sign = (c == '+')? 1: -1;
            } else if(ops == '+' || ops == '-') curr = val;
            ops = c;
            val = 0;
        }
        return prev + getCurrentVal(ops, val, curr) * sign;
    }
    private int getCurrentVal(char ops, int val, int curr) {
        if(ops == '*') curr *= val;
        else if(ops == '/') curr /= val;
        else curr = val;
        return curr;
    }
    public static void main(String[] args){
        BasicCalculatorII instance = new BasicCalculatorII();
        String str = "1+2*3";
        int output = instance.calculate(str);
        System.out.println(output);
    }
}
