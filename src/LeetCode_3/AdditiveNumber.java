import java.math.BigInteger;

/**
 * Created by abhinit on 1/24/16.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {

        if(num==null || num.length()<=2)
            return false;

        if(checkSum(num,0,BigInteger.ZERO,BigInteger.ZERO,1))
            return true;
        else
            return false;
    }

    private boolean checkSum(String num,int index,BigInteger a,BigInteger b,int digitNo){
        String digit = null;
        BigInteger number = null;
       /*taking first digit
       *taking second digit, then check if chain created matches the string
       */

        if(digitNo==3 && index>=num.length()){
            return true;
        }

        if(digitNo==1){
            for(int i=1;i<=num.length();i++){
                digit = num.substring(0,i);
                number = new BigInteger(digit);  //.parse(digit);
                //System.out.println("1st " + number);

                if((i-index)>1 && num.charAt(index)=='0')
                    return false;

                if(checkSum(num,i,number,b,2)){
                    return true;
                }
            }
        }
        else if(digitNo==2){
            for(int i=index+1;i<num.length();i++){
                digit = num.substring(index,i);
                number = new BigInteger(digit);

                if((i-index)>1 && num.charAt(index)=='0')
                    return false;

                //System.out.println("2nd "+number);
                if(checkSum(num,i,a,number,3)){
                    return true;
                }
            }
        }
        else if(digitNo==3){

            number = a.add(b);
            digit = number.toString();
            //System.out.println(index+digit.length()+" substring "+num.substring(index,index+digit.length()));

            if(digit.length()>1 && num.charAt(index)=='0')
                return false;

            if(index+digit.length()<=num.length() &&
                    num.substring(index,index+digit.length()).equals(digit)){
                //System.out.println("3rd "+number);
                if(checkSum(num,index+digit.length(),b,number,3)){
                    return true;
                }
            }

        }

        return false;
    }
    public static void main(String[] args){
        AdditiveNumber instance = new AdditiveNumber();
        String num = "1023";
        if(instance.isAdditiveNumber(num))
            System.out.println("Found");
        else
            System.out.println("not Found");
    }
}
