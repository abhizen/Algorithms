/**
 * Created by abhinit on 12/9/15.
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {

        if(nums==null)
            return -1;

        int len = nums.length;


        for(int i=0;i<len;i++){
            if((Math.abs(nums[i])<len))
            nums[(int)Math.abs(nums[i])]  = -1*nums[(int)Math.abs(nums[i])];
        }

        for(int i=0;i<len;i++){
            if(nums[i]>0)
                return i;
        }

        return len;
    }

    public static void main(String[] args){
        int[] input = {2,0};

        int output = missingNumber(input);
        System.out.println(output);
    }
}
