/*
 Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". 
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.equals("")) {
            return false;
        }
        if(dict.contains(s)) {
            return true;
        }
        boolean broke[] = new boolean[s.length()+1];
        broke[s.length()] = true;
        int maxSize = 0;
        for(String s1 : dict) {
            if(s1.length() > maxSize){
                maxSize = s1.length();
            }
        }
        for(int i = s.length()-1; i >= 0; --i) {
            boolean found = false;
            for(int j = 1; !found && i+j <= s.length() && j <= maxSize; ++j) {
                String f = s.substring(i,i+j);
                if(dict.contains(f) && broke[i+j]) {
                    found = true;
                }
            }
            broke[i] = found;
        }
        return broke[0];
    }
}
