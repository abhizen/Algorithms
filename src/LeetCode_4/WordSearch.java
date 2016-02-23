import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhinit on 2/10/16.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        Map<Integer,Map<Integer,Boolean>> map = null;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                map = new HashMap();
                insertEntry(map,i,j,true);
                if(traverse(board,word,""+board[i][j],i,j,map)){
                    return true;
                }
                insertEntry(map,i,j,null);
            }
        }

        return false;
    }

    private void insertEntry(Map<Integer,Map<Integer,Boolean>> map,int i,int j,Boolean flag){
        Map<Integer,Boolean> entryMap = map.get(i);
        if(entryMap==null){
            entryMap = new HashMap();
            entryMap.put(j,flag);
            map.put(i,entryMap);
        }
        else{
            entryMap.put(j,flag);
            map.put(i,entryMap);
        }
    }

    public boolean traverse(char[][] board,String word,String subStr,int i,int j,Map<Integer,Map<Integer,Boolean>> map){

        if(subStr.length()==word.length()){
            if(word.equals(subStr))
                return true;
            else
                return false;
        }

        //North
        if(isValid(i-1,j,board.length,board[0].length) && ((map.get(i-1)!=null && map.get(i-1).get(j)==null) ||
                map.get(i-1)==null)){
            insertEntry(map,i-1,j,true);
            if(traverse(board,word,subStr+board[i-1][j],i-1,j,map))
                return true;
            insertEntry(map,i-1,j,null);
        }

        //South
        if(isValid(i+1,j,board.length,board[0].length) && ((map.get(i+1)!=null && map.get(i+1).get(j)==null) ||
                map.get(i+1)==null)){
            insertEntry(map,i+1,j,true);
            if(traverse(board,word,subStr+board[i+1][j],i+1,j,map))
                return true;
            insertEntry(map,i+1,j,null);
        }

        //East
        if(isValid(i,j-1,board.length,board[0].length) && ((map.get(i)!=null && map.get(i).get(j-1)==null) ||
                map.get(i)==null)){
            insertEntry(map,i,j-1,true);
            if(traverse(board,word,subStr+board[i][j-1],i,j-1,map))
                return true;
            insertEntry(map,i,j-1,null);
        }

        //West
        if(isValid(i,j+1,board.length,board[0].length) && ((map.get(i)!=null && map.get(i).get(j+1)==null) ||
                map.get(i)==null)){
            insertEntry(map, i, j + 1,true);
            if(traverse(board,word,subStr+board[i][j+1],i,j+1,map))
                return true;
            insertEntry(map, i, j + 1,null);
        }

        return false;
    }

    private boolean isValid(int i,int j,int dimx,int dimy){
        if(i>=0 && i<dimx && j>=0 && j<dimy)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        WordSearch instance = new WordSearch();
        char[][] board = {{'A','B','C','D','E'},{'T','S','R','Q','F'},{'M','N','O','P','G'},{'L','K','J','I','H'}};
        String word = "ABCDEFGHIJKL";
        if(instance.exist(board,word))
            System.out.println("found");
    }
}
