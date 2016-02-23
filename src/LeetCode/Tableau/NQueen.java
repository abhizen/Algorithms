package Tableau;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by abhinit on 12/4/15.
 */
public class NQueen {


    public List<List<String>> solveNQueens(int n) {

        if(n==0)
            return null;

        List<List<String>>  solnList = process(n);
        return solnList;
    }

    private List<List<String>> process(int n){
        int[][] maze = new int[n][n];
        StringBuilder str = null;
        List<String> queenList = null;
        List<List<String>> solnList = new ArrayList();
        int count = 0;

        for(int i=0;i<n;i++){
            maze = new int[n][n];
            maze[i][0] = 1;
            checkPosition(i,0,n,maze);

            queenList = new ArrayList<String>();

            count = 0;
            for(int p=0;p<n;p++){
                str = new StringBuilder();
                for(int q=0;q<n;q++){
                    if(maze[p][q]==0)
                        str = str.append(".");
                    else {
                        str = str.append("Q");
                        count++;
                    }
                }

                    queenList.add(str.toString());
            }

            if(count==n)
                solnList.add(queenList);
        }

        HashMap<Integer,Integer> countMap = new HashMap<>();
        HashMap<Integer,Integer> map = (HashMap<Integer,Integer>)countMap.clone();


        return solnList;

    }

    private void checkPosition(int i,int j,int n,int[][] maze){
        int found = 0;

        for(int p=0;p<n;p++){
            for(int q=0;q<n;q++){

                found = 0;

                /*North east*/
                for(int x=p,y=q;x>=0 && y>=0;x--,y--){
                    if(maze[x][y]==1) {
                        found = 1;
                        break;
                    }
                }

                /*East*/
                if(found==0){
                    for(int x=q;x>=0;x--){
                        if(maze[p][x]==1) {
                            found = 1;
                            break;
                        }
                    }
                }


                /*West*/
                if(found==0){
                    for(int x=q;x<n;x++){
                        if(maze[p][x]==1) {
                            found = 1;
                            break;
                        }
                    }
                }

                /*North*/
                if(found==0){
                    for(int x=p;x>=0;x--){
                        if(maze[x][q]==1) {
                            found = 1;
                            break;
                        }
                    }
                }

                  /*South*/
                if(found==0){
                    for(int x=p;x<n;x++){
                        if(maze[x][q]==1) {
                            found = 1;
                            break;
                        }
                    }
                }

                /*South east*/
                if(found==0 && q<=n-1){
                    for(int x=p,y=q;x<n && y>=0;x++,y--){
                        if(maze[x][y]==1) {
                            found = 1;
                            break;
                        }
                    }
                }

                /*North west*/
                if(found==0){
                    for(int x=p,y=q;x>=0 && y<n;x--,y++){
                        if(maze[x][y]==1) {
                            found = 1;
                            break;
                        }
                    }
                }

                if(found==0){
                    maze[p][q]=1;
                }

            }
        }
    }

    public static void main(String[] args){
        NQueen instance = new NQueen();
        List<List<String>> list = instance.process(5);

        System.out.println("[");
        for(List<String> tuple : list){
            System.out.print("[");
            for(String elem : tuple ){
                System.out.print(elem + ",");
            }
            System.out.print("],");
        }
        System.out.println("]");

    }

}
