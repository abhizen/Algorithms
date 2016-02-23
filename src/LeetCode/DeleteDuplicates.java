/**
 * Created by abhinit on 11/24/15.
 */
public class DeleteDuplicates {
    NewListNode list = null;

    public NewListNode deleteDuplicates(NewListNode head) {
        NewListNode current = null;
        NewListNode prevCurrent = null;

        if(head==null)
            return null;

        if(head.next==null)
            return head;

        current = head.next;
        prevCurrent = head;


        while(current!=null){
            if(current.val == prevCurrent.val){
                prevCurrent.next = current.next;


                current = current.next;
            }
            else {
                prevCurrent = prevCurrent.next;
                current = current.next;
            }

        }

        return head;
    }


    public static void main(String[] args){
        DeleteDuplicates instance = new DeleteDuplicates();
        instance.list = new NewListNode(1);
        instance.list.next = new NewListNode(1);
        instance.list.next.next = new NewListNode(1);
        instance.list.next.next.next = null;
        instance.list = instance.deleteDuplicates(instance.list);

        System.out.println(instance.list.val);

    }

}
class NewListNode {
    int val;
    NewListNode next;
    NewListNode(int x) { val = x; }
}