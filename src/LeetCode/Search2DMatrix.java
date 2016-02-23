/**
 * Created by abhinit on 12/14/15.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null)
            return false;

        int row = matrix.length;
        int col = matrix[0].length-1;

        row = searchCol(matrix,col,target);

        if(row==-1)
            return false;

        if(matrix[row][col]==target)
            return true;
        else{
            col--;

            while(col>=0 && col<matrix[0].length && row>=0 && row<matrix.length){
                if(matrix[row][col]==target)
                    return true;
                else if(matrix[row][col]>target)
                    col--;
                else if(matrix[row][col]<target)
                    row++;
            }

        }

        return false;
    }

    private int searchCol(int[][] matrix,int col, int target){
        int len = matrix.length;
        //int row = matrix[0].length-1;

        for(int i=0;i<len;i++){
            if(matrix[i][col]>=target)
                return i;
        }

        return -1;
    }
    public static void main(String[] args){

        int[][] input = {{-1,3}};
        Search2DMatrix instance = new Search2DMatrix();
        if(instance.searchMatrix(input,-1))
            System.out.println("got it");
        else
            System.out.println("not dere");
    }
}
