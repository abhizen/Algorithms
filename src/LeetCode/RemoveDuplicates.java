/**
 * Created by abhinit on 11/26/15.
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int i = 1;

        if(nums==null)
            return 0;
        if(nums.length==1)
            return 1;

        int length = nums.length;
        int elem = 0;
        int count = 1;

        for(int j=1;j<length;j++){
            if(nums[j-1]!=nums[j])
                count++;
        }

        while(i<count){

            while(i<length && nums[i]!=nums[i-1])
                i++;

            if(i<length){
                elem = nums[i];

                for(int j=i+1;j<=length-1;j++){
                    nums[j-1] = nums[j];
                }

                nums[length-1] = elem;
            }

            for(int e : nums) {
                System.out.print(e);
            }
            System.out.println("\n");

        }


        return count;
    }

    public static int removeDuplicatesOpt(int[] nums) {
        int i = 0;

        if(nums==null)
            return 0;
        if(nums.length==1)
            return 1;

        int length = nums.length;
        int elem = 0;
        int count = 1;
        int k = 0;

        for(int j=1;j<length;j++){
            if(nums[j-1]!=nums[j])
                count++;
        }

        k = i+1;
        while(i<count-1){

            while (k<length && nums[i]==nums[k])
                k++;

            if(k<length) {
                nums[i+1] = nums[k];
                i++;
            }
            else
                break;

            for(int e : nums) {
                System.out.print(e);
            }
            System.out.println("\n");
        }



        return count;
    }

    public static void main(String[] args){
        int[] input = {0,0,0,0,0,1,2,2,3,3,4,4};
        int count = RemoveDuplicates.removeDuplicatesOpt(input);
        System.out.println(count);
    }
}
