

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * Created by abhinit on 1/27/16.
 */
public class Knuth_Perm_Alg {
    public static void algorithmM(List<Integer> m)
    {
        m.add(0, 2);
        int n=m.size();
        List<Integer> a = new ArrayList<Integer>(Collections.nCopies(n, 0));
        while(true) {
            visit(false, a);
            int j = n - 1;
            while (a.get(j) == m.get(j) - 1) {
                a.set(j,0);
                --j;
            }
            if (j == 0) return;
            else {
                //a[j]++;
                //a.add(j,a.get(j)+1);
                a.set(j,a.get(j)+1);
            }
        }
    }
    private static void visit(boolean first,List<Integer> l)
    {
        int dt=first?0:1;
        for(int i=dt;i!=l.size(); ++i)
            System.out.print(l.get(i));
        System.out.println("");
    }
    public static void main(String[] args){
        List<Integer> m = new ArrayList<Integer>();
        int i = 0;
        Scanner scan = new Scanner(System.in);

        m.add(3);
        m.add(3);
        m.add(3);
        algorithmM(m);
    }
}
