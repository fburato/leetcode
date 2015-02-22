/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
*/

public class Solution {
    static class ListNode {
        public int start;
        public int end;
        public ListNode next;
        
        public ListNode(int s, int e, ListNode n) {
            start = s;
            end = e;
            next = n;
        }
    }
    
    public int longestValidParentheses(String s) {
        int start = 0;
        int end = s.length()-1;
        char c[] = s.toCharArray();
        while(start < end && c[start] == ')') {
            start++;
        }
        while(start < end && c[end] == '(') {
            end--;
        }
        // c[start] == '(' and is the first one, c[end] == ')' and is the last one
        ListNode list = findAllBases(c,start,end);
        boolean cont = true;
        while(cont) {
            cont = mergeContiguous(list) || augmentParenthesis(list,c,start,end);
        }
        int max = 0;
        for(ListNode l = list; l != null; l = l.next) {
            if(l.end-l.start+1 > max) {
                max = l.end-l.start+1;
            }
        }
        return max;
    }
    
    public ListNode findAllBases(char c[], int start, int end) {
        ListNode head = new ListNode(-1,-1,null);
        ListNode last = head;
        boolean lastIsOpen = true;
        for(int i = start+1; i <= end; ++i) {
            if(lastIsOpen && c[i] == ')') {
                last.next = new ListNode(i-1,i,null);
                last = last.next;
                lastIsOpen = false;
            } else {
                lastIsOpen = c[i] == '(';
            }
        }
        return head.next;
    }
    
    public boolean mergeContiguous(ListNode l) {
        if(l != null) {
            boolean modified = false;
            ListNode current = l;
            while(current != null) {
                while(current.next != null && current.end == current.next.start -1) {
                    current.end = current.next.end;
                    current.next = current.next.next;
                    modified = true;
                }
                current = current.next;
            }
            return modified;
        }
        return false;
    }
    
    public boolean augmentParenthesis(ListNode l, char c[], int start, int end) {
        if(l != null) {
            boolean modified = false;
            ListNode current = l;
            while(current != null) {
                while(current.start -1 >= start && current.end+1 <= end && c[current.start-1] == '(' && c[current.end+1] == ')') {
                    current.start = current.start -1;
                    current.end = current.end +1;
                    modified = true;
                }
                current = current.next;
            }
            return modified;
        }
        return false;
    }
}
