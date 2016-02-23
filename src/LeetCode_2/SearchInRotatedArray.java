/**
 * Created by abhinit on 12/26/15.
 */
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int pivot = -1;


        if(nums==null || nums.length==0)
            return pivot;

        int elem = binarySearch(nums,0,nums.length-1,target);
        return elem;

    }

    private int binarySearch(int[] nums,int begin,int end,int elem){


        if(begin>end)
            return -1;

        int mid = (begin+end)/2;

        if(nums[mid]==elem)
            return mid;

        if(nums[begin]<nums[mid]){

            if(elem<nums[mid]){ //This is suitable for binary search
                return binarySearch(nums,begin,mid-1,elem);
            }
            else{
                return binarySearch(nums,mid+1,end,elem);
            }
        }
        else{
            if(elem>nums[mid]){  //This is suitable for binary search
                return binarySearch(nums,mid+1,end,elem);
            }
            else{
                return binarySearch(nums,begin,mid-1,elem);
            }
        }

    }
    public static void main(String[] args){
        SearchInRotatedArray instance = new SearchInRotatedArray();
        int nums[] = {3,1};
        int elem = 1;

        int index  = instance.search(nums,elem);
        System.out.println("Index"+index);
    }
}
