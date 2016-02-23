import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by abhinit on 9/12/15.
 */
public class LiveRampBFS {
    private int[] graph = null;
    private int[] distanceArray = null;
    private HashMap<Integer,Integer> nodeMap = null;

    public LiveRampBFS(int[] graph){
        this.graph = graph;
        this.distanceArray = new int[this.graph.length];
    }

    private int getRootIndex(){
        int index = 0;
        for(int node : this.graph){
            if(index==node)
                return index;

            index++;
        }

        return -1;
    }
    private void traverse(){
        Queue queue = new LinkedList();
        int rootIndex = this.getRootIndex();
        int index = 0;
        nodeMap = new HashMap<>();
        nodeMap.put(3,0);

        if(rootIndex==-1)
            return;
        else
            queue.add(rootIndex);

        int graphIndex = 0;
        while(queue.size()!=0){
            index = (int)queue.remove();
            graphIndex = 0;
            for(int graphNode : this.graph){

                if(index!=graphIndex
                    && graphNode==index){
                    if(nodeMap.get(graphIndex)==null) {
                        nodeMap.put(graphIndex,
                                nodeMap.get(index).intValue() + 1);
                    }
                    queue.add(graphIndex);
                }
                graphIndex++;
            }

        }
    }

    public void printDistanceArray(){
        this.traverse();
        Iterator itr = nodeMap.keySet().iterator();
        Integer key = null;

        while (itr.hasNext()){
            key = (Integer)itr.next();
            System.out.println("key :"+key+" distance:"+this.nodeMap.get(key));
        }
    }

    public static void main(String[] args){
        int[] graph = {3,3,3,3,1,4,5,2};
        LiveRampBFS bfs = new LiveRampBFS(graph);
        bfs.printDistanceArray();
    }
}
