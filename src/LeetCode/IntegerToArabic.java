/**
 * Created by abhinit on 12/9/15.
 */
public class IntegerToArabic {
    public String intToRoman(int num) {
        int[] index = {1000,  900,  500,  400,  100,   90,
                50,   40,   10,    9,    5,    4,    1};
        String[] letters= { "M",  "CM",  "D",  "CD", "C",  "XC",
                "L",  "XL",  "X",  "IX", "V",  "IV", "I"};

        String romanNumeral = new String();

        for(int i=0;i<letters.length;i++){

            while (num>=index[i]){
                num = num - index[i];
                romanNumeral = romanNumeral+letters[i];
            }

        }

        return romanNumeral;
    }

    public static void main(String[] args){
        IntegerToArabic integerToArabic = new IntegerToArabic();
        String romanNumeral = integerToArabic.intToRoman(1904);
        System.out.println(romanNumeral);
    }
}
