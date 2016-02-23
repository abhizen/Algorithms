/**
 * Created by abhinit on 8/17/15.
 */
    import java.math.*;


    public class FibonacciModified {

        private static String process(int A,int B,int N){
            BigDecimal[] series = new  BigDecimal[N];
            series[0] = new BigDecimal(A);
            series[1] = new BigDecimal(B);

            if(N==0)
                return series[0].toString();

            if(N==1)
                return series[1].toString();

            for(int key=2;key<N;key++){
                series[key] = series[key-1].multiply(series[key-1]).add(series[key-2]);
            }

            return series[N-1].toString();
        }
        public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            int A = Integer.parseInt(args[0]);
            int B = Integer.parseInt(args[1]);
            int N = Integer.parseInt(args[2]);

            String nthTerm = process(A,B,N);
            System.out.println(nthTerm);
        }

}
