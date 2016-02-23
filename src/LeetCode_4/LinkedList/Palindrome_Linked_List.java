package LinkedList;

/**
 * Created by abhinit on 2/15/16.
 */
public class Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        ListNode node = head;
        int len = 0;

        if(head==null)
            return true;

        while(node!=null){
            node = node.next;
            len++;
        }

        ListNode midNode = head;
        for(int i=0;i<len/2;i++){
            midNode = midNode.next;
        }

        ListNode nextHalfHead = reverse(midNode);
        //midNode.next = null;
        ListNode curr = head;
        while(curr!=null && nextHalfHead!=null){
            if(curr.val!=nextHalfHead.val){
                System.out.println(curr.val);
                System.out.println(nextHalfHead.val);
                return false;
            }
            curr= curr.next;
            nextHalfHead = nextHalfHead.next;
        }

        return true;

    }

    private ListNode reverse(ListNode head){
        ListNode prev= null;
        ListNode curr= head;
        ListNode next  =null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        Palindrome_Linked_List instance = new Palindrome_Linked_List();
        if(instance.isPalindrome(head)){
            System.out.println("Yes");
        }
    }
}
