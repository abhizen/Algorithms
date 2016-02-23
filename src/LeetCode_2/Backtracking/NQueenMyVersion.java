package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 12/28/15.
 */
public class NQueenMyVersion {
    int dimx = 0;
    int dimy = 0;

    public NQueenMyVersion(int dimx,int dimy){
        this.dimx = dimx;
        this.dimy = dimy;
    }

    public void process(){
        List<Integer> list = new ArrayList<Integer>();
        int index  = 0;

        if(establish(list,index)){

            for(int i=0;i<list.size();i++){

                for(int j=0;j<this.dimx;j++){

                    if(j==list.get(i))
                        System.out.print("1"+" ");
                    else
                        System.out.print(0 + " ");
                }
                System.out.println("");
            }
        }
        else
            System.out.println("Not possible");

    }

    public boolean establish(List<Integer> list,int index){


        list.add(index);

        if(list.size()==dimy)
            return true;

        if(find(list,0)){
            return true;
        }
        else {
            index = list.remove(list.size()-1);

            int i =index+1;
            while (i<dimx && list.size()<dimy){
                if(find(list,i))
                    return true;
                else if(!list.isEmpty())
                   i= list.remove(list.size()-1) + 1;
                else
                    return false;
            }
        }

        return false;
    }

    private boolean find(List<Integer> list,int index){

        int row = list.size();
        int col = 0;
        int flag = 0;

        for(int i=index;i<this.dimx;i++){

            col = i;
            flag = 0;

            for(int j=0;j<list.size();j++){

                if((list.get(j)==i) || (Math.abs(j-row)== Math.abs(i-list.get(j)))){
                    flag = 1;
                    break;
                }
            }

            if (flag==1)
                continue;
            else {
                if(establish(list,i))
                    return true;
                else
                    return false;
            }
        }

        return false;
    }

    public static void main(String[] args){
        NQueenMyVersion instance = new NQueenMyVersion(5,5);
        instance.process();
    }

}
