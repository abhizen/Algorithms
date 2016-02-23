/**
 * Created by abhinit on 12/28/15.
 */
public class House_RobberII {
    public int rob(int[] nums,int flag) {

        if(nums==null || nums.length==0)
            return 0;
        int max = 0;

        if(nums.length<=2){
            for(int elem : nums){
                max = Math.max(elem,max);
            }

            return max;
        }

        int[] deposit = new int[nums.length];
        int[] begin = new int[nums.length];


        deposit[0] = nums[0];
        max = Math.max(deposit[0],max);

        deposit[1] = nums[1];
        max = Math.max(deposit[1],max);

        /*deposit[2] = nums[2];
        max = Math.max(deposit[2],max);*/

        begin[0] = 0;
        begin[1] = 1;
        /*begin[2] = 2;*/

        for(int i=2;i<nums.length;i++){

            //deposit[i] = Math.max(nums[i-2],nums[i-3]);

                if(i==3 && nums.length>3){
                    if(flag==1){
                        deposit[i] = deposit[i - 3];
                        begin[i] = begin[i - 3];
                    }
                    else {
                        deposit[i] = deposit[i - 2];
                        begin[i] = begin[i - 2];
                    }
                }
                else if(i==2 && nums.length>2){
                    if(flag==1){
                        deposit[i] = deposit[i - 2];
                        begin[i] = begin[i - 2];
                    }
                    else {
                        deposit[i] = 0;
                        begin[i] = i;
                    }
                }
                else if (i>2 && deposit[i - 2] > deposit[i - 3]) {
                    deposit[i] = deposit[i - 2];
                    begin[i] = begin[i - 2];
                } else if(i>2){
                    deposit[i] = deposit[i - 3];
                    begin[i] = begin[i - 3];
                }
                else if(i==2 && nums.length==3){
                    deposit[i] = 0;
                    begin[i] = i;
                }
                else if(i==2 && nums.length>3){
                    deposit[i] = deposit[i-2];
                    begin[i] = begin[i-2];
                }


                if ((i + 1) % nums.length < i && begin[i] == 0) {

                    if (begin[i - 2] != 0) {
                        begin[i] = begin[i - 2];
                        deposit[i] = deposit[i - 2];
                    } else if (i>2 && begin[i - 3] != 0) {
                        begin[i] = begin[i - 3];
                        deposit[i] = deposit[i - 3];
                    } else {
                        deposit[i] = 0;
                        begin[i] = i;
                    }
                }



            deposit[i] = deposit[i] + nums[i];
            max = Math.max(deposit[i],max);
        }

        return max;
    }


    public static void main(String[] args){
        House_RobberII instance = new House_RobberII();
        int[] nums = {6,6,4,8,4,3,3,10};
        int result1 = instance.rob(nums,1);
        int result2 = instance.rob(nums,0);
        System.out.println("Result "+Math.max(result2,result1));
    }
}
