/**
 * Created by abhinit on 1/16/16.
 */
public class MaximumSubArray {
    public static int maxProfit(int[] pricediff) {

        int i=0;
        int j=0;
        int sum = 0;
        int max = sum;
        int result = max;

        while(j<pricediff.length && i<=j){

            max = sum;
            i = j;
            while(sum>=0 && j<pricediff.length){

                sum = sum + pricediff[j];

                if(max<sum)
                    max =  sum;
                result = Math.max(max,result);
                j++;
            }

            j--;
            while(sum<=max && i<=j && j<pricediff.length){
                System.out.println("i "+pricediff[i]);
                sum =sum-pricediff[i];

                if(max<sum)
                    max =  sum;
                result = Math.max(max,result);
                i++;
            }

            j++;
        }

        return result;
    }
    //New solution, have to test
    private static int getMaxArray(int[] nums){
        int i=0;
        int j=0;
        int sum = 0;
        int max = 0;

        while(j<nums.length){

            while(j<nums.length && sum+nums[j]>=0){
                sum = sum + nums[j];
                max = Math.max(max,sum);
                j++;
            }

            while(j<nums.length && i<j){
                sum = sum - nums[i];
                max = Math.max(max,sum);
                i++;
            }
            j++;

        }

        return max;

    }

    public static void main(String[] args){
        int[] num = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int result = maxProfit(num);

        System.out.println(result);
    }
}
