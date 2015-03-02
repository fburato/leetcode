/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/
public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length()< num2.length()) {
            return multiply(num2,num1);
        }
        if(num2.equals("0")){
            return "0";
        }
        // num1 has more digits than num2
        int carry = 0;
        String res = "";
        for(int i = num1.length()+num2.length()-2; i >= 0; --i) {
            for(int k = Math.min(num2.length()-1,i); k >= 0 && i-k < num1.length() && i-k >= 0; k--){
                carry = carry + (num1.charAt(i-k) - '0') * (num2.charAt(k) - '0');
            }
            res = (carry % 10) + res;
            carry = carry / 10;
        }
        if(carry > 0){
            return "" + carry + res;
        } else {
            return res;
        }
    }
}
