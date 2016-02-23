/**
 * Created by abhinit on 11/28/15.
 */
public class PancakeSorting {
    private static void flip(int arr[], int i)
    {
        int temp, start = 0;
        while (start < i)
        {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }

    public static void sort(int[] input){

        if(input==null)
            return;

        int len = input.length;
        int max = 0;
        int maxIndex = 0;

        for(int i=len;i>0;i--){

            max = 0;
            for(int j=0;j<i;j++){
                if(input[j]>max) {
                    max = input[j];
                    maxIndex = j;
                }
            }

            flip(input,maxIndex);
            flip(input,i-1);

        }
    }

    public static void main(String[] args){
        int[] input = {4,3,5,1};
        sort(input);

        for(int elem : input)
            System.out.println(elem);
    }

}
