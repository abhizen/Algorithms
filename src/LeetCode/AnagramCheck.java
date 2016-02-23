/**
 * Created by abhinit on 11/22/15.
 */
public class AnagramCheck {
    public static boolean isAnagram(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        int[] capSCount = new int[26];
        int[] capTCount = new int[26];
        char letter = '\0';

        for(int i=0;i<s.length();i++){
            letter = s.charAt(i);
            if(letter>='A' && letter<='B')
                capSCount[letter-'A']= capSCount[letter-'A'] +1;
            else {
                sCount[letter - 'a'] = sCount[letter - 'a'] + 1;
            }

            letter = t.charAt(i);
            if(letter>='A' && letter<='B') {
                capTCount[letter - 'A'] = capTCount[letter - 'A'] + 1;
            }
            else {
                tCount[letter - 'a'] = tCount[letter - 'a'] + 1;
            }
        }

        for(int i=0;i<26;i++){
            if(sCount[i]!=tCount[i])
                return false;
            if(capSCount[i]!=capTCount[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        if(isAnagram("Abc","bac"))
            System.out.println("equal");
    }
}
