import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reddwerks {

    //Question 1
    public static Object[] reverse(Object[] input){
        if(input==null)
            return null;

        Object[] newArray = new Object[input.length];

        int index = 0;

        for(int i=input.length-1;i>=0;i--){
            newArray[index] = input[i];
            index++;
        }

        return newArray;
    }

    //Question 2
    public static int[] removeDuplicates(int[] a) {

        if(a==null)
            return null;

        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<a.length;i++){
            if(map.get(a[i])==null) {
                map.put(a[i], 1);
                list.add(a[i]);
            }

        }

        int index = 0;
        int[] output = new int[list.size()];
        for(int elem : list){
            output[index] = elem;
            index++;
        }

        return output;
    }

    /*Question 3*/
    public static ListNode reverse(ListNode node) {
        ListNode prev = node;
        ListNode current = null;
        ListNode next = null;

        if(node ==null)
            return null;
        if(node.getNext()==null)
            return node;

        current = prev.getNext();
        next = current.getNext();

        while(current!=null){
            current.setNext(prev);
            if(prev==node) {
                prev.setNext(null);
            }
            prev = current;
            current = next;

            if(next!=null)
                next = next.getNext();
        }


        node = prev;

        return node;

    }

    /*Question 4*/
    public static void sort(int[] input,ArrayList<Integer> list){

        if(input==null)
            return;

        int len = input.length;
        int max = 0;
        int maxIndex = 0;

        for(int i=len;i>0;i--){

            max = 0;
            for(int j=0;j<i;j++){
                if(input[j]>max) {
                    max = input[j];
                    maxIndex = j;
                }
            }


            if(maxIndex!=(i-1)) {
                list.add(maxIndex + 1);
                list.add(i);
            }
            flip(input, maxIndex);

            flip(input,i-1);

        }
    }


    private static void flip(int arr[], int i)
    {
        int temp, start = 0;
        while (start < i)
        {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }
    public static List<Integer> getReversalsToSort(int[] a) {
        List<Integer> list = new ArrayList<Integer>();
        sort(a,(ArrayList<Integer>)list);
        return list;
    }

    public static void main(String[] args){
        Object a[] = {5,4,6,1};
        Object b[] = reverse(a);

        for(Object elem  : b)
            System.out.println((int)elem);
        Name obj = new Name();

        System.out.println(obj.toString());
    }

}
class Name{

}

interface ListNode {
    int getItem();
    ListNode getNext();
    void setNext(ListNode next);
}