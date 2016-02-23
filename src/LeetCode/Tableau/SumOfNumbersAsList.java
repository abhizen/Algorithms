package Tableau;

/**
 * Created by abhinit on 12/3/15.
 */
public class SumOfNumbersAsList {


    private static int getSum(ListNode firstNode,ListNode secNode){
        ListNode firstListCurrent = firstNode;
        ListNode secondListCurrent = secNode;
        int sum = 0;
        int carry = 0;
        int place = 0;
        int currentSum = 0;

        while (firstListCurrent!=null){

            if(secondListCurrent!=null){
                currentSum = ((firstListCurrent.val + secondListCurrent.val +carry)%10);
                carry = currentSum/10;
                sum = sum + currentSum*(int)Math.pow(10,place);
                secondListCurrent = secondListCurrent.next;
            }
            else{
                currentSum = ((firstListCurrent.val +carry)%10);
                sum = sum + currentSum*(int)Math.pow(10,place);
                carry = currentSum/10;
            }

            place++;
            firstListCurrent = firstListCurrent.next;

        }

        while (secondListCurrent!=null){
            sum = sum + ((firstListCurrent.val
                    + secondListCurrent.val +carry)%10)
                    *(int)Math.pow(10,place);
            carry = sum/10;
            place++;
            secondListCurrent = secondListCurrent.next;
        }

        return sum;

    }

    private static ListNode reverseLinkedList(ListNode head){

        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;

        while(current!=null) {

            if(current==head){
                next = current.next;
                current.next = null;
                prev = current;
            }
            else{
                next = current.next;
                current.next = prev;
                prev = current;
            }

            current = next;
        }

        return prev;
    }

    public static int process(ListNode firstListHead,ListNode secListHead){

        firstListHead = reverseLinkedList(firstListHead);
        secListHead = reverseLinkedList(secListHead);

        int sum = getSum(firstListHead,secListHead);

        return sum;
    }

    public static void main(String[] args){
        ListNode firstList = new ListNode(5);
        firstList.next = new ListNode(4);
        firstList.next.next = new ListNode(4);


        ListNode secondList = new ListNode(3);
        secondList.next = new ListNode(3);

        int sum = process(firstList,secondList);
        System.out.println("Sum: " +sum);

    }

}
class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
}