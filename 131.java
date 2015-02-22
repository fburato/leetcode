/*
 Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]

*/
import java.util.LinkedList;
public class Solution {
    
    public boolean isPalindrome(String s) {
        for(int i = 0; i < s.length() / 2; ++i) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> list = new LinkedList<>();
        if(s == null || s.length() == 0) {
            return list;
        }
        if(s.length() == 1) {
            List<String> tmp = new LinkedList<>();
            tmp.add(s);
            list.add(tmp);
            return list;
        }
        // s.length() > 1
        for(int i = 1; i <= s.length(); ++i) {
            String first = s.substring(0,i);
            String rest = s.substring(i,s.length());
            if(isPalindrome(first)) {
                List<List<String>> partitions = partition(rest);
                if(partitions.size() == 0) {
                    List<String> tmp = new LinkedList<>();
                    tmp.add(first);
                    list.add(tmp);
                } else {
                    for(List<String> l : partitions) {
                        l.add(0,first);
                        list.add(l);
                    }
                }
            }
        }
        return list;
    }
}
