/*
 Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        for(int i =0 ; i < haystack.length() - needle.length() +1; ++i) {
            if(match(haystack,needle,i)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean match(String source, String target, int origin) {
        int i;
        for(i = 0; i < target.length() && origin+i < source.length(); ++i) {
            if(source.charAt(origin+i) != target.charAt(i)){
                return false;
            }
        }
        return i == target.length();
    }
}
