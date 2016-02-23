package Tableau;

/**
 * Created by abhinit on 12/17/15.
 */
public class Minesweeper {
    private int[][] grid = null;
    private int dimx = 0;
    private int dimy = 0;

    public Minesweeper(int dimx,int dimy,int numOfMines){
        grid = new int[dimx][dimy];

        this.dimx = dimx;
        this.dimy = dimy;

        if(dimx<=0 || dimy<=0)
            return;

        populateMineCells(dimx*dimy,numOfMines);


    }

    private int getRandomCells(int n){
        return (int)Math.random()*n;
    }

    private void populateMineCells(int noOfCells, int numOfMines){
        int row = 0;
        int col = 0;
        int cellId = 0;
        int i =0;

        while (i<numOfMines){
            cellId = getRandomCells(noOfCells);
            row = cellId/dimy;
            col = cellId%dimy;

            if(grid[row][col]!=1) {
                grid[row][col] =1;
                i++;
            }
        }
    }

    private void populateMineCount(){

        for(int i=0;i<this.dimx;i++){
            for(int j=0;j<this.dimy;j++){
                grid[i][j]  = getMineCount(i,j);
            }
        }
    }

    private int getMineCount(int i,int j){
        int count = 0;

        if(i>0 && j>0 && grid[i-1][j-1]==1)
            count++;

        if(j>0 && grid[i][j-1]==1)
            count++;

        if(i<dimx-1 && j>0 && grid[i+1][j-1]==1)
            count++;

        if(i<dimx-1  && grid[i+1][j]==1)
            count++;

        if(i<dimx-1 && j<dimy-1 && grid[i+1][j+1]==1)
            count++;

        if(j<dimy-1 && grid[i][j+1]==1)
            count++;

        if(i>0   && j<dimy-1 && grid[i-1][j+1]==1)
            count++;

        return count;
    }
}
