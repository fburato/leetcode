/*
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list. 
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
import java.util.HashMap;
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> pointers = new HashMap<>();
        RandomListNode copy = deepCopy(head,pointers);
        fixPointers(copy,pointers);
        return copy;
    }
    
    public RandomListNode deepCopy(RandomListNode head, HashMap<RandomListNode,RandomListNode> map) {
        if(head == null) {
            return null;
        }
        RandomListNode copy = new RandomListNode(head.label);
        map.put(head,copy);
        copy.random = head.random;
        RandomListNode prev = copy;
        for(RandomListNode t = head.next; t != null; t = t.next) {
            prev.next = new RandomListNode(t.label);
            prev.next.random = t.random;
            map.put(t, prev.next);
            prev = prev.next;
        }
        return copy;
    }
    
    public void fixPointers(RandomListNode head1, HashMap<RandomListNode,RandomListNode> map) {
        for(RandomListNode t = head1; t != null; t = t.next) {
            if(t.random != null) {
                t.random = map.get(t.random);
            }
        }
    }
}
