import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 12/2/15.
 */
public class LongestCommonPrefix {
private Node trieRoot = null;
private String resultPrefix = null;
    private int count = 0;

    LongestCommonPrefix(){
        this.trieRoot = new Node('r');
    }

    public String createPrefixTree(String word){
        Node node = trieRoot;
        StringBuilder prefix = null;

        this.count++;

        if(word==null)
            return null;

        int index = 0;
        char[] letterList = word.toCharArray();
        Node head =this.trieRoot;

        if(word=="") {
            if ((node = head.checkNode('\0')) != null)
                return "";
            else {
                head.addNode('\0');
            }
        }
        else {
            prefix = null;
            for (char letter : word.toCharArray()) {
                if (node != null) {
                    if ((node = node.checkNode(letter)) != null) {
                        if(prefix==null)
                            prefix = new StringBuilder();
                        prefix.append(letter);
                        head = node;
                    } else
                        break;
                } else
                    break;
                index++;
            }


            node = head;
            for (int i = index; i < word.length(); i++) {
                node = node.addNode(word.charAt(i));
            }

        }

        if(resultPrefix==null && prefix==null)
            resultPrefix = null;
        else if (this.count==2 && resultPrefix==null && prefix!=null){
            resultPrefix = prefix.toString();
        }
        else if(resultPrefix!=null && resultPrefix!="" && prefix==null)
            resultPrefix = "";
        else if(resultPrefix!=null && prefix!=null
            && resultPrefix.length()>=prefix.length()){
            resultPrefix = prefix.toString();
        }


        return resultPrefix!=null?resultPrefix.toString():null;
    }



    class Node{
        private char letter = '\0';
        private List<Node> children = null;

        public Node(char letter){
            this.letter = letter;
        }



        public Node checkNode(char letter){
            if(this.children==null)
                return null;

            for(Node child : children){
                if(child.getName()==letter)
                    return child;
            }

            return null;
        }

        public char getName(){
            return letter;
        }

        public List<Node> getChildren() {
            return this.children;
        }

        public Node addNode(char letter){
            Node node = null;
            if(children==null)
                children = new ArrayList<>();

            node = new Node(letter);
            this.children.add(node);
            return node;
        }

    }
    public String test(String[] list){
        String[] nameList = list;
        String prefix = null;

        for(String name : nameList) {
            prefix = createPrefixTree(name);

        }

        return prefix;
    }
    public static void main(String[] args){
        String[][] nameList = {{"abhinit","abhinitKumar","abnand"},
        {"abhi","ghdfg"},
                {"random",""},
                {""},
                {"r"},
                {"randomize"},
                {"",""},
                {"aaa","aa","aaa"},
                {"a","a","b"},
                {"a","a","b","a","b"},
                {"caa","","a","acb"}
                };

        LongestCommonPrefix instance = null;
        String prefix = null;
        int i = nameList.length;
        int j = nameList[0].length;

        for(int index=0;index<i;index++){
                if(nameList[index].length==1)
                    System.out.println(nameList[index][0]);
                else {
                    instance = new LongestCommonPrefix();
                    prefix = instance.test(nameList[index]);
                    System.out.println(prefix);
                }
        }

    }
    public String longestCommonPrefix_v1(String[] strs) {

        if(strs==null || strs.length==0)
            return "";

        String substr = strs[0];
        int p = 0,q=0;

        for(int i=1;i<strs.length;i++){
            p = 0;
            q=0;
            while(q<strs[i].length() && p<substr.length()){
                if(substr.charAt(p)!=strs[i].charAt(q)){
                    break;
                }
                p++;
                q++;
            }

            if(p==0){
                return "";
            }
            else{
                substr = substr.substring(0,p);
            }
        }

        return substr;
    }
}
