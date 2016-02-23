/**
 * Created by abhinit on 12/9/15.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if(nums==null || (nums!=null && nums.length==1))
            return;

        int pivotIndex = (int)Math.ceil((double)nums.length/2);
        int pivot = nums[pivotIndex];

        nums[pivotIndex] = nums[0];
        nums[0] = pivot;
        int low = 1;
        int high = nums.length -1;
        int temp = 0;

        int index=2;
        while(index<=nums.length-1){

            if(nums[index]<pivot){
                temp = nums[index];
                nums[index] = nums[low];
                nums[low] = temp;
                low++;
                index++;
            }
            else if(nums[index]>pivot){
                temp = nums[index];
                nums[index] = nums[high];
                nums[high] = temp;
                high--;

            }
            else  if(nums[index]==pivot){
                index++;
            }

        }

        nums[0] = nums[low-1];
        nums[low-1] = pivot;

    }
}
