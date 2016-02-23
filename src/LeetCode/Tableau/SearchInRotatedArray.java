package Tableau;

/**
 * Created by abhinit on 12/3/15.
 */
public class SearchInRotatedArray {
    private int[] input = null;

    SearchInRotatedArray(int[] input){
        this.input = input;
    }
    private int search(int begin,int end,int elem){
        int  mid= (begin + end)/2;
        int index = 0;

        if(elem==input[mid])
            return mid;
        else if(elem>input[mid] && mid>=0 && mid<input.length-1){
            index = search(mid+1,end,elem);
            return index;
        }
        else if(elem<=input[mid] && mid>0 && mid<input.length){
            index = search(begin,mid-1,elem);
            return index;
        }

        return -1;
    }

    public int process(int[] input,int elem){
        if(input==null)
            return -1;

        int pivot = 0;
        int index = 0;

        for(int i=0;i<input.length-1;i++){
            if(input[i]>input[i+1])
                pivot = i;
        }

        if(pivot>0){
            index = search(0,pivot,elem);
            if(index==-1){
                index = search(pivot+1,input.length-1,elem);
            }
        }

        return index;
    }

    public static void main(String[] args){

        SearchInRotatedArray instance = null;
        int[] input = {15,16,1,2,3,4,6,7,8};
        int elem = 1;

        instance = new SearchInRotatedArray(input);
        int index = instance.process(input,elem);
        System.out.println(index);
    }
}
