/*
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2. 
*/

public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.equals("")){
            return 0;
        }
        if(s.length() == 1) {
            if(s.equals("0")) {
                return 0;
            } else {
                return 1;
            }
        }
        //s.length() >= 2
        int[] decodings = new int[s.length()];
        if(s.charAt(s.length()-1) == '0') {
            decodings[s.length()-1] = 0;
        } else {
            decodings[s.length()-1] = 1;
        }
        if(s.charAt(s.length()-2) == '0') {
            decodings[s.length()-2] = 0;
        } else if(twoDigits(s,s.length()-2)) {
            decodings[s.length()-2] = 1 + decodings[s.length()-1];
        }  else {
            decodings[s.length()-2] = decodings[s.length()-1];
        }
        for(int i = s.length() -3; i >= 0; --i) {
            if(s.charAt(i)== '0') {
                decodings[i] = 0;
            } else if(twoDigits(s,i)) {
                decodings[i] = decodings[i+1] + decodings[i+2];
            } else {
                decodings[i] = decodings[i+1];
            }
        }
        return decodings[0];
    }
    
    public static boolean twoDigits(String s, int i) {
        return s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '6';
    }
    /*public int numDecodings(String s) {
        if(s == null || s.equals("")){
            return 1;
        }
        if(s.length() == 1) {
            if(s.equals("0")) {
                return 0;
            } else {
                return 1;
            }
        }
        //s.length() >= 2
        if(s.charAt(0) == '0') {
            return 0;
        }
        int total = 0;
        if(s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1) >= '0' && s.charAt(1) <= '6') {
            total += numDecodings(s.substring(2,s.length()));
        }
        total += numDecodings(s.substring(1,s.length()));
        return total;
    }*/
    
}
