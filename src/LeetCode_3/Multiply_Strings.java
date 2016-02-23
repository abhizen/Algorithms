/**
 * Created by abhinit on 2/6/16.
 */
public class Multiply_Strings {
    public static String multiply(String num1, String num2) {
        int carry = 0;
        String sum = "",currSum = "";
        int elem1 = 0,elem2=0;
        int exp =0,exp1=0;

        for(int j=num2.length()-1;j>=0;j--){
            elem1 = (num2.charAt(j))-'0';
            exp=0;
            carry=0;
            currSum="";
            for(int i=num1.length()-1;i>=0;i--){
                elem2 =(num1.charAt(i))-'0';
                //currSum = currSum + ((elem1*elem2)%10+carry)*(int)Math.pow(10,exp);
                currSum = ((elem1*elem2)%10+carry)+currSum;
                carry = (elem1*elem2)/10;
                exp++;
            }
            //currSum = currSum + carry*(int)Math.pow(10,exp);
            currSum = (carry>0?carry:"")+currSum;
            //sum = sum + currSum*(int)Math.pow(10,exp1);
            for(int i=0;i<exp1;i++){
                currSum = currSum + '0';
            }
            sum = getSum(currSum,sum);
            exp1++;
        }

        return sum;
    }

    private static String getSum(String elem1,String elem2){
        String sum = "";
        int currSum = 0,carry=0;
        int len = elem1.length();
        int digit1=0,digit2=0;
        int j= elem2.length()-1;

        for(int i=len-1;i>=0;i--){
            if(j>=0){
                currSum = (elem1.charAt(i)-'0'+elem2.charAt(j)-'0'+carry)%10;
                carry = (elem1.charAt(i)-'0'+elem2.charAt(j)-'0')/10;

            }
            else{
                currSum = (elem1.charAt(i)-'0'+carry)%10;
                carry = (elem1.charAt(i)-'0')/10;
            }
            sum = currSum+sum;
            j--;
        }


        while(j>=0){
            currSum =  (elem2.charAt(j)-'0'+carry)%10;
            carry = (elem2.charAt(j)-'0'+carry)/10;
            sum = currSum+sum;
            j--;
        }

        return sum;
    }

    public static void main(String[] args){
        String num1 = "121";
        String num2 = "11";

        String sum = multiply(num1,num2);
        System.out.println(sum);
    }
}
