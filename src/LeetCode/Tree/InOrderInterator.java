package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by abhinit on 12/14/15.
 */
public class InOrderInterator {
    private TreeNode current = null;
    private TreeNode child = null;
    private List<Integer> children = null;

    public List<Integer> getChildren() {
        return children;
    }


    public void traverse(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        children = new ArrayList<>();

        if(root==null)
            return;

        current = root;

        while(current!=null || !stack.isEmpty()){
            if(current!=null){
                stack.push(current);
                current = current.left;
            }
            else{

                if(!stack.isEmpty()) {
                    children.add(stack.peek().val);
                    current = stack.pop().right;
                }
            }
        }

    }
    public void newTraverse(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = null;
        children = new ArrayList<>();

        if(root==null)
            return;

        current = root;

        while(current!=null || !stack.isEmpty()){
            if(current!=null){
                stack.push(current);
                current = current.left;
            }
            else{
                    node = stack.pop();
                    children.add(node.val);
                    current = node.right;
            }
        }

    }

    public static void main(String[] args){


        InOrderInterator instance = new InOrderInterator();

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
        instance.newTraverse(root);
        List<Integer> children = instance.getChildren();

        for(Integer elem : children){
            System.out.println(elem+" ");
        }
    }
}
