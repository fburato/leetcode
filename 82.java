/*
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3. 
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        return deleteDuplicates(head,head.val, true);
    }
    
    // PRE p !=null, first -> p.val == val,
    public ListNode deleteDuplicates(ListNode p, int val, boolean first) {
        if(p == null) {
            return null;
        }
        if(p.next == null) {
            if(p.val == val && !first) {
                return null;
            } else {
                return p;
            }
        }
        //p.next != null
        if(first) {
            // p.val == val
            if(p.next.val == val) {
                return deleteDuplicates(p.next.next,val,false);
            } else {
                p.next = deleteDuplicates(p.next,p.next.val,true);
                return p;
            }
        } else {
            if(p.val == val){
                return deleteDuplicates(p.next,val,false);
            } else {
                return deleteDuplicates(p,p.val,true);
            }
        }
    }
}
