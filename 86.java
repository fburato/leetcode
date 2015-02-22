/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. 
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
    class Tria {
        public ListNode first;
        public ListNode second;
        public ListNode third;
        public Tria(ListNode f, ListNode s, ListNode t) {
            first = f;
            second = s;
            third = t;
        }
    }
    public ListNode partition(ListNode head, int x) {
        Tria t = lastLess(head,x);
        if(t.first == null) {
            t.first = t.third;
        }
        return t.first;
    }
    
    public Tria lastLess(ListNode head, int x) {
        if(head == null) {
            return new Tria(null,null,null);
        }
        Tria p = lastLess(head.next,x);
        if(head.val <= x){
            head.next = p.first;
            p.first = head;
            if(p.second == null) {
                p.second = p.first;
            }
        } else {
            head.next = p.third;
            p.third = head;
        }
        if(p.second != null) {
            p.second.next = p.third;
        }
        return p;
    }
    
}
