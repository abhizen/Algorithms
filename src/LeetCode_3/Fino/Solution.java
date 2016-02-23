package Fino;


import java.util.*;

/**
 * Created by abhinit on 1/19/16.
 */
public class Solution {
    int dimx = 0;
    int dimy = 0;
    char[][] board = null;
    TrieWidMap trie = new TrieWidMap();
    String[] dictionary = null;

    Solution(){

    }

    Solution(char[][] board,String[] dictionary){
        this.board = board;
        this.dictionary = dictionary;
        dimx = board.length;
        dimy = board[0].length;

        for(String token : dictionary){
            this.trie.insert(token);
        }

    }

    private boolean getCoord(int i,int j,Map<Integer,Map<Integer,Boolean>> map){
        if(!(i>=0 && i<dimx))
            return false;
        if(!(j>=0 && j<dimy))
            return false;
        /*if(map.get(i)!=null && map.get(i).get(j)!=null)
            return false;*/
        return true;
    }

    public void process(){
        Map<Integer,Map<Integer,Boolean>> map = null;
        List<String> token = null;

        for(int i=0;i<dimx;i++){
            for (int j=0;j<dimy;j++){
                map = new HashMap();
                token = getString(i,j,map,new Character(board[i][j]).toString());
                if(token!=null) {
                    for(String str : token)
                    System.out.println(str);
                }
            }
        }
    }

    private List<String> getString(int i,int j, Map<Integer,Map<Integer,Boolean>> map,String token){
        Map<Integer,Boolean> tuple = map.get(i);
        String result = null;
        List<String> results = new ArrayList();
        List<String> temp = new ArrayList<String>();

        if(trie.search(token)) {
            results.add(token);
            return results;
        }
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
            temp =getString(i-1,j,map,token+board[i-1][j]);
            if(temp!=null) {
                for(String str: temp) {
                    results.add(str);
                }
                //return result;
            }
        }

        //bottom
        if(getCoord(i+1,j,map)){
            temp = getString(i+1,j,map,token+board[i+1][j]);
            if(temp!=null) {
                for(String str: temp) {
                    results.add(str);
                }
                //return result;
            }
        }

        //left
        if(getCoord(i,j-1,map)){
            temp = getString(i,j-1,map,token+board[i][j-1]);
            if(temp!=null) {
                for(String str: temp) {
                    results.add(str);
                }
                //return result;
            }
        }


        //right
        if(getCoord(i,j+1,map)){
            temp= getString(i,j+1,map,token+board[i][j+1]);
            if(temp!=null) {
                for(String str: temp) {
                    results.add(str);
                }
                //return result;
            }
        }

        if(results==null || results.isEmpty())
            return null;
        else
            return results;



        //return null;
    }



    class TrieNodeWidMap {

        // Initialize your data structure here.
        public char letter;
        public boolean isLeaf;
        public Map<Character,TrieNodeWidMap> map = new HashMap();

        public TrieNodeWidMap() {

        }

    }

    class TrieWidMap {
        Solution.TrieNodeWidMap root = new TrieNodeWidMap();

        public void insert(String word) {
            Map<Character, TrieNodeWidMap> map = null;
            char letter = '\0';
            TrieNodeWidMap node = root;
            TrieNodeWidMap temp = null;

            for (int i=0;i<word.length();i++){
                letter = word.charAt(i);
                map = node.map;

                if(map.containsKey(letter))
                    node = map.get(letter);
                else {
                    temp = new TrieNodeWidMap();
                    temp.letter = letter;
                    map.put(letter,temp);
                    node = temp;
                }

                if(i==word.length()-1)
                    node.isLeaf= true;
            }
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNodeWidMap node = getNode(word,0,root);

            if(node!=null && node.isLeaf==true && !word.endsWith("."))
                return true;
            else if(node!=null &&  word.endsWith("."))
                return true;

            return false;

        }

        private TrieNodeWidMap getNode(String word,int index, TrieNodeWidMap node){
            char letter = '\0';
            Map<Character, TrieNodeWidMap> map = node.map;
            TrieNodeWidMap temp = null;
            Iterator<Character> itr = null;

            if(index==word.length()) {
                if(node.isLeaf==true)
                    return node;
                else
                    return null;
            }

            letter = word.charAt(index);
            if(map.containsKey(letter)) {
                temp = getNode(word, index + 1, map.get(letter));
                return temp;
            }
            else if(letter=='.' && !map.isEmpty()){
                itr = (map.keySet()).iterator();
                while (itr.hasNext()) {
                    /*if(map.get(itr.next()).map.isEmpty())
                        continue;*/
                    temp = getNode(word, index + 1, map.get(itr.next()));
                    if(temp!=null)
                        return temp;
                }
            }
            else
                return null;


            return null;
        }

        private TrieNodeWidMap getNodeStartWith(String word,int index, TrieNodeWidMap node){
            char letter = '\0';
            Map<Character, TrieNodeWidMap> map = node.map;
            TrieNodeWidMap temp = null;
            Iterator<Character> itr = null;

            if(index==word.length()) {
                return node;
            }

            letter = word.charAt(index);
            if(map.containsKey(letter)) {
                temp = getNodeStartWith(word, index + 1, map.get(letter));
                return temp;
            }
            else if(letter=='.' && !map.isEmpty()){
                itr = (map.keySet()).iterator();
                while (itr.hasNext()) {
                    /*if(map.get(itr.next()).map.isEmpty())
                        continue;*/
                    temp = getNodeStartWith(word, index + 1, map.get(itr.next()));
                    if(temp!=null)
                        return temp;
                }
            }
            else
                return null;


            return null;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNodeWidMap node = getNodeStartWith(prefix,0,root);

            if(node!=null)
                return true;

            return false;
        }



    }
    static void SearchMatrix(String matrix, String words) {

        String[] lines = matrix.split(";");
        String[] cols = lines[0].split(",");
        char[][] board = new char[lines.length][cols.length];

        for(int i=0;i<lines.length;i++){

            cols = lines[i].split(",");
            for(int j=0;j<cols.length;j++){
                board[i][j] = cols[j].charAt(0);
            }
        }

        String[] dictionary = words.split(",");

        Solution instance = new Solution(board,dictionary);
        instance.process();
    }
    public static void main(String[] args){
        String input = "c,a,b;t,r,u;u,s,s;b,p,o";


        String words = "car,bus,pop,but";

        SearchMatrix(input,words);


    }
}
