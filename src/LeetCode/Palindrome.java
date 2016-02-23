/**
 * Created by abhinit on 11/26/15.
 */
public class Palindrome {
    public static boolean isPalindrome(int x) {
        int rem1 = 0;
        int quo1 = 0;
        int rem2 = 0;
        long exp = 0;
        int quo2 = x;

        for (exp = 1; x / exp != 0; exp = exp * 10){

        }

        exp = (exp/10);

        for (quo1 = x; quo1 != 0; quo1 = quo1 / 10) {
            rem1 = quo1 % 10;
            rem2 = (int) (quo2 / exp);


            if (rem1 != rem2)
                return false;

            quo2 = (int)(quo2 % exp);
            exp = exp / 10;
        }

        return true;
    }
    public static void main(String[] args){

        if(isPalindrome(1000000001))
            System.out.println("yes");
    }
}

