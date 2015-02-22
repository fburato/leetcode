/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int nextChar[] = getNextChar(s);
        int max = 0;
        for(int i = 0; i < s.length(); ++i) {
            int possibleMax = nextChar[i] - i;
            if(possibleMax > max) {
                for(int j = i+1; j < i+possibleMax; ++j) {
                    if(nextChar[j] < i+possibleMax) {
                        possibleMax = nextChar[j] - i;
                    }   
                }
            }
            if(possibleMax > max) {
                max = possibleMax;
            }
        }
        return max;
    }
    
    public int[] getNextChar(String s) {
        int nextChar[] = new int[s.length()];
        for(int i = s.length()-1; i >= 0; --i) {
            if(nextChar[i] == 0) {
                nextChar[i] = s.length();
                int last = i;
                for(int j = i-1; j >=0; --j) {
                    if(s.charAt(j) == s.charAt(i)){
                        nextChar[j] = last;
                        last = j;
                    }
                }
            }
        }
        return nextChar;
    }
    /*public int lengthOfLongestSubstring(String s, int start, int end) {
        // divide et impera: find longest substring before median, after median 
        // and in between
        if(start < end) {
            int med = (start+end) / 2;
            int leftMax = lengthOfLongestSubstring(s,start,med);
            int rightMax = lengthOfLongestSubstring(s,med+1,end);
            if(s.charAt(med) != s.charAt(med+1)) {
                int max = Math.max(2,Math.max(leftMax,rightMax));
                boolean cont = true;
                for(int i = med; cont && i >=0; --i) {
                    cont = !contains(s,s.charAt(i),i+1,med+1);
                    if(cont && med-i+1 > max) {
                        max = med-i+1;
                    }
                    boolean cont2 = cont;
                    for(int j=med+2; cont2 && j<=end;++j) {
                        cont2 = !contains(s,s.charAt(j),i,j-1);
                        if(cont2 && j-i+1 > max) {
                            max = j-i+1;
                        }
                    }
                }
                return max;
            } else {
                return Math.max(leftMax,rightMax);
            }
        }
        return 1;
    }
    
    // returns true iff all character from start to end (inclusive) in s are different
    public boolean allDifferent(String s, int start, int end) {
        for(int i = start; i < end; ++i) {
            for(int j = i+1; j <= end; ++j) {
                if(s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean contains(String s, char c, int start, int end) {
        for(int i = start; i < end; ++i) {
            if(s.charAt(i) == c) {
                return true;
            }  
        }
        return false;
    }*/
}
