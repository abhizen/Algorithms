/**
 * Created by abhinit on 1/23/16.
 */
public class SqrtOfNumber {
    public int mySqrt(int x) {
        if(x<0)
            return -1;

        int root = (int)getSqrt((double)x);
        return root;
    }

    private double getSqrt(double x){
        double root = 0;

        if(x<2){
            return Math.sqrt(x);
        }
        root = getSqrt(x/2);

        return Math.sqrt(2)*root;
    }

    public static void main(String[] args){
        SqrtOfNumber instance = new SqrtOfNumber();
        int root = instance.mySqrt(49);
        System.out.println(root);
    }
}
