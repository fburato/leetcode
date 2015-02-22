/*
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

return

[
   [5,4,11,2],
   [5,8,4,5]
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
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> partial = new LinkedList<>();
        pathSum(root,sum,res,partial);
        return res;
    }
    
    public void pathSum(TreeNode root, int sum, List<List<Integer>> res, LinkedList<Integer> partial) {
        if(root == null) {
            return ;
        }
        if(root.left == null && root.right == null && root.val == sum) {
            partial.addLast(root.val);
            res.add((List<Integer>) partial.clone());
            partial.removeLast();
            return ;
        }
        if(root.left != null) {
            partial.addLast(root.val);
            pathSum(root.left,sum-root.val,res,partial);
            partial.removeLast();
        }
        if(root.right != null) {
            partial.addLast(root.val);
            pathSum(root.right,sum-root.val,res,partial);
            partial.removeLast();
        }
    }
}
