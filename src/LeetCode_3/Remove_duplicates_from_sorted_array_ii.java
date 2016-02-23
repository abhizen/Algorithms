/**
 * Created by abhinit on 1/17/16.
 */
public class Remove_duplicates_from_sorted_array_ii {

    //my solution
    public int removeDuplicates(int[] nums) {
        int i=0,j=0,k=0;
        int m = 0;
        int diffCount = 0;

        if(nums==null || nums.length==0)
            return 0;

        if(nums.length==1)
            return 1;

        while(i<nums.length && k<nums.length){

            for(;k<nums.length && nums[i]==nums[k];k++);

            if(k-i>=2){
                //i=i+2;
                diffCount = diffCount+2;
            }
            else{
                //i=k;
                diffCount++;
            }
            i =k;
        }


        i=0;
        j=0;
        k=0;
        /*Incorrect solution as I am increasing number of copies of a number
        * Instead of copying same number multiple times, move k and copy after j-i>1>*/
        while(i<nums.length && k<nums.length){
            j=i;
            for(;k<nums.length && nums[i]==nums[k];k++);

            while(j<k && k<nums.length){
                if(j-i>1){
                    nums[j] = nums[k];

                }
                j++;
            }

            if(k-i>1){
                i=i+2;
            }
            else
                i++;
        }

        return diffCount;
    }

    public int removeDuplicates_new(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0;
        int k = 2;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {

            if (nums[j] == nums[i]) {
                count++;
                if (count == k - 1) {
                /*This part takes care when 1st elemnet was copied and
                  & next elemtent is same as previous elemt before copying*/
                    i++;
                    nums[i] = nums[j];
                }
            } else {
                /*This part copies differenct element to part where j-i>1 && nums[i] !=nums[j]*/
                i++;
                nums[i] = nums[j];
                count = 0; //reset count
            }
        }
        return i + 1;
    }

    public static void main(String[] args){
        Remove_duplicates_from_sorted_array_ii instance = new Remove_duplicates_from_sorted_array_ii();
        int[] nums = {1,1,2,2,3};
                //{1,1,1,1,1,1,2,3};
        int result = instance.removeDuplicates_new(nums);
        System.out.println("result: "+result);
        for(int elem : nums)
            System.out.println(elem+" ");

    }
}
