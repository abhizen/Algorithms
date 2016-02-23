package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by abhinit on 12/7/15.
 */
public class ZigZagIterator {
    public static void traverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        int orderFlag = 0;

        if(root.left==null && root.right==null){
            System.out.println(root.val);
            return;
        }

        queue.add(root);
        TreeNode node  = null;

        int len = 0;

        while (!queue.isEmpty()){


            while (!queue.isEmpty()){
                node = queue.remove();
                list.add(node);
            }

            len = list.size();
            if(orderFlag==0) {
                for (int i =0;i<len;i++){
                    System.out.print(list.get(i).val + " ");
                }
                System.out.println(" ");
                orderFlag = 1;
            }
            else{

                for (int i =len-1;i>=0;i--){
                    System.out.print(list.get(i).val + " ");
                }
                System.out.println(" ");
                orderFlag = 0;
            }

            int i = 0;
            while (!list.isEmpty()){
                node = list.remove(i);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);

            }

        }

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

        traverse(root);

    }
}

















