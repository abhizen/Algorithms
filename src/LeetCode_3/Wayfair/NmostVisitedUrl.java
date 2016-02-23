package Wayfair;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by abhinit on 1/20/16.
 */
public class NmostVisitedUrl {
    private int k = 10;
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(k,Collections.reverseOrder());

    public void putEntry(int data){
        priorityQueue.add(data);
    }

    public void print(){
       int elem = 0;

        while (!priorityQueue.isEmpty()) {
            elem = priorityQueue.remove();
            System.out.println("Element "+elem);
        }
    }

    public static void main(String[] args){
        NmostVisitedUrl instance = new NmostVisitedUrl();
        instance.putEntry(2);
        instance.putEntry(3);
        instance.putEntry(10);
        instance.putEntry(5);
        instance.putEntry(6);

        instance.print();
    }
}
