/**
 * Created by abhinit on 1/16/16.
 */
public class BestTimeToBuyStock {
    private int[][] memoize = null;

    public int maxProfit(int[] prices) {
        int stocks = 0;

        memoize = new int[prices.length][prices.length];
        int amt1 = process_withdp(0,stocks,0,prices);
        return amt1;
    }

    private int process(int index,int stocks,int amount,int[] prices){

        if(index==prices.length)
            return amount;

        int price = prices[index];
        int stock= 0;

        //bought
        int amt1 = Math.max(process(index + 1, stocks+1, amount - price, prices),amount); //sold no stocks


        //bought & sold
        amt1 = Math.max(process(index + 1, stocks, amount, prices), amt1); //sold no stocks


        //not bought but sold a stock
        if(stocks>0) {
            amt1 = Math.max(process(index + 1, stocks-1, amount + price, prices), amt1);

        }

        return amt1;
    }


    private int process_withdp(int index,int stocks,int amount,int[] prices){
        int amt1 = 0;

        if(index==prices.length)
            return amount;

        int price = prices[index];
        int stock= 0;

        //bought
        if(memoize[index+1]!=null && memoize[index+1][stocks+1]!=0){
            amt1 = memoize[index+1][stocks+1];
        }
        else{
            amt1 = Math.max(process(index + 1, stocks+1, amount - price, prices),amount); //sold no stocks
        }

        //bought & sold
        /*if(memoize[index+1]!=null && memoize[index+1][stocks+1]!=0){
            amt1 = memoize[index+1][stocks+1];
        }
        else{
            amt1 = Math.max(process(index + 1, stocks, amount, prices), amt1); //sold no stocks
        }*/


        //not bought but sold a stock
        if(stocks>0) {
            if(memoize[index+1]!=null && memoize[index+1][stocks+1]!=0){
                amt1 = memoize[index+1][stocks-1];
            }
            else
                amt1 = Math.max(process(index + 1, stocks-1, amount + price, prices), amt1);

        }

        if(memoize[index+1]!=null && memoize[index+1][stocks+1]!=0)
            memoize[index+1][stocks+1] = amt1;
        else{
            memoize[index+1] = new int[prices.length];
            memoize[index+1][stocks+1] = amt1;
        }


        return amt1;
    }

    public static void main(String[] args){
        BestTimeToBuyStock instance = new BestTimeToBuyStock();
        int[] nums = {1,2};
        int amt = instance.maxProfit(nums);
        System.out.println("Profit"+amt);
    }
}
