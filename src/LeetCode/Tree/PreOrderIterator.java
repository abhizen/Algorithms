package Tree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by abhinit on 12/18/15.
 */
public class PreOrderIterator implements Iterator{
    private TreeNode current = null;
    private Stack<TreeNode> stack = null;

    PreOrderIterator(TreeNode root){
        this.stack = new Stack<>();
        this.current = root;
    }

    private TreeNode traverse(){
        TreeNode temp = null;

        while(this.current!=null || !this.stack.isEmpty()){

            if(current!=null){
                stack.push(current);
                temp = current;
                current = current.left;
                return temp;
            }
            else{
                temp = stack.pop();
                current = temp.right;
            }
        }

        return null;
    }

    @Override
    public boolean hasNext() {

        if(this.current!=null || !this.stack.isEmpty())
            return true;

        return false;
    }

    @Override
    public Object next() {
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
        PreOrderIterator instance = new PreOrderIterator(root);
        Integer elem = 0;


        while (instance.hasNext()){
            elem = (Integer)instance.next();
            System.out.println(elem+" ");
        }
    }
}
