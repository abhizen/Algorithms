/**
 * Created by abhinit on 12/5/15.
 */
public class NextPermutation {

    public static void process(int[] nums){

        if(nums==null)
            return;

        int length = nums.length;
        int temp = 0;
        int p = 0;
        int q = 0;
        int min = 0;


        for(int i = 0;i<length-1;i++){
            if(nums[i]<nums[i+1]){
                p = i;
            }
        }


        for(int i = p+1;i<length;i++){

            if(min==0 && nums[p] <nums[i]){
                min = nums[i];
                q = i;
            }
            else if(nums[p]<nums[i]
                    && nums[i]<=min) {
                min = nums[i];
                q = i;
            }
        }

        int newLength = 0;
        int i = 0;
        if(p==0 && q==0) {

            p = -1;
            newLength = length;
        }
        else{
                temp = nums[p];
                nums[p] = nums[q];
                nums[q] = temp;
            newLength = length - p;
            }



        for(int j=p+1;j<=(newLength)/2;j++){
            temp = nums[j];
            nums[j] = nums[length-i-1];
            nums[length-i-1] = temp;
            i++;
        }

    }

    public static void main(String[] args){
        int[] num = {1,3,2,4};
        process(num);

        for(int elem : num){
            System.out.print(elem+" ");
        }
    }
}
