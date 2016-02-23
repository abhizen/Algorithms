/**
 * Created by abhinit on 11/27/15.
 */
public class Atoi {
    public static int myAtoi(String str) {


        if(str==null)
            return 0;
        if(str.equals("+") || str.equals("-"))
            return 0;

        int len = str.length();
        long power = (long)Math.pow(10,len-1);
        char letter = '\0';
        int digit = 0;
        int number = 0;
        int minus = 0;

        for(int i=0;i<len;i++){
            letter = str.charAt(i);

            if(letter!=Character.valueOf('+') && letter!=Character.valueOf('-')) {
                digit = Character.getNumericValue(letter);
                number = ((int) (digit * power)) + number;
            }
            else if(letter=='-')
                minus = 1;

            power = power/10;
        }

        if(minus==1)
            number = -1*number;

        return number;
    }

    public static int myAtoi_v1(String str){


        if(str==null)
            return 0;

        str = str.trim();

        if(str.length()==0)
            return 0;

        if(str.equals("+") || str.equals("-"))
            return 0;

        int start = 0;
        int sign = 0;

        long sum = 0;
        char letter='\0';

        if(str.charAt(start)=='+'){
            sign=0;
            start++;
        }
        else if(str.charAt(start)=='-'){
            sign=1;
            start++;
        }


        for(int index=start;index<str.length();index++){
            letter = str.charAt(index);
            if(!Character.isDigit(letter))
                return (int)(sign==0?sum:(-1*sum));

            sum = sum*10 + Character.getNumericValue(letter);

            if(sign==0 && sum>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if(sign==1 && -1*sum<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int)(sign==0?sum:(-1*sum));
    }

    public static void main(String[] args){
     String str = "-1";
        int num = myAtoi(str);
        System.out.println(num);
    }
}
