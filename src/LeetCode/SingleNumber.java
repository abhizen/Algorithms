/**
 * Created by abhinit on 12/7/15.
 */
public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        int sum = 0;


        if(nums==null)
            return nums;

        if(nums.length==1)
            return nums;

        sum = nums[0];

        for(int i=1;i<nums.length;i++){
            sum = sum^nums[i];
        }

        int mask = sum&(~(sum-1));

        int sum1 = 0;
        int sum2 = 0;

        for(int i=0;i<nums.length;i++){

            if((nums[i]&mask)!=0){
                sum1 = sum1^nums[i];
            }
            else
                sum2 = sum2^nums[i];
        }

        int[] result = new int[2];

        result[0] = sum1;
        result[1] = sum2;
        return result;
    }
}
