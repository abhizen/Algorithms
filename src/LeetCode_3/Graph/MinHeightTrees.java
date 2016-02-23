package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by abhinit on 1/23/16.
 */
public class MinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> map = new HashMap();
        int[] visited = null;

        for(int i=0;i<edges.length;i++){
            addNode(map,edges[i][0],edges[i][1]);
        }

        int height = 0;
        int minHeight = -1;
        int[] heights = new int[n];

        for(int i=0;i<n;i++){
            visited = new int[n];
            visited[i] = 1;
            height = dfs(map,visited,i,0);
            minHeight  = minHeight==-1?height:Math.min(height,minHeight);
            heights[i]  = height;
        }

        List<Integer> heightList = new ArrayList();

        for(int i=0;i<heights.length;i++){
            if(minHeight==heights[i]){
                heightList.add(i);
            }
        }

        return heightList;
    }

    private void addNode(HashMap<Integer,List<Integer>> map,int node,int friend){
        List<Integer> friends = null;

        if(map.get(node)!=null){
            friends = map.get(node);
            if(friends==null){
                friends = new ArrayList();
            }
            friends.add(friend);
        }
        else{
            friends = new ArrayList();
            friends.add(friend);
            map.put(node,friends);
        }

        if(map.get(friend)!=null){
            friends = map.get(friend);
            if(friends==null){
                friends = new ArrayList();
            }
            friends.add(node);
        }
        else{
            friends = new ArrayList();
            friends.add(node);
            map.put(friend,friends);
        }

    }

    private int dfs(HashMap<Integer,List<Integer>> map,int[] visited,int node,int height){
        List<Integer> friends = map.get(node);
        int maxHeight = height;

        if(friends==null || friends.size()==0){
            return height;
        }

        for(Integer friend : friends){
            if(visited[friend]==0){
                visited[friend] = 1;
                maxHeight = Math.max(maxHeight,dfs(map,visited,friend,height+1));
            }
        }

        return maxHeight;
    }

    public static void main(String[] args){
        MinHeightTrees instance = new MinHeightTrees();
        int[][] edges = {{1,0},{1,2},{1,3}};
        List<Integer> list = instance.findMinHeightTrees(4,edges);
        for(int node : list){
            System.out.println(node);
        }
    }
}
