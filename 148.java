/*
Sort a linked list in O(n log n) time using constant space complexity.
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
    static class Res{
        public ListNode first, second;
        public Res(ListNode f, ListNode s) {
            first = f;
            second = s;
        }
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null) {
            return null;
        }
        Res r = sortListAux(head);
        return r.first;
    }
    
    public Res sortListAux(ListNode head) {
        if(head.next != null) {
            Res p = partition(head);
            if(p.first == null) {
                Res sorted = sortListAux(p.second);
                head.next = sorted.first;
                sorted.first = head;
                return sorted;
            } else if(p.second == null) {
                Res sorted = sortListAux(head.next);
                p.first.next = head;
                head.next = null;
                sorted.second = head;
                return sorted;
            } else {
                Res sorted1 = sortListAux(head.next);
                Res sorted2 = sortListAux(p.second);
                sorted1.second.next = head;
                head.next = sorted2.first;
                p.first = sorted1.first;
                p.second = sorted2.second;
                return p;
            }
        } else {
           return new Res(head,head); 
        }
    }
    
    public Res partition(ListNode head) {
        ListNode pivot = head;
        ListNode head1 = null, tail1 = null, head2 = null, tail2 = null, n = head.next;
        while(n != null) {
            ListNode next = n.next;
            if(n.val > pivot.val) {
                if(head1 == null) {
                    tail1 = head1 = n;
                } else {
                    tail1.next = n;
                    tail1 = n;
                }
            } else {
                if(head2 == null) {
                    tail2 = head2 = n;
                    
                } else {
                    tail2.next = n;
                    tail2 = n;
                }
            }
            n.next = null;
            n = next;
        }
        pivot.next = head1;
        return new Res(tail1,head2);
    }
}
