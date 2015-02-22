/*
 Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"]. 
*/
import java.util.LinkedList;

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String>[] division = (List<String>[]) new LinkedList[s.length()+1];
        division[s.length()] = new LinkedList<String>();
        division[s.length()].add("");
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(String s1 : dict) {
            if(s1.length() > max) {
                max = s1.length();
            }
            if(s1.length() < min) {
                min = s1.length();
            }
        }
        for(int i = s.length() - min; i >= 0; --i) {
            for(int j = min; j <= max && i+j <= s.length(); j++) {
                String first = s.substring(i,i+j);
                if(dict.contains(first) && division[i+j] != null) {
                    List<String> l = null;
                    if(division[i] == null) {
                        l = new LinkedList<String>();
                    } else {
                        l = division[i];
                    }
                    for(String s1 : division[i+j]) {
                        if(s1.equals("")) {
                            l.add(first);
                        } else {
                            l.add(first + " " + s1);
                        }
                    }
                    division[i] = l;
                }
            }
        }
        if(division[0] == null) {
            return new LinkedList<String>();
        } else {
            return division[0];
        }
    }
}
