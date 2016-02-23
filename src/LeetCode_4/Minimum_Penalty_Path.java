import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * Created by abhinit on 2/22/16.
 */
public class Minimum_Penalty_Path {
    public static int process(GraphNode node,List<GraphNode> nodeList,int minProduct,GraphNode target){
        int product = -1;
        int tempProduct = 0;

        List<GraphNode> friends = node.list;
        List<GraphNode> tempNodeList = null;
        int flag = 0;

        if(node==target){
            return minProduct;
        }
        else if(node!=target && friends.isEmpty())
            return -1;

        for(GraphNode friend : friends){
            flag = 0;
            for(GraphNode temp : nodeList){
                if(temp==friend){
                    flag =-1;
                    break;
                }
            }
            if(flag==0){
                List<Integer> weightList = node.weightMap.get(friend);

                for(int i=0;i<weightList.size();i++){
                    nodeList.add(friend);
                    tempProduct = process(friend,nodeList,minProduct|weightList.get(i),target);
                    if(tempProduct>-1 && product>-1)
                        product = Math.min(tempProduct,product);
                    else if(tempProduct>-1 && product==-1)
                        product = tempProduct;
                    nodeList.remove(friend);
                }
            }

        }

        return product;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        GraphNode node = null;
        Map<Integer,GraphNode> map = new HashMap();
        int nodeA = 0;
        int nodeB = 0;
        int weight =0;

        for(int i=1;i<=N;i++){
            node = new GraphNode(i);
            map.put(i,node);
        }

        GraphNode graphNodeA = null;
        GraphNode graphNodeB = null;
        List<GraphNode> list = null;
        List<Integer> weightList = null;
        Map<GraphNode,List<Integer>> weightMap =null;
        // int weight = 0;

        for(int i=1;i<=M;i++){
            nodeA = scan.nextInt();
            nodeB = scan.nextInt();
            weight = scan.nextInt();

            graphNodeA = map.get(nodeA);
            graphNodeB = map.get(nodeB);
            list = graphNodeA.list;
            weightMap = graphNodeA.weightMap;
            list.add(graphNodeB);
            weightList = weightMap.get(graphNodeB);
            if(weightList==null){
                weightList = new ArrayList();
                weightList.add(weight);
                weightMap.put(graphNodeB,weightList);
            }
            else{
                weightList.add(weight);
                weightMap.put(graphNodeB,weightList);
            }
        }
        nodeA = scan.nextInt();
        nodeB = scan.nextInt();
        weight = 0;
        weight =  process(map.get(nodeA),new ArrayList(),weight,map.get(nodeB));
        System.out.println(weight);
    }
}
class GraphNode{
    int val;
    GraphNode(int val){
        this.val  = val;
    }
    List<GraphNode> list = new ArrayList();
    Map<GraphNode,List<Integer>> weightMap = new HashMap();
}
