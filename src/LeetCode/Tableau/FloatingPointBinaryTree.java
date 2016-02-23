package Tableau;

/**
 * Created by abhinit on 12/4/15.
 */
public class FloatingPointBinaryTree {
FloatingPointNode root= null;

    public void addNode(float val){
        FloatingPointNode node = null;
        FloatingPointNode current = null;

        if(this.root==null){
            this.root = new FloatingPointNode(val);
        }
        else {
            node = root;

            while(node!=null){
                if(node.val<val) {
                    current = node;
                    node = node.right;

                }
                else {
                    current = node;
                    node = node.left;
                }
            }

            if(current.val<val){
                current.right = new FloatingPointNode(val);
            }
            else {
                current.left =  new FloatingPointNode(val);
            }
        }
    }

    public void traverse(FloatingPointNode root){
        FloatingPointNode left = null;
        FloatingPointNode right = null;

        if(root==null)
            return;


        traverse(root.left);

        System.out.println(root.val);

        traverse(root.right);


    }

    public static void main(String[] args){
        FloatingPointBinaryTree instance = new FloatingPointBinaryTree();
        float[] input = {2,6,4,3,8,9};

        for(float elem : input){
            instance.addNode(elem);
        }

        instance.traverse(instance.root);
    }
}
class FloatingPointNode{
    float val = 0;

    FloatingPointNode(float val){
        this.val = val;
    }

    FloatingPointNode right = null;
    FloatingPointNode left = null;
}
