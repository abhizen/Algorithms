package Tree;

/**
 * Created by abhinit on 1/6/16.
 */
public class SerializeDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String str = traverse(root);
        return str;
    }
    private String traverse(TreeNode root){
        String val = " ";
        String valL = null;
        String valR = null;

        if(root==null)
            return null;

        val = val + root.val;

        valL = traverse(root.left);
        if(valL!=null)
            val = val + " "+valL;
        else
            val = val + " null";

        valR =  traverse(root.right);
        if(valR!=null)
            val = val + " "+valR;
        else
            val = val + " null";

        return val;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data==null || data.length()==0)
            return null;

        data = data.trim();
        String[] arr = data.split("[\\s]+");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        int len = construct(arr,0,root);
        return root;
    }

    private int construct(String[] arr,int index,TreeNode node){
        int arrIndex = 0;

        if(arr[index].equals("null"))
            return index;

        if(arr[index+1].equals("null"))
            node.left = null;
        else
            node.left = new TreeNode(Integer.parseInt(arr[index+1]));

        arrIndex = construct(arr,index+1,node.left);

        if(arr[arrIndex+1].equals("null"))
            node.right = null;
        else
            node.right = new TreeNode(Integer.parseInt(arr[arrIndex+1]));

        arrIndex = construct(arr,arrIndex+1,node.right);

        return arrIndex;
    }

    public static void main(String[] args){
        SerializeDeserialize instance = new SerializeDeserialize();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);

       String str =  instance.serialize(node);
       TreeNode newNode =  instance.deserialize(str);
        System.out.println(str);
    }
}
