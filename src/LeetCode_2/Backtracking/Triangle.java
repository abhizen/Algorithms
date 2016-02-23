package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 12/29/15.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {


        int offset = triangle.size()-1;
        List<Integer> tuple = triangle.get(0);
        int xcoord = offset;
        int sum = tuple.get(0);

        sum = getMinimum(triangle,1,xcoord,sum,offset-1);

        return sum;
    }

    private int getMinimum(List<List<Integer>> triangle,int index,int xcoord,int sum,int offset) {

        if(index==triangle.size())
            return sum;

        int newSum = 0;
        int temp = 0;
        int coord = offset;
        int flag =0;
        List<Integer> tuple = triangle.get(index);

        for(int i=0;i<tuple.size();i++){

            if(i==0 && Math.abs(xcoord-coord)==1){
                temp = getMinimum(triangle,index+1,coord,sum+tuple.get(i),offset-1);
            }
            else if(Math.abs(xcoord-coord)==1){
                temp = getMinimum(triangle,index+1,coord,sum+tuple.get(i),offset-1);
            }

            if(flag==0 && Math.abs(xcoord-coord)==1) {
                newSum = temp;
                flag=1;
            }
            else if(Math.abs(xcoord-coord)==1)
                newSum = Math.min(newSum,temp);

            coord = coord + 2;
        }

        return newSum;
    }

    public static void main(String[] args){
        Triangle instance = new Triangle();
        List<List<Integer>> nums = new ArrayList<List<Integer>>();
        List<Integer> tuple = new ArrayList<Integer>();
        tuple.add(2);
        nums.add(tuple);
       tuple = new ArrayList<Integer>();
        tuple.add(3);
        tuple.add(4);
        nums.add(tuple);
        tuple = new ArrayList<Integer>();
        tuple.add(6);
        tuple.add(5);
        tuple.add(7);
        nums.add(tuple);
        int result = instance.minimumTotal(nums);
        System.out.println("Result: "+ result);
    }
}
