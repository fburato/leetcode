/*
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. 
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    class Pair{
        public ListNode first;
        public ListNode second;
        public Pair(ListNode f, ListNode s) {
            first = f;
            second = s;
        }
        
        public Pair(){
            this(null,null);
        }
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        Pair p = auxiliary(head,m,n);
        return p.first;
    }
    
    public Pair auxiliary(ListNode head, int m, int n) {
        if(head  == null) {
            return new Pair();
        }
        if(n == 1) {
            return new Pair(head,head);
        }
        // n > 1
        if(m <= 1) {
            Pair p = auxiliary(head.next,0,n-1);
            head.next = p.second.next;
            p.second.next = head;
            p.second = head;
            return p;
        }
        Pair p = auxiliary(head.next,m-1,n-1);
        head.next = p.first;
        p.first = head;
        return p;
    }
}
