/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
*/
import java.util.LinkedList;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        String tris[] = {"","","",""};
        restoreIpAddresses(s,0,result,tris,0);
        return result;
    }
    
    public void restoreIpAddresses(String s, int cur, List<String> result, String tris[], int numDots) {
        if(numDots == 3) {
            String sub = s.substring(cur,s.length());
            if(validNumber(sub)){
                tris[numDots] = sub;
                result.add(getIp(tris));
            }
            return ;
        }
        for(int i = 1; cur+i <= s.length() && i <= 3; ++i) {
            String sub = s.substring(cur,cur+i);
            if(validNumber(sub)) {
                tris[numDots] = sub;
                restoreIpAddresses(s,cur+i,result,tris,numDots+1);
            }
        }
    }
    public boolean validNumber(String s) {
        if(s.length() == 0 || s.length() > 3){
            return false;
        }
        if(s.length() == 1) {
            return s.charAt(0) >= '0' && s.charAt(0) <= '9';
        }
        if(s.length() >= 2 && s.charAt(0) != '0') {
            int i = Integer.decode(s);
            return i >= 0 && i <= 255;
        }
        return false;
    }
    
    public String getIp(String[] v) {
        String res = "", sep = "";
        for(int i = 0; i < v.length; ++i) {
            res = res + sep +v[i];
            sep = ".";
        }
        return res;
    }
}
