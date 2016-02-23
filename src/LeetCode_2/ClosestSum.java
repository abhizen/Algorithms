import java.util.Arrays;

/**
 * Created by abhinit on 12/31/15.
 */
public class ClosestSum {
    public int threeSumClosest(int[] nums, int target) {
        int j = 0;
        int k = 0;
        int sum = 0;
        int minDiff = -1;
        int closestSum = 0;
        int diff = 0;
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){

            if(i==0 || nums[i]!=nums[i-1]){
                j = i+1;
                k = nums.length-1;

                while(j<k){
                    sum = nums[i]+nums[j]+nums[k];

                    diff = Math.abs(sum-target);

                    if(i==0){
                        closestSum = sum;
                        minDiff = diff;
                    }
                    else{
                        minDiff = Math.min(diff,minDiff);
                        if(minDiff==diff)
                            closestSum = sum;
                    }


                    while(j<k && k>j){
                        sum = nums[i]+nums[j]+nums[k];

                        diff = Math.abs(sum-target);
                        minDiff = Math.min(diff,minDiff);
                        if(minDiff==diff)
                            closestSum = sum;

                        if(sum<=target){
                            j++;
                        }
                        else
                            k--;
                    }


                }

            }

        }
        return closestSum;
    }

    public static void main(String[] args){
        int[] nums = {1,2,4,8,16,32,64,128};
        int target = 82;
        ClosestSum instance = new ClosestSum();
       int result = instance.threeSumClosest(nums,target);
        System.out.println(result);
    }
}
