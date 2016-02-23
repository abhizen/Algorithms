

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 1/11/16.
 */
public class Solution {
    public List<String> getCombination(List<List<String>> strings){

        if(strings==null || strings.size()==0)
            return new ArrayList<String>();


        List<String> combinationList = new ArrayList<String>();
        List<String> tempList = null;
        List<String> set = null;

        for(int i=0;i<strings.size();i++){

            set = strings.get(i);

            tempList = new ArrayList<String>();

            if(set!=null && set.size()>0) {
                for (int j = 0; j < set.size(); j++) {

                    if (set.get(j) != null && set.get(j).length() > 0) {
                        if (combinationList.isEmpty()) {
                            tempList.add(set.get(j));
                        } else {
                            for (String elem : combinationList) {
                                elem = elem + " " + set.get(j);
                                tempList.add(elem);
                            }
                        }
                    }
                }
            }
            if(!tempList.isEmpty())
                combinationList = tempList;
        }

        return combinationList;
    }

    public static void main(String[] args){
        Solution instance = new Solution();
        instance.testCases();

    }


    public  void testCases(){
        List<String> wordList = null;
        List<List<String>> testcase = null;

        System.out.println("");
        System.out.println("----test case1----");
        testcase = new ArrayList<List<String>>();
        wordList = new ArrayList<String>();
        wordList.add("quick");
        wordList.add("quick");
        wordList.add("lazy");
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        wordList.add("brown");
        wordList.add("black");
        wordList.add("grey");
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        wordList.add("fox");
        wordList.add("dog");
        testcase.add(wordList);
        test(testcase);

        System.out.println("");
        System.out.println("----test case2----");
        testcase = new ArrayList<List<String>>();
        wordList = null;
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        wordList.add("brown");
        wordList.add("black");
        wordList.add("grey");
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        wordList.add("fox");
        wordList.add("dog");
        testcase.add(wordList);
        test(testcase);

        System.out.println("");
        System.out.println("----test case3----");
        testcase = new ArrayList<List<String>>();
        wordList = new ArrayList<String>();
        wordList.add("quick");
        wordList.add("quick");
        wordList.add("lazy");
        testcase.add(wordList);
        wordList = null;
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        wordList.add("fox");
        wordList.add("dog");
        testcase.add(wordList);
        test(testcase);

        System.out.println("");
        System.out.println("----test case4----");
        testcase = new ArrayList<List<String>>();
        wordList = new ArrayList<String>();
        wordList.add("quick");
        wordList.add("lazy");
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        wordList.add("brown");
        wordList.add("black");
        wordList.add("grey");
        testcase.add(wordList);
        wordList = null;
        testcase.add(wordList);
        test(testcase);

        System.out.println("");
        System.out.println("----test case5----");
        testcase = new ArrayList<List<String>>();
        wordList = null;
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        wordList.add("brown");
        wordList.add("black");
        wordList.add("grey");
        testcase.add(wordList);
        wordList = null;
        testcase.add(wordList);
        test(testcase);

        System.out.println("");
        System.out.println("----test case6----");
        testcase = new ArrayList<List<String>>();
        wordList = null;
        testcase.add(wordList);
        wordList = null;
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        wordList.add("fox");
        wordList.add("dog");
        testcase.add(wordList);
        test(testcase);

        System.out.println("");
        System.out.println("----test case7----");
        testcase = new ArrayList<List<String>>();
        wordList = new ArrayList<String>();
        wordList.add("quick");
        wordList.add("lazy");
        testcase.add(wordList);
        wordList = null;
        testcase.add(wordList);
        wordList = null;
        testcase.add(wordList);
        test(testcase);

        System.out.println("");
        System.out.println("----test case8----");
        testcase = new ArrayList<List<String>>();
        wordList = new ArrayList<String>();
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        testcase.add(wordList);
        test(testcase);

        System.out.println("");
        System.out.println("----test case9----");
        testcase = new ArrayList<List<String>>();
        wordList = new ArrayList<String>();
        testcase.add(wordList);
        test(testcase);

        System.out.println("");
        System.out.println("----test case10----");
        testcase = new ArrayList<List<String>>();
        test(testcase);

        System.out.println("");
        System.out.println("----test case11----");
        testcase = new ArrayList<List<String>>();
        wordList = new ArrayList<String>();
        wordList.add("");
        wordList.add("lazy");
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        wordList.add(null);
        wordList.add("black");
        wordList.add("grey");
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        wordList.add("fox");
        wordList.add("dog");
        testcase.add(wordList);
        test(testcase);

        System.out.println("");
        System.out.println("----test case12----");
        testcase = new ArrayList<List<String>>();
        wordList = null;
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        wordList.add("");
        testcase.add(wordList);
        test(testcase);

        System.out.println("");
        System.out.println("----test case13----");
        testcase = new ArrayList<List<String>>();
        wordList = new ArrayList<String>();
        wordList.add("lazy");
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        wordList.add("black");
        testcase.add(wordList);
        test(testcase);

        System.out.println("");
        System.out.println("----test case14----");
        testcase = new ArrayList<List<String>>();
        wordList = new ArrayList<String>();
        wordList.add("lazy");
        testcase.add(wordList);
        wordList = new ArrayList<String>();
        testcase.add(wordList);
        test(testcase);
    }

    public  void test(List<List<String>> list){
        List<String> combination = getCombination(list);

        for(String elem : combination){
            System.out.println(elem);
        }

        System.out.println("Number of combinations: " + combination.size());
    }

}
