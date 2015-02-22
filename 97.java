/*
 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false. 
*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(s1,s2,s3,0,0,0);
    }
    
    public boolean isInterleave(String s1, String s2, String s3, int i1, int i2, int i3) {
        if(i3 == s3.length()) {
            return true;
        }
        boolean match = false;
        if(i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            match = isInterleave(s1,s2,s3,i1+1,i2,i3+1);   
        }
        if(!match && i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            match = isInterleave(s1,s2,s3,i1,i2+1,i3+1);
        }
        return match;
    }
}
