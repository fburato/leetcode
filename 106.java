/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree. 
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
    public int indexOf(int[] order, int val, int start, int end) {
        int i = start;
        while(i <= end && order[i] != val) {
            i++;
        }
        if(i > end) {
            return -1;
        } else {
            return i;
        }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //TODO check input
        return buildTree(inorder,postorder,0,0,inorder.length);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int instart, int poststart, int length) {
        if(length == 0) {
            return null;
        }
        if(length == 1) {
            return new TreeNode(postorder[poststart]);
        }
        //length > 1
        int indexIn = indexOf(inorder,postorder[poststart+length-1],instart,instart+length-1);
        int newlength = indexIn - instart;
        TreeNode root = new TreeNode(postorder[poststart+length-1]);
        root.left = buildTree(inorder,postorder,instart,poststart,newlength);
        root.right = buildTree(inorder,postorder,indexIn+1,poststart+newlength,length-1-newlength);
        return  root;
    }
}
