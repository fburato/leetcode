/*
 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].

*/
import java.util.*;
public class Solution {
    static class SubString {
        private String origString;
        class Limits {
            private int start;
            private int end;
            public Limits(int s, int e) {
                start = s;
                end = e;
            }
            
            public int hashCode() {
                int hash = 0;
                for (int i = start; i <= end; i++) {
                    hash = 31*hash + origString.charAt(i);
                }
                return hash;
            }
            
            public boolean equals(Object o) {
                if(o instanceof Limits) {
                    Limits other = (Limits) o;
                    boolean stillEquals = end - start == other.end - other.start;
                    for(int i = 0; stillEquals && i < end - start+1; ++i) {
                        stillEquals = origString.charAt(start+i) == origString.charAt(other.start+i);
                    }
                    return stillEquals;
                }
                return false;
            }
            
            public String toString(){
                return origString.substring(start,end+1);
            }
        } 
        public SubString(String s) {
            origString = s;
        }
        
        public Limits substring(int start, int end) {
            if(start >= 0 && start <= origString.length() 
                && end >= 0 && end <= origString.length() 
                && start <= end) {
                return new Limits(start,end);
            }
            return null;
        }
    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<>();
        SubString generator = new SubString(s);
        HashMap<SubString.Limits,Integer> found = new HashMap<>();
        for(int i = 0; i <= s.length()-10; ++i) {
            SubString.Limits sub = generator.substring(i,i+9);
            Integer num = found.get(sub);
            if(num == null) {
                num = 1;
            } else {
                if(num == 1) {
                    result.add(sub.toString());
                }
                num = num +1;
            }
            found.put(sub,num);
        }
        return result;
    }
}
