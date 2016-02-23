import java.util.ArrayList;

/**
 * Created by abhinit on 1/25/16.
 */
public class SuperUglyNumbers {
    public  static int nthSuperUglyNumber(int n, int[] primes) {

        int[] i = new int[primes.length];
        int[] x = new int[primes.length];
        int min = 0;

        if(n<0)
            return 0;

        ArrayList<Integer> list = new ArrayList();
        list.add(1);

        for(int p=0;p<primes.length;p++){
            x[p] = list.get(i[p])*primes[p];
        }
        min = x[0];
        //list.add(min);
        int p=1;
        for(p=1;p<n;p++){


            for(int q=0;q<x.length;q++){
                if(q==0)
                    min = x[q];
                else
                    min = Math.min(min,x[q]);
            }

            list.add(min);

            for(int j=0;j<primes.length;j++){
                if(x[j]==min){
                    i[j]++;
                    x[j] = list.get(i[j])*primes[j];
                }
            }
        }

        return list.get(list.size()-1);

    }

    public static void  main(String[] args){
        int n = 3;
        int[] primes = {2,3,5};
        System.out.println(nthSuperUglyNumber(n,primes));
    }
}
