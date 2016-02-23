package Tree;

/**
 * Created by abhinit on 1/20/16.
 */
public class TreeDepth {
    public static int getDepth(TreeNode node,int height){


        if(node==null){
            return height;
        }
        int heightL = getDepth(node.left,height+1);

        int heightR = getDepth(node.right,height+1);

        return Math.max(heightL,heightR);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        int height = getDepth(root,0);
        System.out.println(height);
    }
}
