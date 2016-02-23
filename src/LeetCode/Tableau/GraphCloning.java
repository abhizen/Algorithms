package Tableau;

import java.util.*;

/**
 * Created by abhinit on 12/3/15.
 */
public class GraphCloning {
    private enum nodeColor {WHITE,GREY,BLACK}
    private HashMap<Integer,Node> networkNodeMap = null;
    private Map<Node,Node> nodeMap = null;

    public Map<Node,Node> clone(){
        Node node = this.networkNodeMap.get(0);
        List<Node> friends = null;
        Node copy = null;
        Node root = null;
        Node copyFriend = null;
        Map<Node,Node> nodeMap = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.remove();
            friends = node.friends;


            if(nodeMap.get(node)==null){
                copy = new Node(node.val);
                nodeMap.put(node,copy);
                if(root==null)
                    root = copy;
            }
            else
                copy = nodeMap.get(node);

            for(Node friend : friends) {

                if(friend.color.equals(nodeColor.WHITE)) {
                    if (nodeMap.get(friend) == null) {
                        copyFriend = new Node(friend.val);
                        nodeMap.put(friend, copy);
                    } else {
                        copyFriend = nodeMap.get(friend);
                    }

                    copy.addFriend(copyFriend);
                    queue.add(friend);
                }
            }

            if(node.color.equals(nodeColor.WHITE))
                node.color= nodeColor.BLACK;

        }

        return nodeMap;
    }

    private void buildNetwork(int[][] network){
        networkNodeMap = new HashMap<>();
        Node node = null;
        Node friend = null;

        for(int i=0;i<network.length;i++) {

            if(networkNodeMap.get(i)==null){
                node = new Node(i);
                networkNodeMap.put(i,node);
            }
            else{
                node = networkNodeMap.get(i);
            }

            for(int j=0;j<network[0].length;j++) {
                if(i!=j && network[i][j]==1){
                    if(networkNodeMap.get(j)==null) {
                        friend = new Node(j);
                        networkNodeMap.put(j, friend);
                    }
                    else{
                        friend = networkNodeMap.get(j);
                    }

                    node.addFriend(friend);
                }
            }
        }
    }

    class Node{
        int val = 0;
        List<Node> friends= null;
        nodeColor color = nodeColor.WHITE;

        Node(int val){
            this.val = val;
        }

        public void addFriend(Node friend){
            if(this.friends==null)
                this.friends = new ArrayList<>();

            this.friends.add(friend);
        }

    }

    public static void main(String[] args){

        GraphCloning instance = new GraphCloning();
        int[][] network = {{0,1,1},{1,1,1},{1,0,0}};
        instance.buildNetwork(network);
        Map<Node,Node> map = instance.clone();
        List<Node> children = null;

        for(Node key :map.keySet()){
            System.out.print(key.val+" : ");
            children = key.friends;
            for(Node child : children){
                System.out.print(" " + child.val);
            }

            System.out.println("");
        }
    }

}
