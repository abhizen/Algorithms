import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by abhinit on 12/18/15.
 */
public class Sumof3Nums {

    public List<List<Integer>> threeSum(int[] nums) {
        int i=0;
        int j=0;
        int k = 0;
        int sum = 0;
        List<List<Integer>> list = new ArrayList();
        List<Integer> tuple = null;
        HashMap<String,Boolean> map = new HashMap<String, Boolean>();
        StringBuilder key = null;

        Arrays.sort(nums);

        for(i=0;i<nums.length-2;i++){

            if(i==0 || nums[i]>nums[i-1]) {

                sum = 0 - nums[i];

                j = i + 1;
                k = nums.length - 1;

                while (j < k) {

                    if ((nums[i] + nums[j] + nums[k]) == 0) {

                        tuple = new ArrayList();
                        tuple.add(nums[i]);
                        tuple.add(nums[j]);
                        tuple.add(nums[k]);

                        j++;
                        k--;
                        list.add(tuple);
/*
                    key = new StringBuilder();
                    key = key.append(nums[i]).append(",");
                    key = key.append(nums[j]).append(",");
                    key = key.append(nums[k]).append("");


                    if(map.get(key.toString())==null) {
                        map.put(key.toString(), true);
                        list.add(tuple);
                    }*/

                        while (j > 0 && j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }


                        while (k < nums.length - 1 && j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }


                    } else if ((nums[i] + nums[j] + nums[k]) > 0)
                        k--;
                    else if ((nums[i] + nums[j] + nums[k]) < 0)
                        j++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args){
        Sumof3Nums instance = new Sumof3Nums();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list= instance.threeSum(nums);

        for(List<Integer> tuple : list){

            for(Integer elem : tuple){
                System.out.print(elem+" ");
            }
            System.out.println(" ");
        }
    }
}
