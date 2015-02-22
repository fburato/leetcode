/*
 Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

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
    public void flatten(TreeNode root) {
        flattenAux(root);
    }
    
    public TreeNode flattenAux(TreeNode root) {
        if(root == null) {
            return null;
        }
        // single node
        if(root.left == null && root.right == null) {
            TreeNode n = new TreeNode(0);
            n.left = root;
            n.right = root;
            return n;
        }
        // at least one child
        TreeNode flatLeft = flattenAux(root.left), flatRight = flattenAux(root.right);
        root.left = null;
        if(flatLeft == null) {
            // flatRight must be not null
            root.right = flatRight.left;
            flatRight.left = root;
            return flatRight;
        }
        if(flatRight == null) {
            root.right = flatLeft.left;
            flatLeft.left = root;
            return flatLeft;
        }
        // both flatLeft and flatRight are defined
        root.right = flatLeft.left;
        flatLeft.right.right = flatRight.left;
        flatLeft.left = root;
        flatLeft.right = flatRight.right;
        return flatLeft;
    }
}
