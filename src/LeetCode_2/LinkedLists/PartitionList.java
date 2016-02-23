package LinkedLists;

/**
 * Created by abhinit on 12/29/15.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {

        if(head==null)
            return null;

        ListNode current = head;
        ListNode pivot = null;
        ListNode last = null;

        while(current!=null){
            last = current;
            current = current.next;
        }

        current = head;

        while(current!=null){
            if(current.val==x)
                break;
            current = current.next;
        }

        if(current==null)
            return head;

        swap(last,current);

        current = head;
        pivot = null;
        while(current.next!=null){
            if(current.val<last.val){
                if(pivot==null)
                    pivot=head;
                else
                    pivot = pivot.next;

                swap(pivot,current);
            }
            current = current.next;
        }

        if(pivot==null){
            pivot=head;
        }
        else if(pivot.next!=null){
            pivot = pivot.next;
        }


        swap(pivot, last);

        return head;
    }

    private void swap(ListNode nodeA,ListNode nodeB){
        int temp = nodeA.val;
        nodeA.val = nodeB.val;
        nodeB.val = temp;
    }
    public static void main(String[] args){
        PartitionList instance = new PartitionList();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);

        instance.partition(head,2);
        ListNode node = head;
        while (node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}
