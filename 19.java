/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass. 
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
    public int size = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNthFromEnd(head,n,1);
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n, int current) {
        if(head == null) {
            size = current;
            return null;
        }
        head.next = removeNthFromEnd(head.next, n, current+1);
        if(size - current == n){
            return head.next;
        } else {
            return head;
        }
    }
}
