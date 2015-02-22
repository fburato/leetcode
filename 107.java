/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<TreeNode> first = new LinkedList<>();
        LinkedList<TreeNode> second = new LinkedList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
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
                res.addFirst(partial);
                second = new LinkedList<>();
                partial = new LinkedList<>();
            }
        }
        return res;
    }
}
