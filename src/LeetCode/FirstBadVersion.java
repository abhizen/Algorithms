import java.util.HashMap;

/**
 * Created by abhinit on 11/27/15.
 */
public class FirstBadVersion {
    public static int firstBadVersion(int n) {

        int mid = (int)checkBadVersion(0,n-1);
        return mid;
    }

    private static long checkBadVersion(long begin,long end){
        long mid = (begin + end)/2;

        if(begin==end)
            return begin;
        else if(mid>0 && isBadVersion((int)mid) && !isBadVersion((int)mid-1))
            return mid;
        else if((int)mid==0 && isBadVersion((int)mid))
            return mid;

        if(mid>0 && isBadVersion((int)mid) && isBadVersion((int)mid-1))
            mid =   checkBadVersion(begin,mid-1);
        else if(!isBadVersion((int)mid))
            mid = checkBadVersion(mid+1,end);

        return mid;
    }

    private static boolean isBadVersion(int num){
        if(num>3)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        int mid = firstBadVersion(10);
        System.out.println(mid);

        HashMap<String,String> map = new HashMap<>();

    }
}
