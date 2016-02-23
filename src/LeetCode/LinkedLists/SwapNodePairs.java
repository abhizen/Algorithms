package LinkedLists;

/**
 * Created by abhinit on 12/9/15.
 */
public class SwapNodePairs {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        if(head==null)
            return null;

        if(head.next==null)
            return head;

        while(current!=null){

            if(current==head){
                /*swap*/
                next = current.next;
                current.next = next.next;
                next.next = current;

                prev= next;
                next = current;
                head = prev;
            }
            else if(current.next!=null){
                next = current.next;
                prev = prev.next;

                /*swap logic*/
                prev.next = current.next;
                current.next = next.next;
                next.next = current;

                prev = next;
                next = current;
            }


            current = current.next;
        }

        return head;
    }

    public static void main(String[] args){
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(5);
        ListNode current = head1;
        current = head1.next;
       current.next = new ListNode(8);
        current = current.next;
        current.next = new ListNode(9);

        SwapNodePairs instance = new SwapNodePairs();
        head1 = instance.swapPairs(head1);

        while (head1!=null) {
            System.out.println(head1.val+" ");
            head1 = head1.next;
        }
    }
}
