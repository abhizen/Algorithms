/**
 * Created by abhinit on 2/8/16.
 */
class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
public class ReorderList {
    public void reorderList(ListNode head) {

        if(head==null)
            return;

        if(head.next==null || head.next.next==null)
            return;

        ListNode curr = head;

        while(curr!=null){
            reverseList(curr);
            if(curr.next!=null)
                curr = curr.next.next;
            else
                break;
        }

    }

    private void reverseList(ListNode head){
        ListNode secNode = head.next;
        ListNode lastNode = null;
        ListNode preLastNode = null;
        ListNode curr = head;

        if(head.next==null || head.next.next==null)
            return;

        while(curr!=null){
            preLastNode = lastNode;
            lastNode = curr;
            curr = curr.next;
        }

        preLastNode.next = null;
        head.next = lastNode;
        lastNode.next = secNode;
    }

    /*My Initial solution was appending values in new list,
     by first dividing the list into two halves and appending the values
      alternatively into new list.
     This approach is same as before but values are inserted in place
      instead of taking new list.
    * */
    public void reorderList_tuned(ListNode head){
        ListNode current = null;
        ListNode lastNode = null;
        ListNode midNode = null;
        ListNode secCurrent = null;

        int len = 0;
        current = head;
        //finding length
        while (current!=null){
            len++;
            current = current.next;
        }
        current = head;
        int count=0;
        //finding mid node
        while (current!=null){
            if(count==(len/2)) {
                midNode = current;
                break;
            }
            count++;
            current = current.next;
        }

        current = head;
        secCurrent = reverseLinkedList(midNode.next);
        midNode.next = null;
        ListNode newListNode = null;

        //create new list
        while (current!=null || secCurrent!=null){

            if(secCurrent!=null && current!=null) {
                newListNode = current.next;
                current.next = secCurrent;
                current = current.next;
                secCurrent=secCurrent.next;

                current.next = newListNode;
                current = current.next;
            }
            else if(current!=null){
                current = current.next;
            }

        }

    }

    private ListNode reverseLinkedList(ListNode node){
        ListNode current = node;
        ListNode prev = null;
        ListNode next = null;


        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static void main(String[] args){
        ReorderList instance = new ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        instance.reorderList_tuned(head);

        ListNode node = head;
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
