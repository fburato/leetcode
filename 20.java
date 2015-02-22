/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public static class Node {
        public char info;
        public Node next;
        public Node(char i, Node n) {
            info = i;
            next = n;
        }
    }
    public boolean isValid(String s) {
        Node stack = null;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack = new Node(s.charAt(i),stack);
            } else if(stack == null){
                return false;
            } else {
                char last = stack.info;
                stack = stack.next;
                if(s.charAt(i) == ')' && last != '(' || 
                        s.charAt(i) == ']' && last != '[' ||
                        s.charAt(i) == '}' && last != '{') {
                    return false;            
                }
            }
        }
        return stack == null;
    }
}
