/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> first = new LinkedList<>();
        LinkedList<TreeNode> second = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> partial = new LinkedList<>();
        if(root != null) {
            first.addLast(root);
        }
        while(!first.isEmpty()) {
            TreeNode t = first.removeFirst();
            partial.add(t.val);
            if(t.left != null) {
                second.addLast(t.left);
            }
            if(t.right != null) {
                second.addLast(t.right);
            }
            if(first.isEmpty()) {
                first = second;
                res.add(partial);
                second = new LinkedList<>();
                partial = new LinkedList<>();
            }
        }
        return res;
    }
}
