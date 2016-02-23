/**
 * Created by abhinit on 12/25/15.
 */
public class SetZero {
    public static void setZeroes(int[][] matrix) {
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]==0){
                setRowCol(matrix,i,j);
            }
        }
    }

}

    private static void setRowCol(int[][] matrix,int row,int col){
        int len1 = matrix[0].length;

        for(int i=0;i<len1;i++){
            matrix[row][i] = 0;
        }

        len1 = matrix.length;

        for(int i=0;i<len1;i++){
            matrix[i][col] = 0;
        }
    }
    public static void main(String[] args){
        int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        setZeroes(matrix);

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

}
