/**
 * Created by abhinit on 1/20/16.
 */
public class ReservoirSamplingProblem {
    public static void selectKitems(int[] stream,int k){
        int count = 0;
        int rand = 0;
        int temp = 0;


        while((count+k)<stream.length){
            rand = (int)((count+k)*Math.random());
            temp = stream[rand];
            stream[rand] = stream[k+count];
            stream[k+count] = temp;
            count++;
        }

    }

    public static void main(String[] args){
        int[] nums = {2,3,6,1,7,8,19,20,31,43};
        selectKitems(nums,4);
        for(int elem : nums){
            System.out.println(elem);
        }
    }
}
