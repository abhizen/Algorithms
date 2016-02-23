package Tree;

/**
 * Created by abhinit on 12/11/15.
 */
public class FlattenBinaryTree {
    public static void flatten(TreeNode root) {
        traverse(root);
        changeToRight(root);
    }

    private static void traverse(TreeNode node){
        TreeNode tempNode = null;

        if(node==null)
            return;

        traverse(node.left);

        traverse(node.right);

        if(node.left!=null && node.right!=null){
            tempNode = node.left;

            while (tempNode.left!=null){
                tempNode = tempNode.left;
            }

            tempNode.left = node.right;
            node.right = null;
        }
        else if(node.left==null && node.right!=null){
            node.left = node.right;
            node.right = null;
        }

    }

    private static void changeToRight(TreeNode node){
        TreeNode temp = null;

        if(node==null)
            return;

        changeToRight(node.left);

        node.right = node.left;
        node.left = null;
    }

    public static void main(String[] args){
       /* TreeNode root = new TreeNode(20);
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
        temp.right = new TreeNode(31);*/
        TreeNode root = new TreeNode(1);
        root.right= new TreeNode(2);
        flatten(root);

        System.out.println("hello");
    }
}
