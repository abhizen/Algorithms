/**
 * Created by abhinit on 11/26/15.
 */
public class HouseRobber {

    public int rob(int[] nums) {

        if(nums==null)
            return 0;

        int sum = addHouse(0,-1,nums,0);
        return sum;
    }

    private int addHouse(int sum,int latestIndex,int[] nums,int index){
        int wiSum = 0;
        int woSum = 0;

        if(index>=nums.length)
            return sum;

        if(index==0){
            wiSum = addHouse(sum+nums[latestIndex+1],latestIndex+1,nums,index+1);
            woSum = addHouse(sum,latestIndex,nums,index+1);
        }
        else if((Math.abs(latestIndex-index))==1){
            wiSum = addHouse(sum,latestIndex,nums,index+1);
        }
        else if((Math.abs(latestIndex-index))>1){
            wiSum = addHouse(sum + nums[index],index,nums,index+1);
            woSum = addHouse(sum,latestIndex,nums,index+1);
        }

        if(wiSum>woSum)
            return wiSum;
        else
            return woSum;
    }

    private int addHouse(int[] nums){
        int[] sums = new int[nums.length];

        sums[0] =nums[0];
        sums[1] = nums[1];

        int sum1 = 0;
        int sum2 = 0;

        for(int i=2;i<nums.length;i++){
            sum1 = sums[i-2] + nums[i];
            if(i>=3)
                sum2 = sums[i-3] + nums[i];

            if(sum1>sum2)
                sums[i] = sum1;
            else
                sums[i] = sum2;
        }

        if(sums[nums.length-1]>sums[nums.length-2])
            return sums[nums.length-1];
        else
            return sums[nums.length-2];
    }
    public static void main(String[] args){
        int[] nums = {2,1,1,2};

        HouseRobber instance = new HouseRobber();
        int sum = instance.rob(nums);
        System.out.println(sum);
        sum = instance.addHouse(nums);
        System.out.println(sum);
    }
}
