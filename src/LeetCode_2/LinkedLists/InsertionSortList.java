package LinkedLists;

/**
 * Created by abhinit on 12/30/15.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {

        if(head==null)
            return null;

        ListNode currA = head;
        ListNode currB = head.next;
        ListNode temp = null;
        ListNode last = null;
        ListNode prev = null;
        int val = 0;

        while(currB!=null){

            if(currA.val>currB.val){

                last = currA.next;
                temp = reverseList(head,last);
                prev = temp;

                while (temp!=null){

                    if(temp.val>currB.val){
                        val = temp.val;
                        temp.val = currB.val;
                        currB.val = val;
                        currB= temp;
                    }
                    temp= temp.next;
                }
                head = reverseList(prev,null);
                temp = head;
                while (temp.next!=null){
                    temp = temp.next;
                }
                temp.next = last;
                currB = temp;
                currA = temp;
                //currA.next = last;
            }
            else{
                currA= currA.next;
            }

            currB = currB.next;
        }

        return head;
    }
    private ListNode reverseList(ListNode head,ListNode last){
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while(current!=last){
            /*if(current==head){

                next = current.next;
                current.next=null;
                prev = current;
                current = next;
            }
            else{*/
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            //}
        }
        return prev;
    }
    public static void main(String[] args){
        InsertionSortList instance = new InsertionSortList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        instance.insertionSortList(head);

        ListNode current = head;
        while(current!=null){
            System.out.println(current.val+" ");
            current = current.next;
        }
    }
}
