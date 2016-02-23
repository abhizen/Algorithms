package Graph;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by abhinit on 1/18/16.
 */
public class TrieWidMap {
    TrieNodeWidMap root = new TrieNodeWidMap();

    public void insert(String word) {
        Map<Character,TrieNodeWidMap> map = null;
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

    private TrieNodeWidMap getNode(String word,int index,TrieNodeWidMap node){
        char letter = '\0';
        Map<Character,TrieNodeWidMap> map = node.map;
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

    private TrieNodeWidMap getNodeStartWith(String word,int index,TrieNodeWidMap node){
        char letter = '\0';
        Map<Character,TrieNodeWidMap> map = node.map;
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

    public static void main(String[] args){
        String word = "panasonic";
        TrieWidMap trie = new TrieWidMap();
        trie.insert(word);

        word = "peacock";
        trie.insert(word);

        word = "pentagon";
        trie.insert(word);

        word = "penicilin";
        trie.insert(word);

        if(trie.search("p..i..l.."))
            System.out.println("present");
        else
            System.out.println("absent");

        word = "ab";
        trie.insert(word);
        if(trie.startsWith("a"))
            System.out.println("present");
        else
            System.out.println("absent");

    }

}
