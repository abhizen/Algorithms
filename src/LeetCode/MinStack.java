import java.util.Stack;

/**
 * Created by abhinit on 11/27/15.
 */
public class MinStack {
    Stack<Integer> stack = new Stack();
    int min = 0;
    int first = 0;

    public void push(int x) {
        stack.push(x);
        if(first==1 && x<min)
            min = x;
        else if(first==0){
            min = x;
            first = 1;
        }
    }

    public void pop() {
        int elem = 0;
        if(!stack.isEmpty())
            elem = stack.pop();
    }

    public int top() {
        if(!stack.isEmpty())
            return stack.peek();
        else
            return -1;
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args){
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
