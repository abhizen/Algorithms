/**
 * Created by abhinit on 11/22/15.
 */
public class ReverseLinkedList {
    LinkedLists.ListNode head = null;

    ReverseLinkedList(){
        LinkedLists.ListNode temp = new LinkedLists.ListNode(1);

        LinkedLists.ListNode temp2 = new LinkedLists.ListNode(2);
        temp.next = temp2;
        temp2.next = null;
        head = temp;
        temp2.next = new LinkedLists.ListNode(3);
    }

    public LinkedLists.ListNode reverseList(LinkedLists.ListNode head) {
        LinkedLists.ListNode prev = head;
        LinkedLists.ListNode current = null;
        LinkedLists.ListNode next = null;

        if(head ==null)
            return null;
        if(head.next==null)
            return head;

        current = prev.next;
        next = current.next;

        while(current!=null){
            current.next = prev;
            if(prev==head) {
                prev.next = null;
            }
            prev = current;
            current = next;

            if(next!=null)
                next = next.next;
        }


        head = prev;

        return head;
    }

    public static void main(String[] args){
        ReverseLinkedList instance = new ReverseLinkedList();
        LinkedLists.ListNode node = instance.reverseList(instance.head);
        LinkedLists.ListNode temp = node;

        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }

    }
}

