/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,0);
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null) {
            if(carry == 0) {
                return null;
            } else {
                return new ListNode(carry);
            }
        }
        // l1 != null || l2 != null
        if(l1 != null && l2 != null) {
            ListNode l = new ListNode((l1.val+l2.val+carry)%10);
            l.next = addTwoNumbers(l1.next,l2.next,(l1.val+l2.val+carry)/10);
            return l;
        }
        // l1 != null ^ l2 != null
        if(l1 == null) {
            return addTwoNumbers(l2,null,carry);
        }
        // l1 != null && l2 == null
        ListNode l = new ListNode((l1.val+carry) % 10);
        l.next = addTwoNumbers(l1.next,null,(l1.val+carry) / 10);
        return l;
    }
}
