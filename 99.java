/*
 Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure. 
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
import java.util.ArrayList;
public class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null) {
            return ;
        }
        ArrayList<TreeNode> v = new ArrayList<TreeNode>();
        populateArray(root,v);
        int i = 0;
        while(i+1 < v.size() && v.get(i).val <= v.get(i+1).val) {
            i++;
        }
        // v.get(i) > v.get(i+1)
        int j = i+1;
        while(j+1 < v.size() && v.get(j).val <= v.get(j+1).val) {
            j++;
        }
        // v.get(j) > v.get(j+1)
        if(j +1 == v.size()) {
            j = i;
        }
        j++;
        int swap = v.get(i).val;
        v.get(i).val = v.get(j).val;
        v.get(j).val = swap;
    }
    
    public void populateArray(TreeNode root, ArrayList<TreeNode> v) {
        if(root != null) {
            populateArray(root.left,v);
            v.add(root);
            populateArray(root.right,v);
        }
    }
}
