package Graph;

import java.util.*;

/**
 * Created by abhinit on 1/7/16.
 */
public class GraphClone{


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if(node==null)
            return null;

        UndirectedGraphNode root = node;
        Queue<UndirectedGraphNode> queue = new LinkedList();
        queue.add(root);
        UndirectedGraphNode copy = null;
        UndirectedGraphNode copyRoot = null;
        UndirectedGraphNode friendNode = null;
        Map<UndirectedGraphNode,UndirectedGraphNode> labelMap = new HashMap();
        Map<UndirectedGraphNode,Boolean> graphMap = new HashMap();
        List<UndirectedGraphNode> neighbors = null;

        if(labelMap.get(root.label)==null){
            copy = new UndirectedGraphNode( root.label);
            labelMap.put(root,copy);
        }


        if(copyRoot==null){
            copyRoot= copy;
        }

        while(!queue.isEmpty()){
            root = queue.remove();

            copy = labelMap.get(root);


            neighbors = copy.neighbors;

            for(UndirectedGraphNode childNode : root.neighbors){

                if(graphMap.get(childNode)==null){
                    graphMap.put(childNode,true);
                    queue.add(childNode);
                }

                if(labelMap.get(childNode)==null){
                    friendNode = new UndirectedGraphNode(childNode.label);
                    neighbors.add(friendNode);
                    labelMap.put(childNode,friendNode);
                }
                else{
                    friendNode = labelMap.get(childNode);
                    neighbors.add(friendNode);
                }
            }
        }

        return copyRoot;
    }

    public static void main(String[] args){

        UndirectedGraphNode node = new UndirectedGraphNode(0);
        node.neighbors.add(new UndirectedGraphNode(0));
        node.neighbors.add(new UndirectedGraphNode(0));

        GraphClone instance = new GraphClone();
        UndirectedGraphNode root = instance.cloneGraph(node);

        System.out.println("Yes");

    }

}
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

}
