import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by abhinit on 10/15/15.
 */
public class FriendCircle {
    private enum nodeColor {WHITE,GREY,BLACK}
    private HashMap<Integer,LinkedList<Node>> socialNetwork = new HashMap();
    private Node people[] = null;

    private void buildNetwork(char[][] network){
        Node node  = null;
        LinkedList<Node> friendList = null;
        people = new Node[network[0].length];

        for(int i = 0;i<network[0].length;i++){
            friendList = new LinkedList<>();
            people[i] = getNode(i);

            for(int j=0;j<network[0].length;j++){

                if(i!=j && network[i][j]=='Y') {
                    friendList.add(getNode(j));
                }
            }
            this.socialNetwork.put(i,friendList);
        }
    }

    private void markFriends(int index){
        Stack<Node> stack = new Stack<>();
        Node node = null;
        LinkedList<Node> friendList = null;

        stack.add(this.people[index]);


        while(!stack.isEmpty()) {
            node = stack.pop();

            if(node.getColor().equals(nodeColor.WHITE))
                node.setColor(nodeColor.GREY);

            friendList = this.socialNetwork.get(node.getName());

            if(friendList!=null && friendList.size()>0) {
                for (Node friend : friendList) {
                    if(friend.getColor().equals(nodeColor.WHITE))
                        stack.push(friend);
                }
            }
        }
    }

    private int countCircle(){
        int count = 0;

        for(Node person : this.people){
            if(person.getColor().equals(nodeColor.WHITE)) {
                count++;
            }
            markFriends(person.getName());
        }

        return count;
    }

    private Node getNode(int index){
        if(this.people[index]==null)
            this.people[index] = new Node(index);

        return people[index];
    }

    private class Node{
        private int name = 0;
        private nodeColor color = nodeColor.WHITE;

        public Node(int name){
            this.name = name;
        }

        public int getName(){
            return name;
        }

        public void setColor(nodeColor color){
            this.color = color;
        }

        public nodeColor getColor(){
            return color;
        }

    }

    public int process(char input[][]){
        buildNetwork(input);
        return countCircle();
    }

    public static void main(String[] args){
        char[][] input = null;

        Scanner in = new Scanner(System.in);
        int dimension = in.nextInt();
        String line = null;

        input = new char[dimension][dimension];

        for(int i=0;i<dimension;i++){

            line = in.next();
            for(int j=0;j<dimension;j++) {
                input[i][j] = line.charAt(j);
            }
        }

        FriendCircle instance = new FriendCircle();
        System.out.println(instance.process(input));
    }
}
