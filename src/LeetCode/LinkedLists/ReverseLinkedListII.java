package LinkedLists;

/**
 * Created by abhinit on 12/13/15.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {


        if(head==null)
            return null;
        else if(head.next==null)
            return head;

        ListNode current = getNode(m,head);
        ListNode prev = null;
        ListNode next = null;

        ListNode firstNode = null;
        ListNode secNode = null;
        ListNode lastNode = null;
        int count = m;

        if(m>0)
            prev = getNode(m-1,head);

        while(current!=null && count<=n){

            if(current==head){
                next = current.next;
                current.next = null;

                prev = current;
                current = next;
            }
            else{
                next = current.next;
                current.next = prev;

                prev = current;
                current = next;
            }

            if(firstNode ==null && count==m){
                secNode = prev;
                firstNode = prev.next;
            }

            count++;
        }

        lastNode = next;
        if(firstNode!=null && lastNode!=null) {
            firstNode.next = prev;
            secNode.next = lastNode;
            head = firstNode;
        }
        else if(firstNode==null && lastNode!=null){
            secNode.next = lastNode;
            head = prev;}
        else if(firstNode!=null && lastNode==null) {
            firstNode.next = prev;
            secNode.next = null;

        }else
            head = prev;


        return head;
    }

    private ListNode getNode(int m,ListNode head){
        ListNode temp = null;

        for(int i=0;i<=m;i++){
            if(i==0 && temp==null)
                temp = head;
            else if(temp!=null)
                temp = temp.next;
            else
                break;
        }

        return temp;
    }

    public static void main(String[] args){

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
       ListNode current = head1;
        current = head1.next;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(4);
        current = current.next;
        current.next = new ListNode(5);

        ReverseLinkedListII instance = new ReverseLinkedListII();
        head1 = instance.reverseBetween(head1,3,4);

        ListNode temp = head1;

        while (temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}
