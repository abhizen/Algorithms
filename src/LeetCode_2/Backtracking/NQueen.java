package Backtracking;

/**
 * Created by abhinit on 12/18/15.
 */
public class NQueen {
    public int[][] grid = null;
    private int dimx = 0;
    private int dimy= 0;

    public NQueen(int dimx,int dimy){
        grid = new int[dimx][dimy];
        this.dimx = dimx;
        this.dimy = dimy;
    }

    public boolean placeQueen(int i,int dimx){

        if(i>=this.dimy)
            return false;

        for(int j=0;j<dimy;j++){

            if(checkQueenPosition(i,j)) {
                this.grid[i][j] = 1;
                if(i==(dimx-1)) {
                    printGrid();
                    return true;
                }
                else if(placeQueen(i+1,dimx))
                    return true;
            }

            grid[i][j] = 0;
        }

        return false;
    }

    public boolean checkQueenPosition(int i, int k){

        for(int j=0;j<i;j++){
            for(int c=0;c<dimy;c++){

                if(grid[j][c]==1 && ((c==k) || Math.abs(i-j)==Math.abs(k-c)))
                    return false;
            }
        }

        return true;
    }
    private void printGrid(){
        for(int i=0;i<dimx;i++){
            for(int j=0;j<dimy;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){

        NQueen instance = new NQueen(4,4);
        instance.placeQueen(0,4);
/*
        for(int i=0;i<instance.dimx;i++){
            for(int j=0;j<instance.dimy;j++){
                System.out.print(instance.grid[i][j] + " ");
            }
            System.out.println("");
        }*/

    }
}
