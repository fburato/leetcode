/*
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode newhead = null;
        ListNode n = head;
        while(n != null) {
            ListNode next = n.next;
            newhead = insert(n,newhead);
            n = next;
        }
        return newhead;
    }
    
    public ListNode insert(ListNode n, ListNode list) {
        if(list == null) {
            n.next = null;
            return n;
        }
        if(n.val < list.val) {
            n.next = list;
            return n;
        }
        ListNode prev = list;
        ListNode cur;
        for(cur = prev.next; cur != null && n.val >= cur.val; ){
            cur = cur.next;
            prev = prev.next;
        }
        // n.val >= prev.val || cur == null
        prev.next = n;
        if(cur == null) {
            n.next = null;
        } else {
            n.next = cur;
        }
        return list;
    }
}
