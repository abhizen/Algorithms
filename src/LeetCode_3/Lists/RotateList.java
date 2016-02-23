package Lists;

/**
 * Created by abhinit on 2/6/16.
 */
class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = null;
        ListNode node = null;
        int count = 0;

        if(head==null)
            return head;

        for(curr=head;curr!=null;curr=curr.next){
            node = curr;
            if(count>=k){
                if(prev==null){
                    prev = head;
                }
                else
                    prev = prev.next;
            }
            count++;
        }

        node.next = head;
        if(prev!=null && prev.next!=null){
            curr = prev.next;
            prev.next=null;
            head = curr;
        }

        return head;
    }
    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        //node.next = new ListNode(3);
        ListNode head = rotateRight(node,2);
        ListNode curr = head;
        while (curr!=null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
