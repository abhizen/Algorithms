/**
 * Created by abhinit on 2/1/16.
 */
public class Maximal_Square {
    int dimx = 0;
    int dimy = 0;

    public int maximalSquare(char[][] matrix) {

        if(matrix==null || matrix.length==0)
            return 0;
         /*
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }*/

        if(matrix.length==1 && matrix[0].length==1 && matrix[0][0]=='1')
            return 1;

        if(matrix.length==1 && matrix[0].length==1 && matrix[0][0]=='0')
            return 0;

        dimx = matrix.length;
        dimy = matrix[0].length;
        int[][] matrixV = new int[dimx][dimy];
        int[][] matrixH = new int[dimx][dimy];
        int[][] matrixD = new int[dimx][dimy];

        //North
        for(int i=0;i<dimx;i++){
            for(int j=0;j<dimy;j++){

                if(matrix[i][j]!='1')
                    continue;
                //matrixV[i][j] = Character.getNumericValue(matrix[i][j]);

                if(matrixV[i][j]<Character.getNumericValue(matrix[i][j]))
                    matrixV[i][j] = Character.getNumericValue(matrix[i][j]);

                if(isValid(i-1,j) && matrix[i-1][j]=='1'){
                    if(matrixV[i-1][j]<Character.getNumericValue(matrix[i-1][j]))
                        matrixV[i-1][j] = Character.getNumericValue(matrix[i-1][j]);

                    matrixV[i][j] += matrixV[i-1][j];
                }
            }
        }

        //East
        for(int i=0;i<dimx;i++){
            for(int j=dimy-1;j>=0;j--){

                if(matrix[i][j]!='1')
                    continue;

                if(matrixH[i][j]<Character.getNumericValue(matrix[i][j]))
                    matrixH[i][j] = Character.getNumericValue(matrix[i][j]);

                //matrixH[i][j] = Character.getNumericValue(matrix[i][j]);
                if(isValid(i,j+1) && matrix[i][j+1]=='1'){
                    if(matrixH[i][j+1]<Character.getNumericValue(matrix[i][j+1]))
                        matrixH[i][j+1] = Character.getNumericValue(matrix[i][j+1]);

                    matrixH[i][j] += matrixH[i][j+1];
                }
            }
        }

        //North East
        for(int i=0;i<dimx;i++){
            for(int j=dimy-1;j>=0;j--){

                if(matrix[i][j]!='1')
                    continue;

                if(matrixD[i][j]<Character.getNumericValue(matrix[i][j]))
                    matrixD[i][j] = Character.getNumericValue(matrix[i][j]);

                //matrixD[i][j] = Character.getNumericValue(matrix[i][j]);
                if(isValid(i-1,j+1) && matrix[i-1][j+1]=='1'){

                    if(matrixD[i-1][j+1] <Character.getNumericValue(matrix[i-1][j+1] ))
                        matrixD[i-1][j+1]  = Character.getNumericValue(matrix[i-1][j+1] );
                    matrixD[i][j] += matrixD[i-1][j+1];
                }
            }
        }

        int min = 0;
        int max = 0;
        //find optimum
        for(int i=0;i<dimx;i++){
            for(int j=0;j<dimy;j++){
                min = Math.min(Math.min(matrixH[i][j],matrixD[i][j]),matrixV[i][j]);
                max = Math.max(min,max);
            }
        }

        return max*max;
    }

    private boolean isValid(int i,int j){
        if(i>=0 && i<dimx && j>=0 && j<dimy)
            return true;
        else
            return false;
    }

    public int maximalSquare_correct(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;

        if(matrix.length==1 && matrix[0].length==1 && matrix[0][0]=='1')
            return 1;

        if(matrix.length==1 && matrix[0].length==1 && matrix[0][0]=='0')
            return 0;

        dimx = matrix.length;
        dimy = matrix[0].length;
        int[][] matrixV = new int[dimx][dimy];
        int max = 0;

        for(int i=0;i<dimx;i++){
          matrixV[i][dimy-1] = matrix[i][dimy-1] - '0';
          max = Math.max(max,matrixV[i][dimy-1]);
        }

        for(int i=0;i<dimy-1;i++){
            matrixV[0][i] = matrix[0][i] - '0';
            max = Math.max(max,matrixV[0][i]);
        }

        for (int i=1;i<dimx;i++){
            for(int j=dimy-2;j>=0;j--){
                matrixV[i][j] = matrix[i][j]=='0'?0:Math.min(Math.min(matrixV[i-1][j],matrixV[i][j+1]),matrixV[i-1][j+1])+1;
                int area = matrixV[i][j]*matrixV[i][j];
                max = Math.max(max,area);
            }
        }

        return max;
    }

    public static void main(String[] args){
        char[][] matrix = {{'0','1','1'},{'0','1','1'}};
                /*{{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'}
        ,{'1','1','1','0'},{'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}};*/
        Maximal_Square instance = new Maximal_Square();
        int max = instance.maximalSquare_correct(matrix);
        System.out.println(max);
    }
}
