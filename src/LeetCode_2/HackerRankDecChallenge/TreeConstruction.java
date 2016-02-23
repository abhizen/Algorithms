package HackerRankDecChallenge;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by abhinit on 12/19/15.
 */
public class TreeConstruction {
    private Node root = null;
    private int max = 0;

    public void process(List<Integer> list){
        Node temp = null;
        Queue<Node> queue = new LinkedList<Node>();
        List<Node> friends = null;


        for(int i=0;i<list.size();i++){

            if(root==null) {
                root = new Node(i);
                addFriends(root, list.get(i));
            }
            else{
                temp = root;

                queue = new LinkedList<Node>();
                queue.add(root);
                while (!queue.isEmpty()){

                    temp = queue.remove();
                    if(temp.val==i){
                        addFriends(temp, list.get(i)-1);
                        break;
                    }

                    friends = temp.friends;

                    for(Node friend: friends){
                        queue.add(friend);
                    }
                }

                }
            }

        }



    public void addFriends(Node node,int val) {
        Node temp = null;
        List<Node> friends = node.friends;
        int i = 1;

        for(i=1;i<=val;i++){
            temp = new Node(i+max);
            friends.add(temp);

        }

        max = i+max-1;
    }

    public void printRoots(int val){
        Node temp = root;

        if(root!=null && root.val==val) {
            System.out.println(0);
            return;
        }

        List<Node> friends = null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);


        while (!queue.isEmpty()){

            temp = queue.remove();

            friends = temp.friends;

            for(Node friend: friends){
                if(friend.val==val){
                    System.out.println(temp.val+1);
                    return;
                }
                queue.add(friend);
            }

        }

    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<num;i++) {
            list.add(scan.nextInt());
        }

        TreeConstruction instance = new TreeConstruction();
        instance.process(list);
        for(int i=0;i<list.size();i++){

            instance.printRoots(i);
        }
    }
}
class Node{
    public int val;
    public String color = "WHITE";
    public List<Node> friends = new ArrayList<Node>();

    Node(int val){
        this.val = val;
    }
}
