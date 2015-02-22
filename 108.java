/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null) {
            return null;
        }
        return sortedArrayToBST(num,0,num.length);
    }
    
    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if(start == end) {
            return null;
        }
        // start < end
        int med = (start+end)/2;
        TreeNode root = new TreeNode(num[med]);
        root.left = sortedArrayToBST(num,start,med);
        root.right = sortedArrayToBST(num,med+1,end);
        return root;
    }
}
