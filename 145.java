/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
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
import java.util.LinkedList;
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> postorder = new LinkedList<>();
        LinkedList<TreeNode> lefts = new LinkedList<>();
        LinkedList<TreeNode> rights = new LinkedList<>();
        TreeNode p = root;
        while(p != null) {
            postorder.addFirst(p.val);
            if(p.left != null) {
                lefts.addFirst(p.left);
            }
            if(p.right != null) {
                rights.addFirst(p.right);
            }
            if(!rights.isEmpty()) {
                p = rights.removeFirst();
            } else if(!lefts.isEmpty()) {
                p = lefts.removeFirst();
            } else {
                p = null;
            }
        }
        return postorder;
    }
}
