package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by abhinit on 12/12/15.
 */
public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList();
        TreeNode node = null;
        Queue<TreeNode> tempQueue = new LinkedList<>();
        TreeNode rightMostNode = null;
        List<Integer> outputList = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            while(!(queue.isEmpty())) {
                node = queue.remove();
                tempQueue.add(node);
            }

            while (!tempQueue.isEmpty()) {
                rightMostNode = node;
                node = tempQueue.remove();

                if (node!=null && node.left != null)
                    queue.add(node.left);
                if (node!=null && node.right != null)
                    queue.add(node.right);
            }

            if(node!=null)
                outputList.add(node.val);
        }

        return outputList;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        TreeNode temp = root.left;
        temp.left = new TreeNode(8);
        temp.left.left = new TreeNode(7);
        temp.left.right = new TreeNode(8);

        List<Integer> list = rightSideView(root);

        for(Integer elem : list){
            System.out.println(elem+" ");
        }
    }
}
