package Graph;


import java.util.List;
/**
 * Created by abhinit on 1/18/16.
 */
/*
class TrieNode {
    // Initialize your data structure here.
    public char letter;
    public boolean isLeaf;
    public List<TrieNode> children = new ArrayList();

    public TrieNode() {

    }
}
*/
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.letter='\0';
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        char[] charArray = word.toCharArray();
        char letter = '\0';
        List<TrieNode> children = null;
        TrieNode temp = null;
        int j = 0;

        for(int i=0;i<charArray.length;i++){

            children = node.children;
            letter = charArray[i];
            for(j=0;j<children.size();j++){
                if(children.get(j).letter==letter){
                    node = children.get(j);
                    break;
                }
            }

            if(j==children.size()){
                temp = new TrieNode();
                temp.letter = letter;
                children.add(temp);
                node = temp;
            }

            if(i==charArray.length-1)
                node.isLeaf = true;
        }
    }

    private TrieNode getNode(TrieNode root,char[] charArray,int index){
        List<TrieNode> children = root.children;
        TrieNode node = null;

        if(index==charArray.length)
            return root;

        for(TrieNode child : children){
            if(child.letter==charArray[index]){
                node = getNode(child,charArray,index+1);
                if(node==null){
                    return null;
                }
                else
                    return node;
            }
            else if('.'==charArray[index]){
                node = getNode(child,charArray,index+1);
                if(node!=null){
                    return node;
                }
            }
        }

        return null;

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] children = word.toCharArray();
        TrieNode node = getNode(this.root,children,0);
        if(node==null)
            return false;
        else if(node.isLeaf==true)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] children = prefix.toCharArray();
        TrieNode node = getNode(this.root,children,0);
        if(node==null)
            return false;
        else if(node.isLeaf==false)
            return true;
        else
            return false;

    }

    public static void main(String[] args){
        String word = "ab";
        Trie trie = new Trie();
        trie.insert(word);

        if(trie.search("a"))
            System.out.println("present");
        else
            System.out.println("absent");
    }
}

