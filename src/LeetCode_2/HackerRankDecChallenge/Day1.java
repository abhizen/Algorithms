package HackerRankDecChallenge;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 1/1/16.
 */
public class Day1 {


        public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scan =  new Scanner(System.in);
            List<String> list = new ArrayList();
            String input = null;

            while(scan.hasNext()){
                if(scan.hasNextInt()) {
                    list.add("Primitive : int");
                }
                else if(scan.hasNextDouble())
                    list.add("Primitive : double");
                else if(scan.hasNextFloat())
                    list.add("Primitive : float");
                else if(scan.hasNextBoolean())
                    list.add("Primitive : boolean");
                else if(scan.hasNext("[\\'][A-Za-z][\\']"))
                    list.add("Primitive : char");
                else if(scan.hasNextLine()) {

                    list.add("Referenced : String");
                }
                else
                    break;
                input = scan.next();
            }

            for(String tuple : list){
                System.out.println(tuple);
            }

    }
}
