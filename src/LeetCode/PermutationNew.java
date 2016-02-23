import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 12/5/15.
 */
public class PermutationNew {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList();
        permute(num, 0, result);
        return result;
    }

    void permute(int[] num, int start, List<List<Integer>> result) {

        if (start >= num.length) {
            ArrayList<Integer> item = convertArrayToList(num);
            result.add(item);
        }

        for (int j = start; j <= num.length - 1; j++) {

            if(containsDuplicate(num,start,j)) {
                swap(num, start, j);
                //System.out.println("begin start: " + start + " "+"j"+" "+j+" "+ num[0] + " " + num[1] + " " + num[2]);
                permute(num, start + 1, result);
                swap(num, start, j);
            }
            //System.out.println("end   start: " + start + " "+"j"+" "+j+" "+ num[0] + " " + num[1] + " " + num[2]);
        }
    }

    private ArrayList<Integer> convertArrayToList(int[] num) {
        ArrayList<Integer> item = new ArrayList<Integer>();
        for (int h = 0; h < num.length; h++) {
            item.add(num[h]);
        }
        return item;
    }

    private boolean containsDuplicate(int[] arr, int start, int end) {
        for (int i = start; i <= end-1; i++) {
            if (arr[i] == arr[end]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args){
        int[] num = {1,2,3};
        PermutationNew instance = new PermutationNew();
        List<List<Integer>> list = instance.permute(num);

        for(List<Integer> tuple : list){
            for(Integer elem : tuple) {
                System.out.print(elem+" ");
            }
            System.out.println(" ");
        }
    }
}
