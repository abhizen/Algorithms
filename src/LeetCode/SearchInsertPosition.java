/**
 * Created by abhinit on 12/9/15.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int index = 0;


       /* if((index = binarySearch(0,nums.length-1,nums,target))>=0)
            return index;*/
        index = binarySearch(0,nums.length-1,nums,target);

        if(index==-1){
            if(target<nums[0])
                return 0;
            else if(target>nums[nums.length-1])
                return nums.length;
        }

        return index;
    }

    private int binarySearch(int begin,int end,int[] nums,int elem){

        if(!(begin>=0 && begin<nums.length && end>=0 && end<nums.length))
            return -1;
        else if(begin>end)
            return ((begin+end)/2)+1;

        int median = (begin+end)/2;
        if(nums[median]==elem)
            return median;
        else if(elem<=nums[median])
            median = binarySearch(begin,median-1,nums,elem);
        else if(elem>nums[median])
            median=binarySearch(median+1,end,nums,elem);


        return median;
    }

    public static void main(String[] args){
        SearchInsertPosition instance= new SearchInsertPosition();
        int[] input = {-2,-5,-6,-10,-30};
        int index = instance.searchInsert(input,-10);
        System.out.println(index);
    }

}
