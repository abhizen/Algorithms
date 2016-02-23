/**
 * Created by abhinit on 12/6/15.
 */
public class UniqueBinarySearchTrees {
    public static int numTrees(int n) {
        int[] count = new int[n+1];

        count[0] = 1;
        count[1] = 1;

        for(int i=2;i<=n;i++){

            for(int j=0;j<=i-1;j++){
                count[i] = count[i] + count[j]*count[i-j-1];
            }
        }


        return count[n];
    }

    public static void main(String[] args){
        int count = numTrees(3);
        System.out.println(count);
    }

}
