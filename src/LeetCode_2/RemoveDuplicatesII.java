/**
 * Created by abhinit on 12/26/15.
 */
public class RemoveDuplicatesII {
    public static int removeDuplicates(int[] nums) {
    int i = 0;
    int j = 1;
    int count = 0;
    int temp = 0;
    int diffCount = 0;

    i=0;
    while(j<nums.length)
    {

        count = 1;
        while (j<nums.length && nums[i] == nums[j]) {
            count++;
            j++;
        }

        if (count == 1)
            diffCount++;
        else if (count > 1)
            diffCount = diffCount + 2;

        i = j;
        j++;

    }

   // diffCount++;

    i=0;
    j=1;

    while(i<diffCount)

    {

        count = 0;

        while (j<nums.length && nums[i] == nums[j]) {
            count++;
            j++;
        }

        if (j<nums.length && count > 1) {
            i = i + 2;
            nums[i] = nums[j];
            j = i + 1;
        } else {
            i++;
            j++;
        }

    }

    return diffCount;
}

    public static void main(String[] args){
        int[] nums = {1,1};
        int result = removeDuplicates(nums);
        System.out.println(result);
    }
}
