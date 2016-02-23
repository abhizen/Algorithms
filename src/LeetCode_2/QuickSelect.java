/**
 * Created by abhinit on 12/27/15.
 */
public class QuickSelect {
    public int partition(int[] nums,int p,int r){

        int x = nums[r];
        int i = p-1;
        int j = 0;
        int temp = 0;

        for(j=p;j<=r;j++) {

            if(nums[j]<x){
                i++;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }
        i++;
        temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
        return i;
    }

    public int select(int[] nums,int p,int r,int rank){
        int q = 0;
        int k = 0;

        if(p==r){
            return p;
        }

        swap(nums,p,r);
        q = partition(nums,p,r);
        k = (q-p+1);
        if(k==rank) return q;
        else if (rank<k) q = select(nums,p,q-1,rank);
        else if(rank>k) q= select(nums,q+1,r,rank-k);
        return q;
    }

    private void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args){
        int[] nums = {2,1};

        QuickSelect instance = new QuickSelect();
        int k = instance.select(nums,0,nums.length-1,1);
        System.out.println(nums[k]);
    }
}
