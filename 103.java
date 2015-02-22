/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> first = new LinkedList<>();
        LinkedList<TreeNode> second = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> partial = new LinkedList<>();
        boolean right = true; 
        if(root != null) {
            first.addLast(root);
        }
        while(!first.isEmpty()) {
            TreeNode t = null;
            if(right) {
                t = first.removeFirst();
            } else {
                t = first.removeLast();
            }
            partial.add(t.val);
            if(right) {
                if(t.left != null) {
                    second.addLast(t.left);
                }
                if(t.right != null) {
                    second.addLast(t.right);
                }
            } else {
                if(t.right != null) {
                    second.addFirst(t.right);
                }
                if(t.left != null) {
                    second.addFirst(t.left);
                }
            }
            if(first.isEmpty()) {
                first = second;
                right = !right;
                res.add(partial);
                second = new LinkedList<>();
                partial = new LinkedList<>();
            }
        }
        return res;
    }
}
