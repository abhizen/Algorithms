/**
 * Created by abhinit on 12/9/15.
 */
public class MaximumSubArray {
    public static int maxSubArray(int[] nums) {
        int head = 0;
        int length = 0;
        int sum = 0;
        int maxSum = 0;

        if(nums==null)
            return 0;
        else if(nums.length==1)
            return nums[0];

        for(int i=0;i<nums.length;i++){

            if(i==0){
                sum = nums[i];
                maxSum = sum;
            }
            else if(i>0 && nums[i]+sum>sum && ((sum>=0 && nums[i]>=0)||(sum<0 && nums[i]<0))){
                sum = nums[i]+sum;
                if(sum>maxSum)
                    maxSum = sum;
            }
            else if(sum<0 && nums[i]>0){
                sum = nums[i];
                if(sum>maxSum)
                    maxSum = sum;
            }
            else if(i>0 && nums[i]+sum<=sum && nums[i]>sum){
                sum = nums[i];
                if(sum>maxSum)
                    maxSum = sum;
            }
            else if(i>0 && nums[i]+sum<=sum && nums[i]<sum){
                sum = 0;
            }


        }

        return maxSum;
    }

    public static int maxSumOptimalSoln(int[] nums){
        int newsum=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            newsum=Math.max(newsum+nums[i],nums[i]);
            max= Math.max(max, newsum);
        }
        return max;
    }
    public static int maxSumOptimalDPSoln(int[] nums){
        int sum[] = new int[nums.length];
        int maxSum = 0;

        for(int i=0;i<nums.length;i++){

           sum[i]= Math.max(nums[i],nums[i]+(i>0?sum[i-1]:0));
           if(i==0)
               maxSum = sum[i];
            else if(maxSum<sum[i])
               maxSum = sum[i];
        }

        return maxSum;
    }
    public static void main(String[] args){
        int[] input = {-2,-3,-1};
        int max = maxSubArray(input);
        System.out.println(max);
        max = maxSumOptimalSoln(input);
        System.out.println(max);
    }
}
