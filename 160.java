/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.

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
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aSize = size(headA), bSize = size(headB);
        ListNode newA = headA, newB = headB;
        if(aSize > bSize) {
            for(int i = 0; i < aSize - bSize; ++i) {
                newA = newA.next;
            }
        } else if(bSize > aSize ) {
            for(int i = 0; i < bSize - aSize; ++i) {
                newB = newB.next;
            }
        }
        while(newA != null && newB != null && newB != newA) {
            newA = newA.next;
            newB = newB.next;
        }
        return newA;
    }
    
    public int size(ListNode head) {
        int count = 0;
        for(ListNode n = head; n != null; n = n.next) {
            count++;
        }
        return count;
    }
}
