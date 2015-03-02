/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    private ListNode newHead;
    private ListNode tail;
    public ListNode rotateRight(ListNode head, int n) {
        newHead = head;
        rotateRight(head,head,n,0);
        return newHead;
    }
    
    public int rotateRight(ListNode l, ListNode head, int n, int cur) {
        if(l == null) {
            return cur;
        }
        int size = rotateRight(l.next,head,n,cur+1);
        n = n %size;
        if(l.next == null) {
            tail = l;
        } else if(size - cur == n+1){
            tail.next = head;
            newHead = l.next;
            l.next = null;
        }
        return size;
    }
}
