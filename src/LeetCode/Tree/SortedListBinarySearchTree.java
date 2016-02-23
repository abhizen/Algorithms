package Tree;

/**
 * Created by abhinit on 12/12/15.
 */
public class SortedListBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {

        int len = 0;
        ListNode temp = head;

        while (temp!=null){
            len++;
            temp = temp.next;
        }

        TreeNode root = sortedListToBST(head,0,len-1);

        return root;
    }

    private TreeNode sortedListToBST(ListNode startNode,
                                     int start,int end){

        if(start>end)
            return null;

        int mid = (start + end)/2;
        TreeNode root = null;

        ListNode temp = getNode(start,mid,startNode);
        if(temp!=null)
          root = new TreeNode(temp.val);


        root.left = sortedListToBST(startNode,start,mid-1);

        temp = getNode(start,mid+1,startNode);
        root.right = sortedListToBST(temp,mid+1,end);

        return root;
    }

    private ListNode getNode(int start,int mid,ListNode startNode){

        ListNode temp = null;



        for(int i=0;i<=(mid-start);i++){

            if(i==0 && temp==null)
                temp = startNode;
            else
                temp = temp.next;
        }

        return temp;
    }

    public static void main(String[] args){
        SortedListBinarySearchTree instance = new SortedListBinarySearchTree();
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(5);
        ListNode current = head1;
        current = head1.next;
        current.next = null;

        TreeNode root = instance.sortedListToBST(head1);
        System.out.println(root.val);
    }
}
