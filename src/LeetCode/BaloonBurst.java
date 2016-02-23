import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 12/5/15.
 */
public class BaloonBurst {

    public static int maxCoins(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int elem : nums){
            list.add(elem);
        }

        int result = getMaxSumNew(list,0);

        return result;
    }

    private static int getMaxSumNew(List nums,int sum){

        if(nums==null)
            return 0;

        if(nums.size()==1)
            return sum + (Integer)nums.get(0);

        List<Integer> firstList = null;
        int sum1 = 0;
        int finalSum = 0;

        for(int i=0;i<nums.size();i++){
            firstList = getCopy(nums);
            firstList.remove(i);

            if(nums.size()>(i+1)) {
                if(i>0)
                    sum1 = getMaxSumNew(firstList, ((int) nums.get(i-1)*(int) nums.get(i) * (int) nums.get(i + 1)));
                else
                    sum1 = getMaxSumNew(firstList, ((int) nums.get(i) * (int) nums.get(i + 1)));
            }
            else{
                if(i>0)
                    sum1  = getMaxSumNew(firstList, ((int) nums.get(i-1)*(int) nums.get(i)));
                else
                    sum1  = getMaxSumNew(firstList, ((int) nums.get(i-1)*(int) nums.get(i)));
            }

            if(finalSum==0)
                finalSum = sum1;
            else if(finalSum<=sum1){
                finalSum = sum1;
            }

        }

        return finalSum+sum;
    }

    private static List<Integer> getCopy(List<Integer> list){
        ArrayList<Integer> copyList = new ArrayList<>();

        for(Integer elem : list){
            copyList.add(elem);
        }

        return copyList;
    }

    public static void main(String[] args){
        int[] nums = {3,1,5,8};

        int result = maxCoins(nums);
        System.out.println(result);
    }
}
