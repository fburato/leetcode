/*
 Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}. 
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return ;
        }
        // at least three nodes
        ListNode prev = head;
        for(ListNode cur = prev.next; cur.next != null; cur = cur.next) {
            prev = prev.next;
        }
        //prev points to the node before the last
        ListNode last = prev.next;
        prev.next = null;
        reorderList(head.next);
        last.next = head.next;
        head.next = last;
    }
    
    public int length(ListNode head) {
        int count = 0;
        for(ListNode n = head; n != null; n = n.next) {
            count++;
        }
        return count;
    }
    
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newhead = head.next, remaining = newhead.next;
        newhead.next = head;
        head.next = null;
        while(remaining != null) {
            ListNode p = remaining;
            remaining = remaining.next;
            p.next = newhead;
            newhead = p;
        }
        return newhead;
        
    }
}
