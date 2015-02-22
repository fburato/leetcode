/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public int count(ListNode head) {
        int total = 0;
        while(head != null) {
            total++;
            head = head.next;
        }
        return total;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        ListNode headPointer = new ListNode(0);
        headPointer.next = head;
        return sortedListToBST(headPointer,count(head));
    }
    
    public TreeNode sortedListToBST(ListNode headPointer, int n) {
        if(n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(0);
        root.left = sortedListToBST(headPointer,n/2);
        root.val = headPointer.next.val;
        headPointer.next = headPointer.next.next;
        root.right = sortedListToBST(headPointer,n-(n/2)-1);
        return root;
    }
}
