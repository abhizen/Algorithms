package Tree;

/**
 * Created by abhinit on 1/16/16.
 */
public class TreeFromInorderPreOrder {
    private int inFound = 0;
    private int itr = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder==null || inorder==null)
            return null;

        if(preorder.length==0 || inorder.length==0)
            return null;

        TreeNode root = traverse(preorder,0,inorder,0,inorder.length-1);

        return root;
    }

    private TreeNode traverse(int[] preorder, int itr,int[] inorder, int inStart,int inEnd){
        TreeNode root = null;
        int i = 0;

        if(itr>=inorder.length || inStart>inEnd)
            return null;

        if(inStart==inEnd){
            inFound = inStart;
            root = new TreeNode(inorder[inStart]);
            return root;
        }

        int elem = preorder[itr];

        for(i=inStart;i<=inEnd;i++){
            if(inorder[i]==elem){
                inFound = i;
                break;
            }
        }

        //itr++;
        TreeNode left = traverse(preorder,itr+1,inorder,inStart,inFound-1);

        //itr =itr + i-inFound;

        TreeNode right = traverse(preorder,itr + i-inStart+1,inorder,i+1,inEnd);

        root = new TreeNode(inorder[i]);

        root.left = left;

        root.right=right;

        return root;
    }
    public static void main(String[] args){
        int[] preorder= {3,2,1,4};
        int[] inorder = {1,2,3,4};
        TreeFromInorderPreOrder instance = new TreeFromInorderPreOrder();
        TreeNode root = instance.buildTree(preorder,inorder);
    }
}
class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
