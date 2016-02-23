import java.util.Arrays;

/**
 * Created by abhinit on 12/19/15.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int j = 0;
        int k = 0;
        int sum = 0;
        int minDiff = -1;
        int closestSum = 0;
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {
                j = i + 1;
                k = nums.length - 1;

                while (j < k) {
                    sum = nums[i] + nums[j] + nums[k];

                    if (i == 0) {
                        closestSum = sum;
                        minDiff = Math.abs(sum - target);
                    } else if (minDiff > Math.abs(sum - target)) {
                        closestSum = sum;
                        minDiff = Math.abs(sum - target);
                    }


                    if (sum == target) {
                        return sum;
                    } else if (sum < target) {
                        j++;
                    } else if (sum > target) {
                        k--;
                    }

                    while (j < k && j > 1 && j < nums.length && k >= 0 && k < nums.length - 1 && (nums[j] == nums[j - 1])) {
                        j++;
                    }

                    while (j < k && j >= 0 && j < nums.length && k >= 0 && k < nums.length - 1 && (nums[k] == nums[k + 1])) {
                        k--;
                    }

                }

            }
        }


        return closestSum;
    }

    public static void main(String[] args){
        ThreeSumClosest instance = new ThreeSumClosest();
        int[] nums = {87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,
                -17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4};

        int sum = instance.threeSumClosest(nums,-275);
        System.out.println("Sum "+sum);
    }
}
