/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
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
import java.util.LinkedList;
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size() == 0) {
            return null;
        }
        LinkedList<ListNode> result = new LinkedList<>();
        for(ListNode l : lists) {
            result.addLast(l);
        }
        while(result.size() > 1) {
            ListNode list1 = result.removeFirst();
            ListNode list2 = result.removeFirst();
            result.addLast(mergeLists(list1,list2));
        }
        return result.removeFirst();
    }
    
    public ListNode mergeLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return null;
        }
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        if(list1.val <= list2.val) {
            ListNode rest = mergeLists(list1.next,list2);
            list1.next = rest;
            return list1;
        }
        return mergeLists(list2,list1);
    }
}
