import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by abhinit on 1/3/16.
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSumIIRecursive(int[] candidates, int target) {
        Arrays.sort(candidates);


        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> result = combinationRecurse(candidates,0,list,target);
        HashSet<List<Integer>> set = new HashSet<List<Integer>>(result);

        result.clear();
        result.addAll(set);
        return result;
    }
    private List<List<Integer>> combinationRecurse(int[] candidates,int index,List<Integer> list,int target){
        List<List<Integer>> candidateList = new ArrayList<List<Integer>>();
        List<List<Integer>> tempList = null;

        if(getSum(list)==target) {
            candidateList.add(list);
            return candidateList;
        }

        if(index==candidates.length) {
            return candidateList;
        }

        for(int i=index;i<candidates.length;i++){

            if(candidates[i]<=target) {
                list.add(candidates[i]);
                tempList = combinationRecurse(candidates, i + 1, list, target);

                for (List<Integer> tuple : tempList) {
                    candidateList.add(getTupleCopy(tuple));
                }
                list.remove(list.size() - 1);
            }
        }

        return candidateList;
    }
    private List<Integer> getTupleCopy(List<Integer> tuple){
        List<Integer> copy = new ArrayList<Integer>();

        for(Integer elem : tuple){
            copy.add(elem);
        }

        return copy;
    }
    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = null;
        List<List<Integer>> tempResult = null;
        List<Integer> temp = null;
        int elem = 0;

        for(int i=0;i<candidates.length;i++){


            if(result!=null)
                tempResult = getCopy(result);

            elem = candidates[i];

            /*if(i>0 && candidates[i]==candidates[i-1])
                continue;*/

            if(result==null || result.isEmpty()){
                if(tempResult==null)
                    tempResult = new ArrayList<List<Integer>>();
                temp = new ArrayList<Integer>();
                temp.add(elem);
                tempResult.add(temp);
            }
            else {
                for (List<Integer> tuple : result) {
                    //check the sum of tuple
                    if (getSum(tuple) + elem <= target) {
                        tuple.add(elem);
                        tempResult.add(tuple);
                    }
                }
                if(i>0 && candidates[i]!=candidates[i-1]) {
                    temp = new ArrayList<Integer>();
                    temp.add(elem);
                    tempResult.add(temp);
                }
            }

            result = getCopy(tempResult);
        }

        tempResult = new ArrayList<List<Integer>>();
        for(List<Integer> tuple : result){
            //check the sum of tuple
            if(getSum(tuple)==target){
                tempResult.add(tuple);
            }
        }

        HashSet<List<Integer>> set = new HashSet<List<Integer>>(tempResult);

        result.clear();
        result.addAll(set);

        return result;
    }

    private int getSum(List<Integer> tuple){
        int sum = 0;


        for(Integer elem : tuple){
            sum = sum+elem;
        }

        return sum;
    }
    private List<List<Integer>> getCopy(List<List<Integer>> list){
        List<List<Integer>> copy = new ArrayList();
        List<Integer> temp = null;

        for(List<Integer> tuple : list){
            temp = new ArrayList();
            for(Integer elem : tuple){
                temp.add(elem);
            }
            copy.add(temp);
        }

        return copy;
    }

    public static void main(String[] args){
        int[] candidates = {1,2,2,2,2,3,4,4,4,6,8,8,8,10};



        CombinationSumII instance =new CombinationSumII();
        //List<List<Integer>> list = instance.combinationSumII(candidates,28);
        List<List<Integer>> list = instance.combinationSumIIRecursive(candidates,10);

        for(List<Integer> tuple : list){
            for(Integer elem : tuple){
                System.out.print(elem + " ");
            }
            System.out.println("");
        }
    }
}
