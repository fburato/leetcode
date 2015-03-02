/*
 Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100". 
*/
public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int limit = Math.max(a.length(),b.length());
        String res = "";
        for(int i = 0; i < limit; ++i) {
            carry = carry + getValue(a,i) + getValue(b,i);
            res = "" + (carry % 2) + res;
            carry = carry / 2;
        }
        if(carry == 1) {
            res = "1" + res;
        }
        return res;
    }
    
    public int getValue(String s, int index) {
        if(index < 0 || index >= s.length()){
            return 0;
        }
        index = s.length()-index -1;
        return s.charAt(index) - '0';
    }
}
