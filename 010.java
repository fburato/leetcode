/*
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

import java.util.ArrayList;

public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray(), 0,0);
    }

    public boolean isMatch(char s[], char p[], int sStart, int pStart) {
        if(sStart == s.length && pStart == p.length) {
            return true;
        }
        if(sStart < s.length && pStart == p.length) {
            return false;
        }
        // pStart < p.length
        // determine if there are multiplicity
        boolean mult = false;
        int nextPChar = pStart+1;
        if(pStart + 1 < p.length && p[pStart+1] == '*') {
            nextPChar++;
            mult = true;
        }
        if(!mult) {
            // there must be an exact match and the rest continues
            return sStart < s.length && (s[sStart] == p[pStart] || p[pStart] == '.') && isMatch(s,p,sStart+1,nextPChar);  
        } else {
            // first try to match nothing
            boolean res = isMatch(s,p,sStart,nextPChar);
            int matched = sStart;
            while(!res && matched < s.length && (s[matched] == p[pStart] || p[pStart] == '.')){
                res = isMatch(s,p,matched+1,nextPChar);
                matched++;
            }
            return res;
        }
    }
}
