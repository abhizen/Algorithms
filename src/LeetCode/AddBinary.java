/**
 * Created by abhinit on 11/28/15.
 */
public class AddBinary {

    public String addBinary_tuned(String a,String b){
        if(a==null || b==null)
            return null;

        int carry = 0;
        int result = 0;
        String strResult = new String();
        int length = a.length();
        char aLetter = '\0';
        char bLetter = '\0';

        int secLength = b.length();
        int secIndex = secLength -1;
        int primIndex = length-1;

        while(primIndex>=0 || secIndex>=0) {

            if(primIndex>=0)
                aLetter = a.charAt(primIndex);
            else
                aLetter='0';

            if(secIndex>=0)
                bLetter = b.charAt(secIndex);
            else
                bLetter = '0';

            if(primIndex>=0 && secIndex>=0){
                result = sum(Character.getNumericValue(aLetter)
                        ,Character.getNumericValue(bLetter));
            }
            else if(primIndex>=0 && secIndex<0){
                result = sum(Character.getNumericValue(aLetter),
                        0);
            }
            else if(primIndex<0 && secIndex>=0){
                result = sum(0,Character.getNumericValue(bLetter));
            }

            if(sum(result,carry)==11){
                result = 1;
                carry = 1;
            }
            else if(sum(result,carry)==10){
                result = 0;
                carry = 1;
            }
            else if(sum(result,carry)==1){
                result = 1;
                carry = 0;
            }
            else if(sum(result,carry)==0){
                result = 0;
                carry = 0;
            }

            strResult = result+""+strResult;
            primIndex--;
            secIndex--;
        }

        if(carry==1)
            strResult = carry+""+strResult;
        return strResult;
    }
    public String addBinary(String a, String b) {

        if(a==null || b==null)
            return null;

        int carry = 0;
        int result = 0;
        String strResult = new String();
        int length = a.length();
        char aLetter = '\0';
        char bLetter = '\0';

        int secLength = b.length();
        int index = secLength -1;

        for(int i=length-1;i>=0;i--){
            if(i>=0)
                aLetter = a.charAt(i);
            else
                aLetter = '0';

            if(index>=0)
                bLetter = b.charAt(index);
            else
                bLetter = '0';

            result = sum(Character.getNumericValue(aLetter)
                    ,Character.getNumericValue(bLetter));

            if(sum(result,carry)==11){
                result = 1;
                carry = 1;
            }
            else if(sum(result,carry)==10){
                result = 0;
                carry = 1;
            }
            else if(sum(result,carry)==1){
                result = 1;
                carry = 0;
            }
            else if(sum(result,carry)==0){
                result = 0;
                carry = 0;
            }

            strResult = result+""+strResult;

            index--;
        }

        if(index>=0){
            aLetter = '0';
            for(int i=index;i>=0;i--){
                bLetter = b.charAt(i);
                result = sum(Character.getNumericValue(bLetter),carry);


                if(result==11){
                    result = 1;
                    carry = 1;
                }
                else if(result==10){
                    result = 0;
                    carry = 1;
                }
                else if(result==1){
                    result = 1;
                    carry = 0;
                }
                else if(result==0){
                    result = 0;
                    carry = 0;
                }

                strResult = result+""+strResult;
            }

        }

        if(carry==1)
            strResult = carry+""+strResult;

        return strResult;
    }
    private int sum(int a,int b){
        if(a==1 && b==1)
         return 10;
        else if((a==1 && b==0)||(a==0 && b==1))
            return 1;
        else if(a==10)
            return a+b;
        else if(a==11 && b==1)
            return 100;
        else if(a==11 && b==0)
            return 11;
        else
            return 0;
    }
    public static void main(String[] args){
        AddBinary instance = new AddBinary();
        String result = instance.addBinary("10101","110000");

        System.out.println(result);
        result = instance.addBinary_tuned("10101","110000");

        System.out.println(result);

    }
}
