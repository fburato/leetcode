/*
 Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode p1 = head, p2 = head;
        boolean first = true;
        while(p1 != null && p2 != null && p1.next != null && p2.next != null && (first || p1 != p2)) {
            p1 = p1.next;
            p2 = p2.next.next;
            first = false;
        }
        if(p1 == null || p2 == null || p1.next == null || p2.next == null) {
            return false;
        } else {
            return true;
        }
    }
}
