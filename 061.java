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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || n <= 0) {
            return head;
        }
        // create a circular list and count the number of nodes
        int length = 1;
        ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head;
        n = length - n % length;
        while(n > 0) {
            head = head.next;
            tail = tail.next;
            n--;
        }
        tail.next = null;
        return head;
    }
}
