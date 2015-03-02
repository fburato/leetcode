/*
 You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter). 
*/
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    
    
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer>  res = new ArrayList<>();
        if(L == null || S == null || S.length() == 0 || L.length == 0 || L[0] == null || L[0].length() == 0) {
            return res;
        }
        int fragmentSize = L[0].length();
        int substringSize = fragmentSize * L.length;
        HashMap<String,Integer> indexes = new HashMap<>();
        int start = 0;
        int originalCount[] = new int[L.length];
        for(int i = 0; i < L.length; ++i) {
            Integer ind = indexes.get(L[i]);
            if(ind == null) {
                indexes.put(L[i],start);
                originalCount[start]++;
                start++;
            } else {
                originalCount[ind]++;
            }
        }
        for(int i = 0; i < S.length()-substringSize+1; ++i) {
            int matched[] = new int[start];
            for(int j = 0; j < start; j++) {
                matched[j] = originalCount[j];
            } 
            boolean stillMatch = true;
            for(int j = 0; stillMatch && j < substringSize; j = j+fragmentSize) {
                Integer index = indexes.get(S.substring(i+j,i+j+fragmentSize));
                if(index == null || matched[index] == 0) {
                    stillMatch = false;
                } else {
                    // index != null && !matched[index]
                    matched[index]--;
                }
            }
            if(stillMatch) {
                res.add(i);
            }
        }
        return res;
    }
}
