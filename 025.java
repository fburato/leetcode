/*
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5 
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(k == 1) {
            return head;
        }
        int count = 1;
        ListNode n = head;
        while(n != null && count < k) {
            count++;
            n = n.next;
        }
        if(count < k || n == null) {
            return head;
        } else {
            ListNode rest = reverseKGroup(n.next,k);
            n.next = rest;
            ListNode next = head.next;
            ListNode prev = head;
            for(ListNode m = next; m != rest; m = next) {
                next = next.next;
                m.next = prev;
                prev = m;
            }
            head.next = rest;
            return prev;
        }
    }
}
