/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front. 
*/

public class Solution {
    public int atoi(String str) {
        long result = 0;
        boolean positive = true;
        int pos = 0;
        while(pos < str.length() && str.charAt(pos) == ' ') {
            pos++;
        }
        if(pos < str.length() && (str.charAt(pos) == '-' || str.charAt(pos) == '+')) {
            positive = str.charAt(pos) == '+';
            pos++;
        }
        if(pos < str.length() && isDigit(str.charAt(pos))) {
            // start reading the digits
            boolean overflow = false;
            while(pos < str.length() && !overflow && isDigit(str.charAt(pos))) {
                result = result * 10 + str.charAt(pos) - '0';
                if(positive && result > Integer.MAX_VALUE || ! positive && result > -((long)Integer.MIN_VALUE)) {
                    overflow = true;
                }
                pos++;
            }
            if(overflow && positive) {
                result = Integer.MAX_VALUE;
            } else if(overflow && ! positive) {
                result = Integer.MIN_VALUE;
            } else if(!positive){
                result = - result;
            }
        } 
        return (int) result;
    }
    
    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
