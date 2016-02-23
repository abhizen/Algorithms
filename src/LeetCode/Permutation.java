import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by abhinit on 12/5/15.
 */
public class Permutation {

        public static List<List<Integer>> permute(int[] nums) {
            List<Integer> input = new ArrayList();
            List<List<Integer>> outputList = null;
            HashMap<Integer,Integer> countMap = new HashMap();
            int count = 0;

            for(int num : nums){
                if(countMap.get(num)==null){
                    countMap.put(num,1);
                }
                else{
                    count =countMap.get(num);
                    countMap.put(num,count+1);
                }

                //input.add(num);
            }

            outputList = generate(input,countMap,nums.length,nums);
            return outputList;
        }

        private static List<List<Integer>> generate(List<Integer> input,HashMap<Integer,Integer> countMap,int maxSize,int[] nums){
            int length = input.size();
            List<Integer> output = null;
            List<List<Integer>> outputList = null;
            List<List<Integer>> resultList = null;
            ArrayList<Integer> newInput = null;
            int count = 0;
            HashMap<Integer,Integer> map = (HashMap<Integer,Integer>)countMap.clone();

            if(input.size()==maxSize){
                resultList = new ArrayList();
                resultList.add(input);
                return resultList;
            }

            for(int num : nums){
                if(map.get(num)>0){
                    count = map.get(num);
                    HashMap<Integer,Integer> newMap = (HashMap<Integer,Integer>)map.clone();
                    newMap.put(num,count-1);

                    newInput = new ArrayList<>();
                    for(Integer elem : input){
                        newInput.add(elem);
                    }

                    newInput.add(num);

                    resultList = generate(newInput,newMap,maxSize,nums);
                    if(outputList==null){
                        outputList = new ArrayList();
                        for(List<Integer> tuple : resultList){
                            outputList.add(tuple);
                        }
                    }
                    else{
                        for(List<Integer> tuple : resultList){
                            outputList.add(tuple);
                        }
                    }
                }
            }

            return outputList;
        }

    public static void main(String[] args){

        int[] input = {2,3,4,2};
        List<List<Integer>> list = permute(input);

        for(List<Integer> tuple : list){
            for(Integer elem : tuple){
                System.out.print(elem + " ");
            }
            System.out.println(" ");
        }
    }
}
