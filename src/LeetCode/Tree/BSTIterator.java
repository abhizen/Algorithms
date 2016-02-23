package Tree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by abhinit on 12/17/15.
 */
public class BSTIterator implements Iterator<Integer>{
private TreeNode current = null;
    private TreeNode root = null;
    private Stack<TreeNode> stack = null;


    public BSTIterator(TreeNode root){
        this.root = root;
        this.stack = new Stack<>();
        this.current = root;
        //this.current = traverse();
        //this.stack.push(current);
        //
    }

    private TreeNode traverse(){
        //TreeNode current = node;
        TreeNode temp = null;

        while (current!=null || !stack.isEmpty()){

            if(current!=null){
                stack.push(current);
                current = current.left;
            }
            else if(current==null){

                temp = stack.pop();
                current = temp.right;
                return temp;
            }

        }

        return null;
    }

    @Override
    public boolean hasNext() {


        if(current!=null || !stack.isEmpty())
            return true;

        return false;
    }

    @Override
    public Integer next() {
        TreeNode node = traverse();


        return node!=null?node.val:null;
    }

    public static void main(String[] args){




        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        TreeNode temp = root.left;
        temp.left = new TreeNode(8);
        temp.left.left = new TreeNode(7);
        temp.left.right = new TreeNode(8);

        temp.right = new TreeNode(12);
        temp.right.left = new TreeNode(11);
        temp.right.right = new TreeNode(15);

        temp = root.right;
        temp.left = new TreeNode(29);
        temp.right = new TreeNode(31);

        //instance.traverse(root);
        BSTIterator instance = new BSTIterator(root);
        int elem = 0;


        while (instance.hasNext()){
            elem = instance.next();
            System.out.println(elem+" ");
        }
    }
}
