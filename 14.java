/*
Write a function to find the longest common prefix string amongst an array of strings. 
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0 || strs[0] == null)
            return "";
        int last = 0;
        boolean cont = strs[0].length() > 0;
        while(cont) {
            for(int i = 0; cont && i < strs.length; ++i) {
                cont = strs[i] != null && last < strs[i].length() && strs[i].charAt(last) == strs[0].charAt(last);
            }
            if(cont) {
                last++;
            }
        }
        return strs[0].substring(0,last);
    }
}
