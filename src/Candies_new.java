import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by abhinit on 8/23/15.
 */
public class Candies_new {

    private static BigInteger getGreaterStateValue(BigInteger state,
                                         BigInteger nextState,
                                         BigInteger stateRank,
                                         BigInteger nextStateRank){

        BigInteger existingState = nextState;
        BigInteger newState = null;

        if(nextStateRank.compareTo(stateRank)>0){
            newState = ((state==null)?BigInteger.ZERO:state).add(BigInteger.ONE);
                //Taking minimum of existing and new calculated state
                if(existingState==null)
                    return newState;
                else
                    return existingState.compareTo(newState)>0?
                        newState:existingState;
        }

        return existingState;
    }

    private static BigInteger getSmallerStateValue(BigInteger state,
                                            BigInteger nextState,
                                            BigInteger stateRank,
                                            BigInteger nextStateRank){
        BigInteger existingState = nextState;
        BigInteger newState = null;


        try {
            if (nextStateRank.compareTo(stateRank) <= 0) {

                newState = ((state==null)?BigInteger.ZERO:state).subtract(BigInteger.ONE);

                if (existingState == null)
                    return newState.compareTo(BigInteger.ZERO)>0?newState:null;
                else if (newState.compareTo(BigInteger.ZERO) > 0 &&
                        existingState.compareTo(BigInteger.ZERO) <= 0) {
                    return newState;
                } else if (newState.compareTo(BigInteger.ZERO) <= 0 &&
                        existingState.compareTo(BigInteger.ZERO) > 0) {
                    return existingState;
                } else if (existingState.compareTo(BigInteger.ZERO) > 0 &&
                        newState.compareTo(BigInteger.ZERO) > 0 &&
                        existingState.compareTo((state==null)?BigInteger.ZERO:state) < 0
                        ) {
                    return existingState.compareTo(newState) > 0 ?
                            newState : existingState;
                }
            }
        }
        catch(Exception ex){
            System.out.println("left "+state);
            System.out.println("right "+nextState);
            System.out.println("rankLeft "+stateRank);
            System.out.println("rankRight "+nextStateRank);
            ex.printStackTrace();
            System.exit(1);
        }
        return existingState;
    }

    private static BigInteger getState(BigInteger state, //State
                                       BigInteger nextState, //Next State
                                       BigInteger curRank, //Current Rank
                                       BigInteger nextRank){ //Next Rank

        BigInteger newState = null;

        return ((newState = getGreaterStateValue(state,
                nextState,
                curRank,
                nextRank))!=null)?
                newState:
                (newState = getSmallerStateValue(state,
                        nextState,
                        curRank,
                        nextRank));


    }

    private static BigInteger[] init(BigInteger[] ranks){
        int index = 0;
        BigInteger[] states = new BigInteger[ranks.length];

        for(BigInteger rank : ranks){

            if(index==0 &&
                    rank.compareTo(ranks[index + 1])<0){
                states[index] = BigInteger.ONE;
            }
            else if(index>0 &&
                    index<ranks.length-1 &&
                    ranks[index-1].compareTo(rank)>=0 &&
                    ranks[index+1].compareTo(rank)>0){
                states[index] = BigInteger.ONE;
            }
            else if(index==ranks.length-1 &&
                    ranks[index-1].compareTo(rank)>=0){
                states[index] = BigInteger.ONE;
            }

            index++;
        }

        return states;
    }

    private static ArrayList<Integer> getRootIndex(BigInteger[] states){
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        int index = 0;

        for(BigInteger state : states){
            if(state!=null && state.compareTo(BigInteger.ONE)==0)
                indexList.add(index);

            index++;
        }

        return indexList;
    }

    private static BigInteger getSum(BigInteger[] states){
        BigInteger sumStates = BigInteger.ZERO;
        int count = 0;

        try {
            for (BigInteger state : states) {
                sumStates = sumStates.add(state);
                count++;
            }
        }
        catch (Exception ex){
            System.out.println("Count :"+count);
            ex.printStackTrace();
        }
        return sumStates;
    }
    private static  boolean isValid(BigInteger[] states,
                                    BigInteger[] ranks,
                                    int index,
                                    BigInteger state){

        BigInteger leftRank = index>0?ranks[index-1]:null;
        BigInteger rightRank = index<ranks.length-1?ranks[index+1]:null;
        BigInteger rank = ranks[index];
        BigInteger leftState = index>0?states[index-1]:null;
        BigInteger rightState = index<ranks.length-1?states[index+1]:null;
        boolean leftCompare = false;
        boolean rightCompare = false;

        if(state!=null && leftRank!=null && leftState!=null) {
            if(leftRank.compareTo(rank)>0){
                leftCompare = leftState.compareTo(state)>0?true:false;
            }
            else if(leftRank.compareTo(rank)==0){
                leftCompare = leftState.compareTo(state)<0?true:false;
            }
            else {
                leftCompare = leftState.compareTo(state)<0 ? true : false;
            }

        }
        else
            leftCompare = true;

        if(state!=null && rightRank!=null && rightState!=null){
            if(rightRank.compareTo(rank)>0){
                rightCompare = rightState.compareTo(state)>0?true:false;
            }
            else if(rightRank.compareTo(rank)==0){
                rightCompare = rightState.compareTo(state)<0?true:false;
            }
            else {
                rightCompare = rightState.compareTo(state)<0 ? true : false;
            }
        }
        else
            rightCompare = true;


        return (leftCompare && rightCompare);

    }
    private static String process(BigInteger[] ranks){
        BigInteger[] states = new BigInteger[ranks.length];
        ArrayList<Integer> indexes = null;
        BigInteger state  = null;
        int rankIndex = 0;

        /*initialize roots*/
        states = init(ranks);
        indexes = getRootIndex(states);


        /*iterate over array*/
        for( Integer index : indexes){
            for(int i =0;i<ranks.length-1;i++){

                if(index-i-1>=0 && index-i<=ranks.length-1) {
                    state = getState(states[index - i], //State
                            states[index - i - 1],      //Next State
                            ranks[index - i],           //Current state rank
                            ranks[index - i - 1]);      //Next state rank
                    if(isValid(states,ranks,index-i-1,state))
                        states[index - i-1] = state;
                }

                if(index+i>=0 && index+i<ranks.length-1) {
                    state = (getState(states[index + i], //State
                            states[index + i + 1],       //Next State
                            ranks[index + i],            //Current state rank
                            ranks[index + i + 1]));      //Next state rank
                    if(isValid(states,ranks,index + i+1,state))
                        states[index + i+1] = state;
                }

            }
        }

        return getSum(states).toString();

    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int noOfChildren = in.nextInt();
        BigInteger[] ranks = new BigInteger[noOfChildren];

        for(int key=0;key<ranks.length;key++){
            ranks[key] = BigInteger.valueOf(in.nextInt());
        }

        String noOfCandies = process(ranks);
        System.out.println(noOfCandies);
    }
}
