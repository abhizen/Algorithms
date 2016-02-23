import Graph.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhinit on 1/19/16.
 */
public class Boggle_game {
    int dim = 3;
    char[][] board = new char[dim][dim];
    Trie trie = new Trie();


    public Boggle_game(){
        trie.insert("aunt");
        trie.insert("pun");
        trie.insert("sun");
        trie.insert("run");
        trie.insert("bun");
        trie.insert("fun");

        board[0][0] = 'a';
        board[0][1] = 'p';
        board[0][2] = 'r';
        board[1][0] = 's';
        board[1][1] = 'u';
        board[1][2] = 'n';
        board[2][0] = 'b';
        board[2][1] = 'f';
        board[2][2] = 't';
    }

    private boolean getCoord(int i,int j,Map<Integer,Map<Integer,Boolean>> map){
        if(!(i>=0 && i<dim))
            return false;
        if(!(j>=0 && j<dim))
            return false;
        if(map.get(i)!=null && map.get(i).get(j)!=null)
            return false;
        return true;
    }

    private void process(){
        Map<Integer,Map<Integer,Boolean>> map = null;
        String token = null;

        for(int i=0;i<dim;i++){
            for (int j=0;j<dim;j++){
                map = new HashMap();
                token = getString(i,j,map,new Character(board[i][j]).toString());
                if(token!=null)
                    System.out.println(token);
            }
        }
    }

    private String getString(int i,int j, Map<Integer,Map<Integer,Boolean>> map,String token){
        Map<Integer,Boolean> tuple = map.get(i);
        String result = null;

        if(trie.search(token))
            return token;
        if(!trie.startsWith(token))
            return null;


        if(tuple!=null){
            tuple.put(j,true);
        }
        else {
            tuple = new HashMap<Integer, Boolean>();
            tuple.put(j,true);
            map.put(i,tuple);
        }


        //top
        if(getCoord(i-1,j,map)){
            result =getString(i-1,j,map,token+board[i-1][j]);
            if(result!=null)
                return result;
        }

        //bottom
        if(getCoord(i+1,j,map)){
            result = getString(i+1,j,map,token+board[i+1][j]);
            if(result!=null)
                return result;
        }

        //left
        if(getCoord(i,j-1,map)){
            result= getString(i,j-1,map,token+board[i][j-1]);
            if(result!=null)
                return result;
        }


        //right
        if(getCoord(i,j+1,map)){
            result= getString(i,j+1,map,token+board[i][j+1]);
            if(result!=null)
                return result;
        }


        //top left
        if(getCoord(i-1,j-1,map)){
            result= getString(i-1,j-1,map,token+board[i-1][j-1]);
            if(result!=null)
                return result;
        }

        //top right
        if(getCoord(i-1,j+1,map)){
            result= getString(i-1,j+1,map,token+board[i-1][j+1]);
            if(result!=null)
                return result;
        }


        //bottom left
        if(getCoord(i+1,j-1,map)){
            result= getString(i+1,j-1,map,token+board[i+1][j-1]);
            if(result!=null)
                return result;
        }


        //bottom right
        if(getCoord(i+1,j+1,map)){
            result= getString(i+1,j+1,map,token+board[i+1][j+1]);
            if(result!=null)
                return result;
        }

        return null;
    }

    public static void main(String [] args){
        Boggle_game inst = new Boggle_game();
         inst.process();

    }

}
