/*
 Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t

To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t

We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a

We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1. 
*/
import java.util.HashMap;

public class Solution {
    
    public static void add(HashMap<Character,Integer> map, char c) {
        Integer i = map.get(c);
        if(i == null) {
            map.put(c,1);
        } else {
            map.put(c,i+1);
        }
    }
    
    public static boolean remove(HashMap<Character,Integer> map, char c){
        Integer i = map.get(c);
        if(i == null || i == 0){
            return false;
        } else {
            map.put(c,i-1);
            return true;
        }
    }
    public boolean isFirst(String s2, HashMap<Character,Integer> left, HashMap<Character,Integer> right, int i) {
        HashMap<Character,Integer> lcopy = (HashMap<Character,Integer>) left.clone();
        HashMap<Character,Integer> rcopy = (HashMap<Character,Integer>) right.clone();
        boolean cont = true;
        for(int j = 0; cont && j < i; ++j) {
            cont = remove(lcopy,s2.charAt(j));
        }
        for(int j = i; cont && j < s2.length(); ++j) {
            cont = remove(rcopy,s2.charAt(j));
        }
        return cont;
    }
    
    public boolean isSecond(String s2, HashMap<Character,Integer> left, HashMap<Character,Integer> right, int i) {
        return isFirst(s2,right,left,s2.length()-i);
    }
    
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        //s1 != null && s2 != null && s1.length() == s2.length()
        if(s1.length() == 1 ) {
            return s1.charAt(0) == s2.charAt(0);
        }
        // find the scrambleing point
        boolean found = false;
        // create sets of character at the left and at the right
        HashMap<Character,Integer> left = new HashMap<Character,Integer>(), right = new HashMap<>(s1.length());
        for(int j = 0; j < s1.length(); ++j) {
            add(right,s1.charAt(j));
        }
        for(int i = 1; !found && i < s1.length(); ++i) {
            remove(right,s1.charAt(i));
            add(left,s1,charAt(i));
            String s11 = s1.substring(0,i), s12 = s1.substring(i,s1.length());
            String s21 = s2.substring(0,i), s22 = s2.substring(i,s1.length());
            String s23 = s2.substring(0,s1.length()-i), s24 = s2.substring(s1.length()-i,s1.length());
            // two possible scrambleing point for s2, the first at i, the second at s1.length()-i 
            boolean first = isFirst(s2,left,right,i);
            boolean second = isSecond(s2,left,right,i);
            if(first && second) {
                // possible only if s1.length() / 2 == i and the two substring contains all the same characters
                found = isScramble(s11,s21) && isScramble(s12,s22) || isScramble(s11,s22) && isScramble(s12,s21);
            } else if(first) {
                found = isScramble(s11,s21) && isScramble(s12,s22);
            } else if(second) {
                found = isScramble(s11,s24) && isScramble(s12,s23);
            }
        }
        return found;
    }
    /*public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        //s1 != null && s2 != null && s1.length() == s2.length()
        if(s1.length() == 1 ) {
            return s1.charAt(0) == s2.charAt(0);
        }
        // s2.length() >= 2
        int divide = s1.length() / 2;
        // compute possible scrambles
        for(int i = 1; i < s1.length(); ++i) {
            String s11 = s1.substring(0,i), s12 = s1.substring(i,s1.length());
            String s21 = s1.substring(0,i), s22 = s2.substring(i,s2.length());
            String s13 = s1.substring(0,s1.length()-i), s14 = s1.substring(s1.length()-i,s1.length());
            String s23 = s2.substring(0,s1.length()-i), s24 = s2.substring(s1.length()-i,s1.length());
            if(isScramble(s11,s21) && isScramble(s12,s22) || isScramble(s11,s24) && isScramble(s12,s23) ||
                    isScramble(s13,s22) && isScramble(s14,s21) || isScramble(s13,s23) && isScramble(s14,s24)) {
                        return true;
            }
        }
        return false;
    }*/
}
