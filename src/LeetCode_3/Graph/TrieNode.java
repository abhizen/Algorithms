package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 1/18/16.
 */
public class TrieNode {

        // Initialize your data structure here.
        public char letter;
        public boolean isLeaf;
        public List<TrieNode> children = new ArrayList();

        public TrieNode() {

        }

}
