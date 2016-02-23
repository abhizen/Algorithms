import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 12/24/15.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        List<Integer> listX = new ArrayList();
        List<Integer> listY = new ArrayList();
        List<Integer> listXBorn = new ArrayList();
        List<Integer> listYBorn = new ArrayList();
        int count = 0;
        int living = 0;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){

                count = liveCount(i,j,board,0);
                living = liveCount(i,j,board,1);

                if(living<2){
                    listX.add(i);
                    listY.add(j);
                }

                if(living>3){
                    listX.add(i);
                    listY.add(j);
                }

                if(living==3){
                    listXBorn.add(i);
                    listYBorn.add(j);
                }
            }
        }

        for(int i=0;i<listX.size();i++){
            board[listX.get(i)][listY.get(i)] = 0;
        }


        for(int i=0;i<listXBorn.size();i++){
            board[listXBorn.get(i)][listYBorn.get(i)] = 1;
        }
    }

    private int liveCount(int i,int j,int[][] board,int live){
        int count = 0;

        if(j>0){
            if(board[i][j-1]==live)
                count++;
        }

        if(i>0 && j>0){
            if(board[i-1][j-1]==live)
                count++;
        }

        if(i<board.length-1 && j>0){
            if(board[i+1][j-1]==live)
                count++;
        }

        if(i<board.length-1){
            if(board[i+1][j]==live)
                count++;
        }

        if(i>0){
            if(board[i-1][j]==live)
                count++;
        }

        if(j<board[0].length-1){
            if(board[i][j+1]==live)
                count++;
        }


        if(i<board.length-1 && j<board[0].length-1){
            if(board[i+1][j+1]==live)
                count++;
        }

        if(i>0 && j<board[0].length-1){
            if(board[i-1][j+1]==live)
                count++;
        }

        return count;
    }

    public static void main(String[] args){
        GameOfLife instance = new GameOfLife();

        int[][] board = {{1,0},{1,1}};

        instance.gameOfLife(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println(" ");
        }
    }
}
