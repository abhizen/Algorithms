package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 12/29/15.
 */
public class UniqueBinarySearchTree {
    public List<List<Integer>> permutations = new ArrayList<List<Integer>>();

    public List<TreeNode> generateTrees(int n) {

        int[] nums = new int[n];

        for(int i=1;i<=n;i++){
            nums[i-1] = i;
        }
        List<Integer> tempTuple = new ArrayList<Integer>();

        getPermutations(nums,0,tempTuple);

        TreeNode node = null;
        TreeNode head = null;
        List<TreeNode> nodes = new ArrayList();

        for(List<Integer> tuple : permutations){
            node = null;
            head = null;

            if(tuple.size()==n) {
                for (Integer elem : tuple) {
                    //System.out.print(elem+" ");
                    if (head == null) {
                        head = new TreeNode(elem);
                        node = head;
                    } else {
                        node = getTree(node, elem);
                        if (elem <= node.val)
                            node.left = new TreeNode(elem);
                        else
                            node.right = new TreeNode(elem);
                    }
                }

                nodes.add(head);
            }
        }

        return nodes;
    }

    private void getPermutations(int[] nums,int index,List<Integer> tuple){

        if(index==nums.length) {
            permutations.add(getCopy(tuple));
            return;
        }

        for(int i =index;i<nums.length;i++){
            swap(nums,index,i);
            tuple.add(nums[index]);
            getPermutations(nums,index+1,tuple);
            tuple.remove(index);
            swap(nums,index,i);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private List<Integer> getCopy(List<Integer> tuple){
        List<Integer> tempTuple = new ArrayList<Integer>();


        for(Integer elem : tuple){
            tempTuple.add(elem);
        }

        return tempTuple;
    }

    private TreeNode getTree(TreeNode node,int n){
        TreeNode temp = null;

        if(n<=node.val){
            if(node.left==null)
                return node;
            else{
                temp = getTree(node.left,n);
                return temp;
            }
        }
        else{
            if(node.right==null)
                return node;
            else{
                temp = getTree(node.right,n);
                return temp;
            }
        }

}
    public static void main(String[] args) {
        UniqueBinarySearchTree instance = new UniqueBinarySearchTree();
        List<TreeNode> list = instance.generateTrees(3);
    }
}
