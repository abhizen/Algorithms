import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abhinit on 12/27/15.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> list = generateSet(candidates,target,target,null,0);

        return list;
    }

    private List<List<Integer>> generateSet(int[] candidates,int target,int remaining,List<Integer> tuple,int index){
        List<List<Integer>> result = new ArrayList();
        List<List<Integer>> tempResult = null;

        if(remaining==0){
            result = new ArrayList();
            result.add(tuple);
            return result;
        }
        else if(remaining<0){
            return null;
        }

        int sum  = 0;
        List<Integer> newTuple = null;


        for(int i=index;i<candidates.length;i++){

            if(tuple==null){
                newTuple = new ArrayList<Integer>();
            }
            else{
                newTuple = tuple;
            }

            if(candidates[i]<=target) {
                newTuple.add(candidates[i]);
                tempResult = generateSet(candidates, target, remaining - candidates[i], newTuple, i);

                if (tempResult != null) {

                    for (List<Integer> tempTuple : tempResult) {
                        List<Integer> resultTuple = getCopy(tempTuple);
                        result.add(resultTuple);
                    }
                }

                newTuple.remove(newTuple.size() - 1);
            }
        }

        return result;
    }
    private List<Integer> getCopy(List<Integer> tuple){
        List<Integer> newTuple = null;

        newTuple = new ArrayList<Integer>();
        for(Integer elem : tuple){
            newTuple.add(elem);
        }

        return newTuple;
    }

    public static void main(String[] args){
        CombinationSum instance = new CombinationSum();
        int[] nums = {1,2,3};

        List<List<Integer>> list = instance.combinationSum(nums,6);

        for(List<Integer> tuple: list){
            for(Integer elem : tuple){
                System.out.print(elem+" ");
            }
            System.out.println(" ");
        }
    }
}
