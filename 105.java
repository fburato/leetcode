/*
Given preorder and inorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // TODO check input size
        if(preorder == null || inorder == null) {
            return null;
        }
        return buildTree(preorder,inorder,0,0,preorder.length);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int instart, int prestart, int length) {
        if(length == 0) {
            return null;
        }
        if(length == 1) {
            return new TreeNode(preorder[prestart]);
        }
        //length > 1
        int indexIn = indexOf(inorder,preorder[prestart],instart,instart+length-1);
        int newlength = indexIn - instart;
        TreeNode root = new TreeNode(preorder[prestart]);
        root.left = buildTree(preorder,inorder,instart,prestart+1,newlength);
        root.right = buildTree(preorder,inorder,indexIn+1,prestart+1+newlength,length-1-newlength);
        return  root;
    }
}
