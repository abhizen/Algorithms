/**
 * Created by abhinit on 2/11/16.
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {

        int[] arr = sort(nums,0,nums.length-1,true);
        for(int i=0;i<arr.length;i++){
            nums[i] = arr[i];
        }
    }

    private int[] sort(int[] nums,int i1,int j1,boolean flag){

        if(j1-i1+1<=2){
            int q = 0;
            int[] aux0 = new int[j1-i1+1];
            for(int i=i1;i<=j1;i++){
                aux0[q]= nums[i];
                q++;
            }
            return aux0;
        }


        int[] right = sort(nums,i1,(i1+j1)/2,true);

        int[] left = sort(nums,(i1+j1)/2+1,j1,true);

        int[] aux = new int[j1-i1+1];

        //merge
        int i=0,j=0,p=0;
        while(i<right.length || j<left.length){

            if(flag){

                if(i<right.length && j<left.length){
                    if(right[i]<=left[j]){
                        aux[p] = right[i];
                        i++;
                        p++;
                    }
                    else{
                        aux[p] = left[j];
                        j++;
                        p++;
                    }

                }
                else if(i<right.length){
                    aux[p] = right[i];
                    i++;
                    p++;
                }
                else if(j<left.length){
                    aux[p] = left[j];
                    j++;
                    p++;
                }
            }
            else{


                if(i<right.length && j<left.length){
                    if(right[i]>left[j]){
                        aux[p] = right[i];
                        i++;
                        p++;
                    }
                    else{
                        aux[p] = left[j];
                        j++;
                        p++;
                    }
                }
                else if(i<right.length){

                    aux[p] = right[i];
                    i++;
                    p++;
                }
                else if(j<left.length){
                    aux[p] = left[j];
                    j++;
                    p++;
                }

            }

            if(flag) flag = false;
            else if(!flag) flag = true;
        }

        return aux;
    }
    public void wiggleSort_2(int[] nums) {
        int i=-1,j=0,k=0;
        int temp;
        boolean flag = false;

        while(i<nums.length-1){

            i++;
            //swap
            temp = nums[i];

            if(flag && j<nums.length){
                nums[i] = nums[j];
                nums[j] = temp;
            }
            else if(k<nums.length){
                nums[i] = nums[k];
                nums[k] = temp;
            }
            //move pointers

            /*j=i+1;
            int p = i+1;
            while(p<nums.length){
                if(nums[i]<nums[p])
                    j=p;
                p++;
            }

            p = i+1;
            while(p<nums.length){
                if(nums[i]>nums[p])
                    k=p;
                p++;
            }*/
            j=nums.length-1;
            while (j>i && nums[i]>nums[j])
                j--;

            k=nums.length-1;
            while (k>i && nums[i]<nums[k])
                k--;


            if(flag) flag=false;
            else if(!flag) flag = true;

        }

    }

    public static void main(String[] args){
        WiggleSort sort = new WiggleSort();
        //int[] nums = {1,5,1,1,6,4};
        int[] nums = {1,3,2,2,3,1};
        sort.wiggleSort_2(nums);
        for(int elem : nums){
            System.out.print(elem+" ");
        }
    }
}
