/**
 * Created by abhinit on 11/26/15.
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int sum = 0;
        int carry = 1;
        int result[] = new int[digits.length+1];

        if(digits==null)
            return digits;
        else if(digits.length==0)
            return digits;

        for(int i=digits.length-1;i>=0;i--) {
            sum = digits[i] + carry;
            digits[i] = (sum%10);
            result[i] = digits[i];
            carry = (sum/10);
        }

        if(carry>=1){
            result[0] = carry;
            return result;
        }
        else
            return digits;
    }
    public static void main(String[] args){
        int[] input = {9};
        int[] result = plusOne(input);
        System.out.println(result[1]+" "+result[0]);
    }
}
