import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abhinit on 2/1/16.
 */
public class SumOf4 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list =new ArrayList();

        Arrays.sort(nums);

        int i=0,j=0,k=0,l=0;

        if(nums.length<4)
            return new ArrayList();

        int len = nums.length;
        int sum = 0;

        while(i<=len-4){
            sum = nums[i];


            if(i>0 && nums[i]==nums[i-1]) {
                i++;
                continue;
            }

            for(j=i+1;j<=len-3;j++){

                if(j>i+1 && nums[j]==nums[j-1])
                    continue;

                k=j+1;
                l=len-1;
                sum += nums[j];

                while(k<l){
                    if(sum+nums[k]+nums[l]==target){
                        List<Integer> tuple = new ArrayList();
                        tuple.add(nums[i]);
                        tuple.add(nums[j]);
                        tuple.add(nums[k]);
                        tuple.add(nums[l]);
                        list.add(tuple);
                        while(k<l &&nums[k]==nums[l])
                            k++;
                        k++;
                        while(l>k&&nums[l]==nums[l-1])
                            l--;

                        l--;
                    }
                    else if(sum+nums[k]+nums[l]<target){
                        k++;
                    }
                    else if(sum+nums[k]+nums[l]>target){
                        l--;
                    }
                }

                sum = sum-nums[j];
            }
            sum = sum-nums[i];
            i++;
        }

        return list;
    }

    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        int target = -1;
        List<List<Integer>> list = fourSum(nums,target);
    }
}
