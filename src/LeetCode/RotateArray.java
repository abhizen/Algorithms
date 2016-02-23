import java.util.Stack;

/**
 * Created by abhinit on 11/27/15.
 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {

        if(nums==null)
            return;

        int len = nums.length;
        int position = 0;
        int temp = 0;

        for(int i=0;i<(k>len?len:k);i++){
            position = i+k;

            if((i+k)>=len)
                position = position%len;

            temp = nums[i];
            nums[i] = nums[position];
            nums[position] = temp;
        }

    }


    public static void rotateOpt(int[] nums, int k) {

        if(nums==null)
            return;

        int len = nums.length;
        int effLen = gcd(len,k);

        int temp = 0;
        int j = 0;
        int  p =0;

        for(int i=0;i<gcd(k,len);i++) {

            p = i;
            j = i;
            while (true){
                p = p + k;

                if(p>=len)
                    p =  p%len;

                if(i==p)
                    break;

                //swap logic
                temp = nums[p];
                nums[p] = nums[j];
                nums[j] = temp;

                j = p;
            }
        }
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }


    public static void main(String[] args){
        int[] nums = {1,2};
        int k = 3;

        //rotate(nums,k);
        rotateOpt(nums,k);

        for(int elem : nums)
            System.out.println(elem);

        Stack<Integer> stack = new Stack<>();

    }
}
