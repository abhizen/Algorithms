import java.util.*;

/**
 * Created by abhinit on 1/3/16.
 */
public class IslandProblem {

    class Node{
        int val = 0;
        int color = 0;
        List<Node> nodeList = new ArrayList();

        Node(int val){
            this.val = val;
        }
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        int numOfNodes = rows*cols-1;
        Map<Integer,Node> map = createGraph(grid);
        Node root = null;

        for(int id : map.keySet()){
            root = map.get(id);

            if(root.color==0){
                count++;
                bfs(root);
            }
        }

        return count;
    }

    private Map<Integer,Node> createGraph(char[][] grid){
        Map<Integer,Node> map = new HashMap();
        Node node = null;
        Node adj = null;
        List<Node> nodeList = null;
        int rows = grid.length;
        int cols = grid[0].length;

        int nodeId = 0;
        int left =0;
        int right =0;
        int upper =0;
        int lower =0;



        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                nodeId = (cols*i) +  j;
                if(grid[i][j]=='1'){
                    node = new Node(nodeId);
                    map.put(nodeId,node);
                }
            }
        }


        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]=='0')
                    continue;

                nodeId = (cols*i) +  j;
                node = map.get(nodeId);
                left = getLeft(i,j,cols);
                right = getRight(i,j,cols);
                upper = getUpper(i,j,cols);
                lower = getLower(i,j,cols);

                if((j-1)>=0  && map.get(left)!=null && grid[i][j-1]=='1'){
                    adj = map.get(left);
                    node.nodeList.add(adj);

                }
                if((j+1)<grid[0].length  && map.get(right)!=null && grid[i][j+1]=='1'){
                    adj = map.get(right);
                    node.nodeList.add(adj);
                }

                if((i-1)>=0  && map.get(upper)!=null && grid[i-1][j]=='1'){
                    adj = map.get(upper);
                    node.nodeList.add(adj);
                }

                if((i+1)<grid.length  && map.get(lower)!=null && grid[i+1][j]=='1'){
                    adj = map.get(lower);
                    node.nodeList.add(adj);
                }
            }
        }

        return map;
    }

    private void bfs(Node root){
        Node node = root;
        Queue<Node> queue = new LinkedList();

        List<Node> nodeList = node.nodeList;
        queue.add(node);

        while(!queue.isEmpty()){
            node = queue.remove();
            if(node.color==0){
                node.color =1;
                nodeList = node.nodeList;
                for(Node friend : nodeList){
                    if(friend.color==0){
                        queue.add(friend);
                    }
                }
            }
        }

    }

    private int getLeft(int i,int j,int cols){
        return (cols*i) +  j-1;
    }


    private int getRight(int i,int j,int cols){
        return (cols*i) +  j+1;
    }

    private int getUpper(int i,int j,int cols){
        return (cols*(i-1)) +  j;
    }

    private int getLower(int i,int j,int cols){
        return (cols*(i+1)) +  j;
    }

    public static void main(String[] args){
        IslandProblem instance = new IslandProblem();
        char[][] islands = {{'1','1','0','0'},{'0','0','1','1'}};
        int count = instance.numIslands(islands);
        System.out.println("Count : " + count);
    }
}
