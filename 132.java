/*
 Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
*/
import java.util.HashMap;

public class Solution {
    
    private int[] minimum
    public boolean isPalindrome(String s) {
        for(int i = 0; i < s.length() / 2; ++i) {
            if(s.charAt(i) != s.charAt(s.length() -1 -i)) {
                return false;
            } 
        }
        return true;
    }
    
    public int minCut(String s) {
        if(s == null || s.length() <= 1) {
            return 0;
        }
        // s.length() > 1
        Integer min = minimum.get(s);
        if(min != null) {
            return min;
        }
        if(isPalindrome(s)){
            minimum.put(s,0);
            return 0;
        }
        min = s.length();
        for(int i = 1; i < s.length(); ++i) {
            if(isPalindrome(s.substring(0,i))) {
                String rest = s.substring(i,s.length());
                int minRest = minCut(rest);
                if(1 + minRest < min) {
                    min = 1+ minRest;
                }
            }
        }
        minimum.put(s,min);
        return min;
    }
}
