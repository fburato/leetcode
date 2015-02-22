/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

*/
import java.util.*;

public class Solution {
    public boolean isMatch(String s, String p) {
    
    }
    /*public boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0) {
            return true;
        }
        if(s.length() == 0 || p.length() == 0) {
            return false;
        }
        // s.length() > 0 && p.length() > 0
        p = sanitize(p);
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        return isMatch(sArr,pArr,0,0);
    }
    
    public boolean isMatch(char[] s, char[] p, int sStart, int pStart) {
        if(sStart == s.length && pStart == p.length || pStart == p.length -1 && p[pStart] == '*' ) {
            return true;
        }
        if(sStart == s.length || pStart == p.length) {
            return false;
        }
        // there is at least one character different from '*' from pStart
        boolean isStar = p[pStart] == '*';
        if(isStar) {
            pStart++;
        }
        // pStart points to an actual character, find the matching substring
        int subLength = getSubLength(p,pStart);
        int index = indexOf(s,p,sStart,pStart, subLength);
        boolean tryMatch = false;
        if(!isStar) {
            tryMatch = index == sStart && isMatch(s,p,sStart+subLength,pStart+subLength);   
        } else {
            while(!tryMatch && index != -1) {
                tryMatch = isMatch(s,p,index+subLength,pStart+subLength);
                index = indexOf(s,p,index+1,pStart,subLength);
            }
        }
        return tryMatch;
    }
    
    public String sanitize(String p) {
        StringBuilder res = new StringBuilder("");
        char[] chars = p.toCharArray();
        boolean lastStar = false;
        for(int i = 0; i < chars.length; ++i) {
            if(chars[i] != '*' || !lastStar) {
                res.append(chars[i]);
            } 
            lastStar = chars[i] == '*';
        }
        return res.toString();
    }
    
    public static int getSubLength(char[] p, int start) {
        int j = start+1;
        while(j < p.length && p[j] != '*') {
            j++;
        }
        return j-start;
    }
    
    
    public static int indexOf(char[] s, char[] p, int start, int pStart, int pLength) {
        for(int i = start; i <= s.length - pLength; ++i) {
            boolean stillEqual = true;
            for(int j = 0; stillEqual && j < pLength ; ++j) {
                stillEqual = p[pStart+j] == '?' || s[i+j] == p[pStart+j];
            }
            if(stillEqual){
                return i;
            }
        }
        return -1;
    }*/
    
    /*public boolean isMatch(char s[], char p[], int sStart, int pStart) {
        if(sStart == s.length && pStart == p.length) {
            return true;
        }
        if(pStart == p.length) {
            return false;
        }
        // pStart < p.length
        if(p[pStart] == '*') {
            boolean matches = false; 
            for(int i = sStart; !matches && i < s.length; ++i) {
                matches = isMatch(s,p,i,pStart+1);
            }
            return matches;
        } 
        return sStart < s.length && (s[sStart] == p[pStart] || p[pStart] == '?')
        && isMatch(s,p,sStart+1,pStart+1);
    }*/
}
