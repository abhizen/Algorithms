package LinkedLists;

/**
 * Created by abhinit on 12/13/15.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int mid = (0+matrix[0].length-1)/2;

        mid  = getRowNum(matrix,0,matrix.length-1,mid,target);

        if(checkNum(matrix,0,matrix[0].length-1,target,mid)){
            return true;
        }
        else if(mid<matrix.length-1 && checkNum(matrix,0,matrix[0].length-1,target,mid+1)){
            return true;
        }
        else if(mid>0 && checkNum(matrix,0,matrix[0].length-1,target,mid-1)){
            return true;
        }
        else
            return false;
    }

    private int getRowNum(int[][] matrix, int begin, int end, int mid,int elem){

        if(begin>end)
            return mid;

        mid = (begin+end)/2;
        int col = matrix[0].length-1;

        if(matrix[mid][col]==elem)
            return mid;
        else if(matrix[mid][col]<=elem)
            mid = getRowNum(matrix,mid+1,end,mid,elem);
        else if(matrix[mid][col]>elem)
            mid = getRowNum(matrix,begin,mid-1,mid,elem);

        return mid;
    }

    private boolean checkNum(int[][] matrix,int begin,int end,int elem,int rowNum){
        if(begin>end)
            return false;

        boolean result = false;
        int mid = (begin+end)/2;

        if(matrix[rowNum][mid]==elem)
            return true;
        else if(matrix[rowNum][mid]<elem)
           result = checkNum(matrix, mid + 1, end, elem,rowNum);
        else if(matrix[rowNum][mid]>elem)
          result = checkNum(matrix,begin,mid-1,elem,rowNum);

        return result;
    }
    public static void main(String[] args){
        Search2DMatrix instance = new Search2DMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        if(instance.searchMatrix(matrix,31))
            System.out.println("Got it");
        else
            System.out.println("Not found");
    }
}
