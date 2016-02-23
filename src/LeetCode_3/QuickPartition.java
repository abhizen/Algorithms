/**
 * Created by abhinit on 1/19/16.
 */
public class QuickPartition {
    public static void partition(int[] nums) {
        int i = 0, j = 1;
        int pivot = 0;
        int temp = 0;

        while (j < nums.length) {

            if (nums[j] < pivot && i < j - 1 && nums[i+1]<pivot) {
                i++;
            }
            else if (nums[j] < pivot &&  nums[i+1]>=pivot && i < nums.length - 1) {
                temp = nums[i + 1];
                nums[i + 1] = nums[j];
                nums[j] = temp;
                i++;
            }

            j++;
        }
    }

    public static void partitionByBook(int[] nums) {
        int i = -1, j = 1;
        int pivot = 0;
        int temp = 0;

        while(j<nums.length) {
            if(nums[j]<pivot) {
                i++;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            j++;
        }
    }
    public static int[] posiNegSort(int [] nums){
        int p = 0;
        int q = 0;
        while ( q < nums.length){
            while (nums[p] < 0)
                p++;
            q = p;
            while(q < nums.length && nums[q] > 0 )
                q++;
            if (q == nums.length)
                break;
            for(int i = q; i > p; i--){
                int t =nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = t;
            }
        }
        return nums;
    }
    public static void main(String[] args){
        int[] nums = {1,-2,-3,4,-5,6,-7,8,-9,10,-11,12,-13};//{-1};//{-1,2,3,-7,9,-5,-6};

        //partition(nums);
        //partitionByBook(nums);
        posiNegSort(nums);

        for(int elem : nums){
            System.out.print(elem+" ");
        }
    }
}
