/*
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome. 
*/
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.equals("")) {
            return true;
        }
        char[] v = s.toLowerCase().toCharArray();
        int begin = nextAlfa(v,0), end = prevAlfa(v,v.length-1);
        while(begin < end && v[begin] == v[end]) {
            begin = nextAlfa(v,begin+1);
            end = prevAlfa(v,end-1);
        }
        if(begin < v.length && end >= 0 && v[begin] != v[end]) {
            return false;
        }
        return true;
    }
    
    public int nextAlfa(char[] v, int start) {
        while(start < v.length && !(v[start] >= 'a' && v[start] <= 'z' || v[start] >= '0' && v[start] <= '9')) {
            start++;
        }
        return start;
    }
    
    public int prevAlfa(char[] v, int start) {
        while(start >= 0 && !(v[start] >= 'a' && v[start] <= 'z' || v[start] >= '0' && v[start] <= '9')) {
            start--;
        }
        return start;
    }
}
