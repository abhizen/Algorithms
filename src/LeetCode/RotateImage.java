/**
 * Created by abhinit on 12/9/15.
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        int xLen = matrix[0].length;
        int yLen = matrix.length;
        int temp = 0;
        int count = 1;

        for(int i = 0;i<xLen;i++){
            for(int j = 0;j<count;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            count++;
        }

        for(int i = 0;i<xLen;i++){
            for(int j = 0;j<yLen/2;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][yLen - j-1];
                matrix[i][yLen - j-1] = temp;
            }
        }

    }

    public static void main(String[] args){
        int[][] matrix = {{1,1,1},{2,2,2},{3,3,3}};
        rotate(matrix);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
