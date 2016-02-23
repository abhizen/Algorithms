package Tree;

/**
 * Created by abhinit on 12/12/15.
 */
public class SortedArrayToBinaryTree {
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums==null)
            return null;
        else if(nums.length==0)
            return null;

        int medianIndex = nums.length/2;
        int median = nums[medianIndex];

        TreeNode root = null;

        for(int i=0;i<nums.length;i++){
            root = addNode(root,nums[i]);
        }


        return root;
    }

    private TreeNode addNode(TreeNode root,int num){

        if(root==null){
            root = new TreeNode(num);
            return root;
        }

        TreeNode parent = traverse(root,num);
        if(parent.val>num){
            parent.left = new TreeNode(num);
        }
        else
            parent.right = new TreeNode(num);

        return root;
    }

    private TreeNode traverse(TreeNode node,int num){
        TreeNode parent  = null;

        if(node==null){
            return null;
        }

        if(num>node.val){
            parent = traverse(node.right,num);
        }
        else{
            parent = traverse(node.left,num);
        }

        if(parent==null)
            return node;
        else
            return parent;
    }

    private TreeNode sortedArrayToBST(int[] nums,int start,int end){

        if(start>end)
            return null;

        int mid = (start+end)/2;
        TreeNode root = new TreeNode(mid);
        root.left = sortedArrayToBST(nums,start,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,end);

        return root;
    }
    public TreeNode createTree(int[] nums){
        int len = nums.length;

        TreeNode root = sortedArrayToBST(nums,0,len-1);
        return root;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,7,8};
        SortedArrayToBinaryTree instance = new SortedArrayToBinaryTree();
        TreeNode root = instance.createTree(nums);
    }
}
