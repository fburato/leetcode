/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) {
            return s;
        }
        char arrS[] = s.toCharArray();
        int maxLength = 1;
        int  start = 0;
        for(int i = 0; i < arrS.length; ++i) {
            // arrS[i] is the center of the palindrome
            int dist = 1;
            while(i-dist >= 0 && i+dist < arrS.length && arrS[i-dist] == arrS[i+dist]) {
                dist++;
            }
            dist--;
            if(dist*2+1 > maxLength) {
                maxLength = dist*2+1;
                start = i - dist;
            }
            // arrS[i] is the left center
            int left = i, right = i+1;
            while(left >= 0 && right < arrS.length && arrS[left] == arrS[right]) {
                left--;
                right++;
            }
            left++; right--;
            if(right -left +1 > maxLength) {
                maxLength = right-left+1;
                start = left;
            }
        }
        return s.substring(start,start+maxLength);
    }
}
