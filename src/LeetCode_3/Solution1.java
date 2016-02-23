import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 1/12/16.
 */

    class Solution1 {

        /*Method creates combination of words*/
        public List<String> getCombination(List<List<String>> strings) {

            if (strings == null || strings.size() == 0)
                return new ArrayList<String>();


            List<String> combinationList = new ArrayList<String>();
            List<String> tempList = null;
            List<String> set = null;

            for (int i = 0; i < strings.size(); i++) {

                set = strings.get(i);

                tempList = new ArrayList<String>();

                if (set != null && set.size() > 0) {
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
                if (!tempList.isEmpty())
                    combinationList = tempList;
            }

            return combinationList;
        }


        /*Method enlists test cases to  test getCombination method*/
        public void testCases() {
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

        public void test(List<List<String>> list) {
            List<String> combination = getCombination(list);

            for (String elem : combination) {
                System.out.println(elem);
            }

            System.out.println("Number of combinations: " + combination.size());
        }


        public static void main(String[] args) {
            Solution1 instance = new Solution1();
            List<String> wordList = null;
            List<List<String>> testcase = null;

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
            wordList = new ArrayList<String>();
            wordList.add("fox");
            wordList.add("dog");
            testcase.add(wordList);

            List<String> combination = instance.getCombination(testcase);

            for (String elem : combination) {
                System.out.println(elem);
            }

            System.out.println("Number of combinations: " + combination.size());
        }
    }

/*
You're given a vector of vectors of words, e.g.:
[['quick', 'lazy'], ['brown', 'black', 'grey'], ['fox', 'dog']].

Write a generalized function that prints all combinations of one word from the first vector, one word from the second vector, etc.
The solution may not use recursion.
NOTE: the number of vectors and number of elements within each vector may vary.

For the input above, it should print (in any order):
quick brown fox
quick brown dog
quick black fox
quick black dog
...
lazy grey dog
*/



