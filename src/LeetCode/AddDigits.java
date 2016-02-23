/**
 * Created by abhinit on 11/21/15.
 */
public class AddDigits {
    public static int addDigits(int num) {
        int quo = num;
        int rem = 0;

        int sum = 0;

        while(quo>=10){
            sum = 0;
            while((rem=quo%10)!=0){
                quo = quo/10;
                sum = sum + rem;
            }
            quo = quo/10;
            sum = sum + quo;

            quo = sum;
        }

        return quo;
    }

    public static int O1Approach(int num){
        int root = num - 9*((num-1)/9);
        return root;
    }

    public static void main(String[] args){

        int num = 21;
        int result = O1Approach(num);
        int result1 = addDigits(num);
        System.out.println(result+" "+result1);
    }
}
