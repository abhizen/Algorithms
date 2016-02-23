/**
 * Created by abhinit on 11/9/15.
 */
import java.util.Scanner;
import java.util.Stack;

public class NewBracketMatch {
    private static boolean process(String testCase){
        Stack charStack = getStack(testCase);
        Character stkElem = null;
        int openBracketCount = 0;
        int closeBracketCount = 0;
        int curlyopenBracketCount = 0;
        int curlycloseBracketCount = 0;
        int sqopenBracketCount = 0;
        int sqcloseBracketCount = 0;
        int angleopenBracketCount = 0;
        int anglecloseBracketCount = 0;
        int index = 0;

        while(!charStack.isEmpty()){
            stkElem = (Character)charStack.pop();
            if(index == 0 && (stkElem=='(' || stkElem=='{' || stkElem=='[' || stkElem=='<'))
                return false;
            if(stkElem.equals('('))
                openBracketCount++;
            else if(stkElem.equals('{') )
                curlyopenBracketCount++;
            else if(stkElem.equals('['))
                sqopenBracketCount++;
            else if(stkElem.equals('<'))
                angleopenBracketCount++;
            else if(stkElem.equals(')'))
                closeBracketCount++;
            else if(stkElem.equals('}') )
                curlycloseBracketCount++;
            else if(stkElem.equals(']'))
                sqcloseBracketCount++;
            else if(stkElem.equals('>'))
                anglecloseBracketCount++;

            index++;
        }

        if(openBracketCount==closeBracketCount && curlycloseBracketCount==curlyopenBracketCount
                && sqopenBracketCount==sqcloseBracketCount && angleopenBracketCount== anglecloseBracketCount)
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
    public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        String testcase = in.next();
        if(process(testcase))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
