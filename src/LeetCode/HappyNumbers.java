/**
 * Created by abhinit on 11/21/15.
 */
public class HappyNumbers {
    public static boolean isHappy(int n) {
        int result = n;

        if(n<10)
            result = n*n;

        while(result>=10){
            result = getSqSum(result);
        }

        if(result==1)
            return true;
        else
            return false;

    }

    private static int getSqSum(int num){
        int rem = 0;
        int quo = num;

        int sum = 0;


        for(quo=num;quo!=0;quo=(quo/10)){
            rem = quo%10;
            sum =sum + rem*rem;
        }

        if(num<10)
            sum = num*num;


        return sum;
    }

    public static void main(String[] args){

        int num = 7;

        if(isHappy(num)){
            System.out.println("true");
        }

    }
}
