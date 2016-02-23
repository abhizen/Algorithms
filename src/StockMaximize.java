import java.util.Scanner;

/**
 * Created by abhinit on 10/3/15.
 */
public class StockMaximize {
    private static int[] input = null;
    private static Integer[][][] memoization = null;

    private static int process(int[] inputArr){
        input = inputArr;
        int sum = 1;

        for(int elem : input){
            sum = sum * elem;
        }
        memoization = new Integer[inputArr.length+1][inputArr.length+1][sum+1];

        int max = getProfit(0,0,0);

        //getProfit(0,0,0,0,input,0);

        return max;
    }

    private static int getProfit(
                                 int stock, int currentProfit,
                                 int index){

            int maxProfit = 0;
            int profit = 0;

            if (index == input.length)
                return currentProfit;

            for (int stockBought = 0; stockBought <= 1; stockBought++) {
                for (int stockSold = 0; stockSold <= stock; stockSold++) {

                    if (memoization[stock - stockSold + stockBought][index + 1]
                            [currentProfit +
                            (stockSold * input[index] - stockBought * input[index])]
                             == null) {
                        memoization[stock - stockSold + stockBought][currentProfit +
                                (stockSold * input[index] - stockBought * input[index])]
                                [index + 1] = getProfit(
                                stock - stockSold + stockBought,
                                currentProfit +
                                        (stockSold * input[index] - stockBought * input[index]),
                                index + 1);
                    }

                    profit = memoization[stock - stockSold + stockBought][currentProfit +
                            (stockSold * input[index] - stockBought * input[index])]
                            [index + 1];

                /*profit = getProfit(
                        stock-stockSold+stockBought,
                        currentProfit +
                                (stockSold * input[index] - stockBought * input[index]),
                        index+1);*/
                /*System.out.println("Index: " + (index + 1) +
                        " stock bought: "+stockBought +
                        " stock sold:   "+stockSold +
                        " stock: "+(stock-stockSold+stockBought)+
                        " Profit : "+profit);*/

                    if (maxProfit < profit)
                        maxProfit = profit;
                }
            }


        return maxProfit;
    }


    private static int getProfit(int bought,int sold,
                                 int stock, int currentProfit,
                                 int[] input,
                                 int index){
        int maxProfit = 0;
        int profit = 0;

        if(index>0) {
            currentProfit = currentProfit +
                    (sold * input[index - 1] - bought * input[index - 1]);

        }

        if(index==input.length)
            return currentProfit;

        for(int stockBought = 0;stockBought<=1;stockBought++){
            for(int stockSold = 0;stockSold<=stock;stockSold++){

                profit = getProfit(stockBought,
                        stockSold,
                        stock-stockSold+stockBought,
                        currentProfit,
                        input,
                        index+1);
                /*System.out.println("Index: " + (index + 1) +
                        " stock bought: "+stockBought +
                        " stock sold:   "+stockSold +
                        " stock: "+(stock-stockSold+stockBought)+
                        " Profit : "+profit);*/

                if(maxProfit < profit)
                    maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int noOfTestCases = in.nextInt();
        int dimension = 0;
        int[] input = null;
        int[] soln = new int[noOfTestCases];

        for(int i=0;i<noOfTestCases;i++){
            dimension = in.nextInt();
            input = new int[dimension];

            for(int j=0;j<dimension;j++){
                input[j] = in.nextInt();
            }

            soln[i] = process(input);
        }

        for(int output : soln){
            System.out.println(output);
        }
    }
}
