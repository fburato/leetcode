/*
 Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

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
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isValidBSTLeft(root.left,root.val) && isValidBSTRight(root.right,root.val);
    }
    
    public boolean isValidBST(TreeNode root, int left, int right) {
        if(root == null) {
            return true;
        }
        return left < root.val && root.val < right && isValidBST(root.left,left,root.val) && isValidBST(root.right,root.val, right);
    }
    public boolean isValidBSTLeft(TreeNode root, int right) {
        if(root == null) {
            return true;
        }
        return root.val < right && isValidBSTLeft(root.left,root.val) && isValidBST(root.right,root.val,right);
    }
    
    public boolean isValidBSTRight(TreeNode root, int left) {
        if(root == null) {
            return true;
        }
        return left < root.val && isValidBSTRight(root.right, root.val) && isValidBST(root.left,left,root.val);
    }
}
