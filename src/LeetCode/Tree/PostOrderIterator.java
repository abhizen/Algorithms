package Tree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by abhinit on 12/18/15.
 */
public class PostOrderIterator implements Iterator{
private TreeNode current = null;
    private Stack<TreeNode> stack = null;
    private Stack<TreeNode> parentStack = null;
    private int parentFlag = 0;

    public PostOrderIterator(TreeNode root){
        current = root;
        stack = new Stack<>();
        parentStack = new Stack<>();
    }

    public boolean hasNext(){
     return false;
    }

    public Object next(){
        return null;
    }


    private TreeNode traverse(){
        TreeNode temp = null;

        while(this.current!=null || !this.stack.isEmpty()){

            if(current!=null){
                stack.push(current);
                temp = current;
                current = current.left;
            }
            else{



                temp = stack.pop();

                if(temp.right!=null) {
                    current = temp.right;
                    stack.push(temp);
                    stack.push(temp.right);
                }
                else {
                    return temp;
                }
            }
        }

        return null;
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
        PostOrderIterator instance = new PostOrderIterator(root);
        Integer elem = 0;


        while (instance.hasNext()){
            elem = (Integer)instance.next();
            System.out.println(elem+" ");
        }
    }
}
