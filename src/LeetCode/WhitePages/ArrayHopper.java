package WhitePages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhinit on 12/13/15.
 */
public class ArrayHopper {
    public ArrayList<Integer> route = null;

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner scan = new Scanner(System.in);
        String elem = null;
        List<Integer> inputList = new ArrayList();


        try {

            while (true) {
                elem = scan.nextLine();
                if(elem==null || elem.length()==0)
                    break;
                inputList.add(Integer.parseInt(elem));
            }


            int length = inputList.size();
            int[] input = new int[length];

            for (int i = 0; i < length; i++) {
                input[i] = inputList.get(i);
            }

            ArrayHopper instance = new ArrayHopper();

            int count = instance.countSteps(input);

            if (count > -1 && instance.route != null) {
                StringBuilder route = new StringBuilder();

                for (Integer step : instance.route) {
                    route.append(step);
                    route.append(",");
                }

                route.append("out");
                System.out.println(route.toString());
            } else
                System.out.println("failure");
        }
        catch (Exception e){
            System.out.println("failure");
        }
    }

    private  int countSteps(int[] input){
        int destination = 0;
        int count = 1;

        if(input==null)
            return -1;

        if(input[0]==0)
            return -1;

        route = new ArrayList<>();



        destination = input[0];
        int maxDestination = 0;
        int j = 0;
        int nextPoint = 0;

        route.add(0);

        int i = 0;
        destination = input[0];
        while (i<input.length){


            maxDestination = destination;

            if(destination==(input.length-1)) {
                break;
            }
            else if(destination>(input.length-1)) {
                break;
            }

            for(j=i+1;j<=maxDestination;j++) {
                if (input[j] != 0 && (j + input[j]) > destination) {
                    destination = j + input[j];
                    nextPoint = j;
                } else if (input[j] == 0 && maxDestination <= j) {
                    break;
                }
            }

            if (destination<=maxDestination && input[j] == 0)
                return -1;

            i = nextPoint;
            route.add(i);

            if(destination==(input.length-1)) {
                route.add(destination);
                break;
            }
            else if(destination>(input.length-1)) {
                break;
            }
        }

        if(destination>=(input.length-1))
            return count;
        else
            return -1;
    }
}
