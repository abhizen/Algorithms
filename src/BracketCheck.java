    import java.util.Scanner;
    import java.util.Stack;

/**
 * Created by abhinit on 9/27/15.
 */
public class BracketCheck {

    private static boolean process(String testCase){
        Stack charStack = getStack(testCase);
        Character stkElem = null;
        int openBracketCount = 0;
        int closeBracketCount = 0;
        int index = 0;

        while(!charStack.isEmpty()){
            stkElem = (Character)charStack.pop();
            if(index == 0 && stkElem=='(')
                return false;
            if(stkElem.equals('('))
                openBracketCount++;
            else if(stkElem.equals(')'))
                closeBracketCount++;

            index++;
        }

        if(openBracketCount==closeBracketCount)
            return true;
        else
            return false;
    }

    private static Stack getStack(String testCase){
        Character c = null;
        Stack charStack = new Stack();

        for(int i=0;i<testCase.length();i++){
            c = testCase.charAt(i);
            charStack.push(c);
        }

        return charStack;
    }

    public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int noOfTestCases = in.nextInt();
            String testcase = null;
            for(int i=0;i<noOfTestCases;i++){
                testcase = in.next();
                if(process(testcase))
                    System.out.println("Matching");
                else
                    System.out.println("Not Matching");
            }
    }
}
