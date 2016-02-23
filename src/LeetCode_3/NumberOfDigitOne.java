/**
 * Created by abhinit on 1/26/16.
 */
public class NumberOfDigitOne {
    private int getCount(int n){
        int count = 0;

        for(int i=1;i<=n;i++){
            count += getOneCount(i);
        }

        return count;
    }

    private int getOneCount(int n){
        int digit = 0,count = 0;

        for(int i=n;i!=0;i=(i/10)){
            digit  = i%10;
            if(digit==1) {
               // System.out.println(i);
                count += 1;
            }
        }

        return count;
    }

    public int countDigitOne(int n) {
        long ans = 0, k = 1, base = 10, m;
        while (k > 0 && n > 0) {
            k = n/base;
            m = n/(base/10)%10;
            ans += k*(base/10);
            if (m > 1)
                ans += base/10;
            else if (m == 1)
                ans += n%(base/10)+1;
            base *= 10;
        }
        return (int)ans;
    }
    /*https://leetcode.com/discuss/44314/accepted-c-solution-with-explanation*/
    public int countDigitOneNew(int n) {
        int res =0;
        int highn=n, lowc=1, lown=0;
        while(highn > 0){
            int curn = highn % 10;
             highn = highn / 10;
            if(1 == curn){
            //higher: 0~(highn-1);  lower:  0 ~ (lowc-1)
                res += highn * lowc;
            //higher: highn ~ highn;     lower:0~lown
                res += lown + 1;
            }else if(0 == curn){
            //curn < 1
            //higher: 0~(highn-1);  lower:  0 ~ (lowc-1)
                res += highn * lowc;
            }else{
            //curn > 1
                res += (highn + 1) * lowc;
            }
        //update lown and lowc
            lown = curn * lowc + lown;
            lowc = lowc * 10;
        }
        return res;
    }

    public static void main(String[] args){
        NumberOfDigitOne instance = new NumberOfDigitOne();
        int count = instance.getCount(21);
        System.out.println(count);
        count = instance.countDigitOne(21);
        System.out.println(count);
        count = instance.countDigitOneNew(21);
        System.out.println(count);

    }
}
