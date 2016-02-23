/**
 * Created by abhinit on 10/30/15.
 */
import java.util.Scanner;

public class CountingTriangles {


        public static void process(int[] A){
            int sum = 0;
            int third = 0;
            int acute = 0;
            int right = 0;
            int obtuse= 0;
            int angle = 0;

            for(int i=0;i<A.length-2;i++){
                for(int j=i+1;j<A.length-1;j++){
                    sum = A[i] + A[j];
                    third = findThird(A,j+1,sum);

                    if(j==A.length-1)
                        break;

                    for(int p=j+1;p<=third;p++){

                        if(A[p]<sum){
                            angle = checkAngle(A[i],A[j],A[p]);
                            if(angle==0)
                                acute++;
                            else if(angle==1)
                                right++;
                            else if(angle==2)
                                obtuse++;

                            System.out.println("triangle "+A[i]+" "+A[j]+" "+A[p]
                                    +" "+angle+" "+A[third]);
                        }
                        else{
                            break;
                        }

                    }


                }
            }

            System.out.println(acute+" "+right+" "+obtuse);
        }

        public static int checkAngle(int a,int b,int c){
            int sum = (a*a) + (b*b);
            int thirdSqr = c*c;

            if(sum>thirdSqr)
                return 0;
            else if(sum==thirdSqr)
                return 1;
            else
                return 2;
        }


        public static int findThird(int[] A, int i,int sumOfSides){
            int mid = (i + A.length-1)/2;
            int upper = A.length-1;
            int lower = i;
            int finalMid = 0;

            mid = (lower + upper)/2;
            while(lower<=mid && mid<=A.length-1){

                if(A[mid]>sumOfSides){
                    upper = mid-1;
                    lower = i;
                    return mid;
                }
                else{
                    lower = mid + 1;
                    upper = A.length-1;
                    mid = (lower + upper)/2;
                }
            }

            return mid;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            int A[] = new int[N];
            for(int A_i=0; A_i < N; A_i++){
                A[A_i] = in.nextInt();
            }
            process(A);
            // your code goes here
        }

}
