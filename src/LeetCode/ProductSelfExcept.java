/**
 * Created by abhinit on 12/9/15.
 */
public class ProductSelfExcept {
    public static int[] productExceptSelf(int[] nums) {

        if(nums==null)
            return null;

        int len = nums.length;
        int[] output = new int[len];
        int[] output2 = new int[len];

        output[len-1] = 1;

        if(len>=2)
            output[len-2] = nums[len-1];

        for(int i=len-3;i>=0;i--){
            output[i] = nums[i+1] * output[i+1];
        }

        output2[0] = 1;

        if(len>1)
            output2[1] = nums[0];

        for(int i=2;i<len;i++){
            output2[i] = nums[i-1]*output2[i-1];
        }

        output[len-1] = output2[len-1];

        for(int i=1;i<len-1;i++){
            output[i] = output[i]*output2[i];
        }

        return output;
    }
    public static void main(String[] args){
        int[] input = {1,2,3};

        int[] output = productExceptSelf(input);

        for(int elem: output){
            System.out.println(elem+" ");
        }
    }

}
