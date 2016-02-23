/**
 * Created by abhinit on 1/16/16.
 */
public class Sort_Colors {

    /*
    Algorithm devides array into four zones:
        1. 0 to low : 0
        2. low to medium: 1
        3. medium to high : unknown
        4. high to array end : 2
        each time medium encounters 0 it is swapped with low and low is lowered
        each time medium encounters 2 it is swapped with high and high in brought up
        if it encounters 1 it is left in place.
    */
    public void sortColors(int[] nums) {

        if(nums==null || (nums!=null && nums.length==1))
            return;



        int low = 0;
        int high = nums.length -1;
        int temp = 0;

        int index=0;
        while(index<=high){

            if(nums[index]==0){
                temp = nums[index];
                nums[index] = nums[low];
                nums[low] = temp;
                low++;
                index++;
            }
            else if(nums[index]==2){
                temp = nums[index];
                nums[index] = nums[high];
                nums[high] = temp;
                high--;

            }
            else  if(nums[index]==1){
                index++;
            }

        }


    }

    public void sort4Colors(int[] nums){
        int low =0;
        int med1=low+1;
        int med2 = low+1;
        int index=0;
        int high = nums.length-1;
        int temp = 0;

        while (index<=high && med1<=med2 && med2<=high){
            if(nums[index]==0){
                temp = nums[index];
                nums[index] = nums[low];
                nums[low] = temp;
                low++;
                index++;
                med1++;
            }
            else if(nums[index]==1){
                temp = nums[index];
                nums[index] = nums[med2];
                nums[med2] = temp;
                index++;
                med2++;
            }
            else if(nums[index]==2){
                index++;
            }
            else if(nums[index]==3){
                temp = nums[index];
                nums[index] = nums[high];
                nums[high] = temp;
                index++;
                high--;
            }
        }
    }

    public static void main(String[] args){
        Sort_Colors instance = new Sort_Colors();
        int[] nums={1,0,2,0,0,1,1,2,2};
        instance.sortColors(nums);

        for(int i : nums){
         //   System.out.println(i);
        }

        int[] nums4={0,0,1,1,0,2,2,0}; //{1,0,2,0,0,1,1,2,2,3,3,3,3};
        instance.sort4Colors(nums4);

        for(int i : nums4){
            System.out.println(i);
        }
    }
}
