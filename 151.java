/*
 Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the". 
*/
public class Solution {
    public String reverseWords(String s) {
        if(s == null) {
            return null;
        }
        s = s.trim();
        String[] arr = s.split("\\s+");
        StringBuilder res = new StringBuilder("");
        String sep = "";
        for(int i = arr.length-1; i >= 0; --i) {
            res.append(sep).append(arr[i]);
            sep = " ";
        }
        return res.toString();
    }
}
