/**
 * Created by abhinit on 1/4/16.
 */
public class MinimumSizeSubArray {
    public int minSubArrayLen(int s, int[] nums) {

        if(nums==null || nums.length==0)
            return 0;

        int i = 0;
        int j = 0;
        int sum = nums[0];
        int min = 0;

        while(i<=j && j<nums.length){
            if(sum>=s){
                if(min==0)
                    min = (j-i+1);
                else
                    min = Math.min(min,(j-i+1));
            }

            if(sum<s){
                j++;
                if(j<nums.length)
                    sum = sum + nums[j];
            }
            else if(sum>=s){

                sum = sum - nums[i];
                i++;
            }
        }

        return min;
    }
    public static void main(String[] args){
        MinimumSizeSubArray instance = new MinimumSizeSubArray();
        int[] nums = {2,3,1,2,4,3};
        int count = instance.minSubArrayLen(7,nums);
        System.out.println(count);
    }
}
