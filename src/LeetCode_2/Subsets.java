import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by abhinit on 12/27/15.
 */
public class Subsets {
    List<List<Integer>> list = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {

        generateSet(nums,0);
        list.add(new ArrayList<Integer>());
        return this.list;
    }

    private void generateSet(int[] nums,int index){

        List<List<Integer>> tempList  = new ArrayList();
        List<List<Integer>> newTempList  = null;

        for(int i=index;i<nums.length;i++){
            //generateSet(nums,i+1);

            newTempList = getCopy(tempList);


            for (List<Integer> tuple : tempList) {
                tuple.add(nums[i]);
                Collections.sort(tuple);
                newTempList.add(tuple);
            }
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[i]);
            ((ArrayList<List<Integer>>) newTempList).add(temp);


            tempList = getCopy(newTempList);
        }

        for(List<Integer> tuple : tempList){
            list.add(tuple);
        }
    }

    private List<List<Integer>> getCopy(List<List<Integer>> list){
        List<List<Integer>> temp = new ArrayList<List<Integer>>();
        List<Integer> newTuple = null;

        for(List<Integer> tuple : list){
            newTuple = new ArrayList<Integer>();
            for(Integer elem : tuple){
                newTuple.add(elem);
            }

            temp.add(newTuple);
        }

        return temp;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<List<Integer>> newResult = null;
        List<Integer> tuple = null;

        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());

        for(int elem  : nums){

            newResult = getCopy(result);

            for(List<Integer> newTuple : result){
                newTuple.add(elem);

                //Collections.sort(newTuple);
                if(!checkDuplicate(newResult,newTuple)){

                    newResult.add(newTuple);
                }
            }
            tuple = new ArrayList<Integer>();
            tuple.add(elem);
            if(!checkDuplicate(newResult,tuple)) {
                newResult.add(tuple);
            }

            result = getCopy(newResult);
        }

        return result;
    }

    private boolean checkDuplicate( List<List<Integer>> result, List<Integer> tempTuple){
        int count = 0;
        int i = 0;

        for(List<Integer> tuple : result ){

            i=0;
            count = 0;
            if(tempTuple.size()==tuple.size()) {
                for (Integer elem : tuple) {
                    if (elem == tempTuple.get(i))
                        count++;
                    i++;
                }
            }

            if(count==tempTuple.size())
                return true;

        }

            return false;
    }

    public static void main(String[] args){
        Subsets instance = new Subsets();
        int[] nums = {1,1,2};
        List<List<Integer>> list = instance.subsetsWithDup(nums);

        for(List<Integer> tuple : list){
            for(Integer elem : tuple){
                System.out.print(elem + " ");
            }
            System.out.println(" ");
        }
    }
}
