/*
 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"

Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S. 
*/
import java.util.HashMap;
import java.util.LinkedList;
public class Solution {
    /*public String minWindow(String S, String T) {
        // TODO check input
        HashMap<Character,Integer> lastChar = new HashMap<>();
        HashMap<Character,Integer> repetitions = new HashMap<>();
        HashMap<Character,Integer> counted = new HashMap<>();
        for(char c : T.toCharArray()) {
            lastChar.put(c,-1);
            Integer i = repetitions.get(c);
            if(i == null) {
                repetitions.put(c,1);
            } else {
                repetitions.put(c,i+1);
            }
        }
        char[] c = S.toCharArray();
        int minimalWindows = c.length+1;
        int initialIndex = -1;
        int countMatched = 0;
        // find first window
        int i;
        for(i = 0; i < c.length && minimalWindows == c.length+1; ++i) {
            Integer pos = lastChar.get(c[i]);
            if(pos != null) {
                if(initialIndex == -1) {
                    initialIndex = i;
                }
                if(pos == -1) {
                    counted.put(c[i],1);
                    lastChar.put(c[i],i);
                } else if(repetitions.get(c[i]) == counted.put(c[i],1)){
                    int index = i;
                    for(int j = lastChar.get(c[i]) +1 ; index == i && j <= i; ++j) {
                        if(c[j] == c[i]) {
                            index = j;
                        }
                    }
                    lastChar.put(c[i],j);
                }
                if(repetitions.get(c[i]) > 0) {
                    repetitions.put(c[i],repetitions.get(c[i])-1);
                    countMatched++;   
                }
                if(countMatched ==  T.length()) {
                    minimalWindows = i-initialIndex+1;
                }
            }
        }
        // if initialIndex has not been setup then there is not T in S
        if(minimalWindows == c.length+1) {
            return "";
        }
        // now try other windows
        while(i < c.length) {
            if(c[i] == c[initialIndex]) {
                // I can substitute the initialIndex, first find the next last for c[i]
                int index = i;
                for(int j = initialIndex+1; index == i && j <=i; ++j) {
                    if(c[j] == c[i]) {
                        index = j;
                    }
                }
                lastChar.put(c[i],index);
                // find the new initialIndex
                int minimal = i;
                for(int j : lastChar.values()) {
                    if(j < minimal) {
                        minimal = j;
                    }
                }
                initialIndex = minimal;
                if(minimalWindows > i-initialIndex+1) {
                    minimalWindows = i-initialIndex+1;
                }
            }
            ++i;
        }
        return S.substring(initialIndex,initialIndex+minimalWindows);
    }*/
    public String minWindow(String S, String T) {
        HashMap<Character,LinkedList<Integer>> indexes = new HashMap<>();
        HashMap<Character,Integer> repetitions = new HashMap<>();
        // init the maps
        for(char c : T.toCharArray()){
            if(indexes.get(c) == null) {
                indexes.put(c,new LinkedList<Integer>());
                repetitions.put(c,1);
            } else {
                repetitions.put(c,repetitions.get(c)+1);
            }
        }
        // find first window if present
        char[] c = S.toCharArray();
        int minimalWindow = c.length+1;
        int initialIndex = -1;
        int countMatched = 0;
        int i;
        for(i = 0; i < c.length && minimalWindow == c.length+1; ++i) {
            LinkedList<Integer> list = indexes.get(c[i]);
            if(list != null) {
                if(initialIndex == -1) {
                    initialIndex = i;
                }
                if(list.size() < repetitions.get(c[i])) {
                    countMatched++;
                } 
                list.addLast(i);
                if(countMatched == T.length()) {
                    minimalWindow = i-initialIndex+1;
                }
            }
        }
        if(minimalWindow == c.length+1) {
            return "";
        }
        initialIndex = sanitize(indexes,repetitions,i);
        int minimalBegin = initialIndex;
        minimalWindow = i-initialIndex;
        // look for smaller windows
        while(i < c.length) {
        	LinkedList<Integer> list = indexes.get(c[i]);
            if(list != null) {
                list.addLast(i);
                if(c[i] == c[initialIndex]) {
                	list.removeFirst();
                	initialIndex = sanitize(indexes,repetitions,i);
                	if(minimalWindow > i-initialIndex +1) {
                		minimalWindow = i-initialIndex + 1;
                		minimalBegin = initialIndex;
                	}
                }
            }
            ++i;
        }
        return S.substring(minimalBegin,minimalBegin+minimalWindow);
    }
    
    public int getMinimal(HashMap<Character,LinkedList<Integer>> map, int max) {
        int minimal = max;
        for(LinkedList<Integer> l : map.values()) {
            if(!l.isEmpty() && l.getFirst() < minimal) {
                minimal = l.getFirst();
            }
        }
        return minimal;
    }
    
    public int sanitize(HashMap<Character, LinkedList<Integer>> map , HashMap<Character,Integer> repetitions, int max) {
        int minimal = max;
        for(char c : map.keySet()) {
            LinkedList<Integer> list = map.get(c);
            while(list.size() > repetitions.get(c)) {
                list.removeFirst();
            }
            if(list.getFirst() < minimal) {
                minimal = list.getFirst();
            }
        }
        return minimal;
    }
}
