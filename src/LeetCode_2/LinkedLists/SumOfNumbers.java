package LinkedLists;

/**
 * Created by abhinit on 12/24/15.
 */
public class SumOfNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revl1 = l1;
        ListNode revl2 = l2;
        ListNode l1curr = revl1;
        ListNode l2curr = revl2;
        ListNode newNode = null;
        ListNode newHead = null;
        int carry = 0;

        while(l1curr!=null || l2curr!=null){

            if(newNode==null){
                newHead = getSum(l1curr,l2curr,carry);
                newNode = newHead;
                carry = getCarry(l1curr,l2curr,carry);
            }
            else{
                newNode.next = getSum(l1curr,l2curr,carry);
                carry = getCarry(l1curr,l2curr,carry);
                newNode = newNode.next;
            }
            if(l1curr!=null)
                l1curr = l1curr.next;
            if(l2curr!=null)
                l2curr = l2curr.next;
        }

        if(carry>0) {
            newNode.next = new ListNode(carry);
        }

       // newHead = reverse(newHead);

        return newHead;
    }


    private int getCarry(ListNode nodeA,ListNode nodeB,int carry){

        if(nodeA!=null && nodeB!=null){

            return (nodeA.val+nodeB.val+carry)/10;
        }
        else if(nodeA!=null){
            return ((nodeA.val+carry)/10);
        }
        else if(nodeB!=null){
            return ((nodeB.val+carry)/10);
        }

        return 0;
    }
    private ListNode getSum(ListNode nodeA,ListNode nodeB,int carry){
        ListNode temp = null;

        if(nodeA!=null && nodeB!=null){

            temp = new ListNode((nodeA.val+nodeB.val+carry)%10);
        }
        else if(nodeA!=null){
            temp = new ListNode((nodeA.val+carry)%10);
        }
        else if(nodeB!=null){
            temp = new ListNode((nodeB.val+carry)%10);
        }

        return temp;
    }

    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while(current!=null){

            if(current==head){
                prev = current;
                next= current.next;
                current.next = null;
                current = next;
            }
            else{

                next= current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
        }

        return prev;
    }
    public static void main(String[] args){
        SumOfNumbers instance = new SumOfNumbers();
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);

        ListNode head3 = instance.addTwoNumbers(head1,head2);

        while (head3!=null){
            System.out.println(head3.val);
            head3 = head3.next;
        }
    }
}
