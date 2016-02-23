/**
 * Created by abhinit on 2/10/16.
 */
public class Sample {
    LinkNode listHead = null;

     class LinkNode{
        private int val =0;
        private LinkNode next=null;

        public LinkNode(int val){
            this.val = val;
        }

        public void setNext(LinkNode node){
            this.next = node;
        }

        public int getVal(){
            return val;
        }
    }
     class TreeNode{
        private int val=0;
        private TreeNode left=null;
        private TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal(){
            return val;
        }

        public void setLeftNode(TreeNode left){
            this.left = left;
        }

        public void setRightNode(TreeNode right){
            this.right = right;
        }

        public TreeNode getLeft(){
            return left;
        }

        public TreeNode getRight(){
            return right;
        }
    }
    public void populate(){
        LinkNode node = new LinkNode(1);
        listHead= node;
        node.setNext(new LinkNode(2));
        node = node.next;
        node.setNext(new LinkNode(3));
        node = node.next;
        node.setNext(new LinkNode(4));
        node = node.next;
        node.setNext(new LinkNode(5));
        node = node.next;
        node.setNext(new LinkNode(6));
        node = node.next;
        node.setNext(new LinkNode(7));
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here



        Sample instance = new Sample();
        instance.populate();
        TreeNode head = instance.createTree(0,6);
        System.out.println(head.getVal());
        System.out.println(head.getLeft().getVal());
        System.out.println(head.getRight().getVal());
    }

    private  TreeNode createTree(int left,int right){
        TreeNode root = null;
        if(left==right){
            System.out.println(left);
            TreeNode node = getNode(left);
            return node;
        }

        root = createTree(((left+right)/2),((left+right)/2));
        TreeNode child = createTree(left,((left+right)/2)-1);
        root.left = child;

        child = createTree(((left+right)/2)+1,right);
        root.right = child;

        return root;
    }

    private  TreeNode getNode(int left){
        LinkNode curr = listHead;

        for(int i=0;i<left;i++){
            if(curr!=null)
                curr = curr.next;
        }

        return new TreeNode(curr.getVal());
    }
}
