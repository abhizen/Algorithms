/**
 * Created by abhinit on 12/24/15.
 */
public class MinSumPath {
    public int minPathSum(int[][] grid) {
        int[][] path = new int[grid.length][grid[0].length];

        path[0][0] = grid[0][0];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i>0 && j>0){
                    path[i][j] = Math.min(path[i-1][j],path[i][j-1]) + grid[i][j];
                }
                else if(i>0 && j==0){
                    path[i][j] = path[i-1][j] + grid[i][j];
                }
                else if(i==0 && j>0){
                    path[i][j] = path[i][j-1] + grid[i][j];
                }
            }
        }

        return path[grid.length-1][grid[0].length-1];
    }
}
