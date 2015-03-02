/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,3,2].

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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) {
            return res;
        }
        TreeNode t = root;
        LinkedList<TreeNode> parents = new LinkedList<>();
        while(t.left != null) {
            parents.addLast(t);
            t = t.left;
        }
        while(t != null) {
            res.add(t.val);
            if(t.right != null) {
                parents.addLast(t);
                t = t.right;
                while(t.left != null) {
                    parents.addLast(t);
                    t = t.left;
                }
            } else if(parents.isEmpty()) {
                t = null;
            } else {
                TreeNode p = parents.removeLast();
                if(p.right == t) {
                    while(!parents.isEmpty() && p.right == t) {
                        t = p;
                        p = parents.removeLast();
                    }
                    if(p.right == t) {
                        p= null;
                    }
                }
                t = p;
            }
        }
        return res;
        
    }
}
