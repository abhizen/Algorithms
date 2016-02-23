import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 12/24/15.
 */
public class CombinationSumIII {
    List<List<Integer>> list = new ArrayList();

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<Integer> newTuple = new ArrayList();
        getSum(k,n,0,0,0,newTuple);

        return list;
    }

    private void getSum(int k,int n,int sum,int index,int level,List<Integer> tuple){

        if(sum==n && level==3){
            list.add(tuple);
            return;
        }
        else if(level>=3){
            return;
        }

        List<Integer> newTuple = null;

        for(int i=index+1;i<=9;i++){
            newTuple = (List<Integer>)((ArrayList)tuple).clone();
            newTuple.add(i);
            getSum(k,n,sum+i,i,level+1,newTuple);
        }
    }

    public static void main(String[] args){
        CombinationSumIII instance =new CombinationSumIII();
        List<List<Integer>> list = instance.combinationSum3(3,7);

        for(List<Integer> tuple : list){
            for(Integer elem : tuple){
                System.out.print(elem + " ");
            }
            System.out.println(" ");
        }

    }
}
