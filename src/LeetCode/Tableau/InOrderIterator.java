package Tableau;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by abhinit on 12/3/15.
 */
public class InOrderIterator {
private TreeNode root = null;

    public TreeNode populate(int[] input){
        TreeNode node = null;
        TreeNode newNode = null;

        for(int elem  : input){

            if(root==null) {
                root = new TreeNode(elem);
                node = root;
            }
            else{
                node = root;
                while (node!=null){
                    newNode = node;
                    if(node.val>elem)
                        node = node.left;
                    else
                        node = node.right;
                }

                if(newNode.val>elem)
                    newNode.left = new TreeNode(elem);
                else
                    newNode.right = new TreeNode(elem);



            }
        }


        return root;
    }


    public static void main(String[] args){

        int[] input = {5,4,1,8,6};

        InOrderIterator instance = new InOrderIterator();

        TreeNode root = instance.populate(input);

        TreeNodeIterator itr = new TreeNodeIterator(root);
        List<Integer> list = itr.traverse();
        if(list!=null){
            for(Integer elem : list)
                System.out.println(elem+" ");
        }
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class TreeNodeIterator implements Iterator<TreeNode>{
    private TreeNode root = null;
    private Stack<TreeNode> stack = new Stack<>();

    TreeNodeIterator(TreeNode root){
        this.root = root;
    }

    public List<Integer> traverse(){
        Stack<TreeNode> stack  = new Stack<>();
        TreeNode node = root;
        TreeNode current = root;
        List<Integer> list = new ArrayList<>();

        if(root==null)
            return null;

        while(current!=null){

            if(node!=null){
                current = node;
                stack.push(node);
                node = node.left;
            }
            else if(node==null){
                if(!stack.isEmpty()){
                    current = stack.pop();
                    list.add(current.val);
                    if(current.right!=null) {
                        node = current.right;
                    }
                }
                else
                    current = null;
            }
        }

        return list;
    }

    @Override
    public boolean hasNext() {

        return false;
    }

    @Override
    public TreeNode next() {
        return null;
    }
}