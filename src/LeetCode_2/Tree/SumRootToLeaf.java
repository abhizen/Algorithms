package Tree;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 12/26/15.
 */
public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {

        if(root==null)
            return 0;

        List<List<Integer>> list = traverse(root);
        int sum = 0;
        int num = 0;
        int count = 0;


        for(List<Integer> tuple  : list){

            count = 0;
            for(Integer elem : tuple){
                num = num + elem*(int)Math.pow(10,count);
                count++;
            }
            sum = sum + num;
        }

        return sum;
    }

    private List<List<Integer>> traverse(TreeNode node){
        List<List<Integer>> list = null;

        if(node==null){
            list = new ArrayList();
            return list;
        }

        List<List<Integer>> listL = traverse(node.left);
        List<List<Integer>> listR = traverse(node.right);

        list = new ArrayList();

        if(listL!=null && !listL.isEmpty()){
            for(List<Integer> tuple : listL){
                tuple.add(node.val);
                list.add(tuple);
            }
        }


        if(listR!=null && !listR.isEmpty()){
            for(List<Integer> tuple : listR){
                tuple.add(node.val);
                list.add(tuple);
            }
        }

        if(listL.isEmpty() && listR.isEmpty()){
            List<Integer> tuple = new ArrayList<Integer>();
            tuple.add(node.val);
            list.add(tuple);
        }


        return list;
    }
    public static void main(String[] args){
        SumRootToLeaf instance = new SumRootToLeaf();
        TreeNode node = new TreeNode(9);
        System.out.println(node.val);

    }
}
class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }