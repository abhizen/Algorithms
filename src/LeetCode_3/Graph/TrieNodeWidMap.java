package Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhinit on 1/18/16.
 */
public class TrieNodeWidMap {

        // Initialize your data structure here.
        public char letter;
        public boolean isLeaf;
        public Map<Character,TrieNodeWidMap> map = new HashMap();

        public TrieNodeWidMap() {

        }


}
