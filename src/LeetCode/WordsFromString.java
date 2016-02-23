import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by abhinit on 12/14/15.
 */
public class WordsFromString {
    List<String> list = new ArrayList<>();
    Map<String,Boolean> map = new HashMap<>();

    WordsFromString(){
        map.put("hello",true);
        map.put("world",true);
        map.put("india",true);
        map.put("watch",true);
        map.put("tulip",true);
    }

    public void process(String sentence){
        getWords("", 0, sentence);
    }

    private void getWords(String word, int beginIndex,String sentence)
    {
        String temp = word;


        if(beginIndex>=sentence.length())
            return;

        for(int i=beginIndex;i<sentence.length();i++){

            temp =word + sentence.charAt(i);
            if(map.get(temp)!=null){
                list.add(temp);

                return;
            }
            getWords(temp,i+1,sentence);
        }

    }

    private void dpSolution(String sentence){
        String[][] memoize = new String[sentence.length()][sentence.length()];

        for(int i = 0;i<sentence.length();i++){
            for(int j=0;j<sentence.length();j++){
                if(i==0){
                    memoize[i][j] = sentence.substring(j,j+1);
                }
                else if((i+j)<sentence.length()) {
                    memoize[i][j] = memoize[0][j] + memoize[i - 1][j + 1];
                    if(map.get(memoize[i][j])!=null)
                        list.add(memoize[i][j]);
                }
                else
                    memoize[i][j] = null;
            }
        }

    }

    public static void main(String[] args){

        WordsFromString instance = new WordsFromString();
        //instance.process("helloworld");
        instance.dpSolution("indiaismycoutntryhelloalloveragainworldwatchout");

        for(String word : instance.list){
            System.out.println(word+" ");
        }
    }

}
