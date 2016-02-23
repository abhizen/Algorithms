import java.util.HashSet;
import java.util.Set;

/**
 * Created by abhinit on 1/23/16.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {

        if(process(s,0,wordDict)){
            return true;
        }
        else
            return false;
    }

    private boolean process(String s,int beginIndex,Set<String> wordDict){
        String word = null;

        if(beginIndex>=s.length())
            return true;

        for(int i=beginIndex+1;i<=s.length();i++){
            //System.out.println(i);
            word = s.substring(beginIndex,i);
            if(wordDict.contains(word)){
                System.out.println(word);
                if(process(s,i,wordDict))
                    return true;
            }
        }

        return false;
    }
    public static void main(String[] args){
        WordBreak instance = new WordBreak();
        String word = "leetcode";
        Set<String> set = new HashSet<String>();
        set.add("leet");
        set.add("code");
        if(instance.wordBreak(word,set))
            System.out.println("Matching");
    }
}
