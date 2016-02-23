package LinkedLists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 11/26/15.
 */
public class MergeLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        ListNode temp2  = l2;
        ListNode merged = null;
        ListNode head = null;

        if(l1==null && l2==null)
            return null;

        if(l1==null && l2!=null)
            return l2;

        if(l1!=null && l2==null)
            return l1;

        while(temp!=null){

            if(temp2==null)
                break;
            if(temp.val<temp2.val){
                if(merged==null){
                    merged = new ListNode(temp.val);
                    merged.next = null;
                    head = merged;
                    temp = temp.next;
                }
                else{
                    merged.next = new ListNode(temp.val);
                    merged = merged.next;
                    merged.next = null;
                    temp = temp.next;
                }
            }
            else if(temp.val>=temp2.val){
                if(merged==null){
                    merged = new ListNode(temp2.val);
                    merged.next = null;
                    head = merged;
                    temp2 = temp2.next;
                }
                else{
                    merged.next = new ListNode(temp2.val);
                    merged = merged.next;
                    merged.next = null;
                    temp2 = temp2.next;
                }
            }
        }

        if(temp==null && temp2!=null){
            while(temp2!=null){
                merged.next = new ListNode(temp2.val);
                merged = merged.next;
                merged.next = null;
                temp2 = temp2.next;
            }
        }

        if(temp!=null && temp2==null){
            while(temp!=null){
                merged.next = new ListNode(temp.val);
                merged = merged.next;
                merged.next = null;
                temp = temp.next;
            }
        }

        return head;

    }
    public static void main(String[] args){
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(5);
        ListNode current = head1;
        current = head1.next;
        current.next = null;

        ListNode head2 = new ListNode(4);
        head2.next = null;

        MergeLists instance = new MergeLists();
        ListNode result = instance.mergeTwoLists(head1,head2);

        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();
    }
}
