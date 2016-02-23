import java.util.*;

/**
 * Created by abhinit on 11/27/15.
 */
public class SummarRanges {
    public List<String> summaryRanges(int[] nums) {
        Map<String,String> map = new java.util.LinkedHashMap<>();
        int key = 0;

        if(nums==null)
            return null;
        else if(nums.length==1){
            ArrayList<String> list = new ArrayList();
            list.add(Integer.toString(nums[0]));
            return list;
        }

        for(int i=0;i<nums.length;i++){

            if(i==0){
                map.put(Integer.toString(nums[i]),Integer.toString(nums[i]));
                key = nums[i];
            }
            else if((nums[i]-nums[i-1])==1)
                map.put(Integer.toString(key),Integer.toString(nums[i]));
            else{
                key = nums[i];
                map.put(Integer.toString(key),Integer.toString(nums[i]));
            }
        }

        int value = 0;
        String entry = null;
        List<String> list = new ArrayList();
        for(String elem: map.keySet()){
            if(!elem.equals(map.get(elem))){
                entry = elem+"->"+map.get(elem);
            }
            else
                entry = elem;

            list.add(entry);
        }

        return list;

    }
}
