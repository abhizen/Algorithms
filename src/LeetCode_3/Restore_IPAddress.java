import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by abhinit on 2/1/16.
 */
public class Restore_IPAddress {
    Pattern ipaddrPattern = null;

    public List<String> restoreIpAddresses(String s) {

        if(s==null || s.length()==0)
            return new ArrayList();

        ipaddrPattern = Pattern.compile("^([0-9]{1,3})[\\.]([0-9]{1,3})[\\.]([0-9]{1,3})[\\.]([0-9]{1,3})$");

        char[] ipaddr = s.toCharArray();

        List<String> list = getIpAddress(ipaddr,0,0,"");
        return list;

        /*List<String> ret = new LinkedList();
        int[] path = new int[4];
        helper(ret, s, 0,  path, 0);
        return ret;*/
    }

    private List<String> getIpAddress(char[] ipaddr,int index,int count,String addr){
        List<String> list = new ArrayList();
        List<String> tempList = null;
        String temp = addr;
        Matcher mtch = null;
        String strVal = "";
        int val = 0;


        if(count==4 && addr.length()==(ipaddr.length+3)){
            /*for(int i=index;i<ipaddr.length;i++){
                temp = temp+ipaddr[i];
            }*/
            /*mtch = ipaddrPattern.matcher(temp);
            if(mtch.matches())
                list.add(temp);*/
            list.add(addr);
            return list;
        }
        else if(count==4 || addr.length()==(ipaddr.length+3)){
            return new ArrayList<String>();
        }

        if(!addr.isEmpty())
        temp = addr+".";

        for(int i=index;i<=index+2 && i<ipaddr.length;i++){

            strVal = strVal+ipaddr[i];
            val =Integer.parseInt(strVal);
            if(val>255 || strVal.length()>2 && strVal.charAt(0)=='0')
                break;

            tempList = getIpAddress(ipaddr, i + 1, count + 1, temp+strVal);
            for (String tuple : tempList)
                list.add(tuple);
        }

        return list;
    }
    private void helper(List<String> acc, String s, int idx, int[] path,  int segment){
        if(segment == 4 && idx == s.length() ){
            acc.add(path[0] + "." + path[1] + "."+ path[2] + "." + path[3]);
            return ;
        }else if(segment == 4 || idx == s.length() ){
            return ;
        }

        for(int len = 1; len <= 3 && idx + len <= s.length() ; len ++){
            int val = Integer.parseInt(s.substring(idx, idx + len));
            // range check, no leading 0.
            if(val > 255 || len >= 2  && s.charAt(idx) == '0')
                break;

            path[segment] = val;
            helper(acc, s, idx + len, path, segment + 1);
            path[segment] = -1; // for debug.
        }
    }

    public static void main(String[] args){
        Restore_IPAddress instance = new Restore_IPAddress();
        String input ="25525511135";
        List<String> list = instance.restoreIpAddresses(input);
        for(String elem : list){
            System.out.println(elem);
        }
    }
}
