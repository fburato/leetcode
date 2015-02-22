/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string. 
*/
public class Solution {
    
    public String say(String s) {
        String res = "";
        int i = 0;
        while(i < s.length()) {
            int count = 1;
            for(int j = i+1; j < s.length() && s.charAt(i) == s.charAt(j); ++j) {
                count++;
            }
            res = res + count + s.charAt(i);
            i = i + count;
        }
        return res;
    }
    public String countAndSay(int n) {
        int current = 1;
        String s = "1";
        while(current < n) {
            current++;
            s = say(s);
        }
        return s;
    }
}
