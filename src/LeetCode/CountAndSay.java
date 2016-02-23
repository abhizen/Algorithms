/**
 * Created by abhinit on 11/28/15.
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        int key = 0;
        int count = 0;
        int rem = 0;
        int quo = 0;
        String num = "";
        int number = n;

        if(n==1)
            return "1";

        number = 1;
        for(int i =1;i<=n;i++){
            num="";
            for(quo=number;quo!=0;quo=quo/10){

                rem = quo%10;
                if(key==0){
                    key = rem;
                    count++;
                }
                else if(rem==key){
                    count++;
                }
                else if(rem!=key){
                    num = count+""+key+""+num;
                    count=1;
                    key = rem;
                }
            }
            num = count+""+key+""+num;
            count = 0;
            key = 0;
            number = Integer.parseInt(num);
        }

        return num;
    }
    public static void main(String[] args){
        int key = 4;
        String num = countAndSay(key);

    }
}
