/*
 Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3

Return 6. 
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
    class Pair<T,S> {
        public T first;
        public S second;
        public Pair(T f, S s) {
            first = f;
            second = s;
        }
    }
    public int maxPathSum(TreeNode root) {
        Pair<Integer,Integer> p = maxPathSumAux(root);
        if(p.first > p.second) {
            return p.first;
        } else {
            return p.second;
        }
    }
    
    public Pair<Integer,Integer> maxPathSumAux(TreeNode root) {
        if(root == null) {
            return new Pair<>(0,0);
        }
        if(root.left == null && root.right == null) {
            return new Pair<>(root.val,root.val);
        }
        if((root.left == null) == (root.right != null)) {
            Pair<Integer,Integer> son = null;
            if(root.right != null) {
                son = maxPathSumAux(root.right);
            } else {
                son = maxPathSumAux(root.left);
            }
            int maxInner = root.val,
                maxPath = root.val;
            if(maxInner < son.first) {
                maxInner = son.first;
            }
            if(maxInner < son.second + root.val) {
                maxInner = son.second + root.val;
            }
            if(maxPath < son.second + root.val) {
                maxPath = son.second + root.val;
            }
            son.first = maxInner;
            son.second = maxPath;
            return son;
        }
        // root.left != null && root.right != null
        Pair<Integer,Integer> left = maxPathSumAux(root.left), right = maxPathSumAux(root.right);
        int maxInner = root.val,
            maxPath = root.val;
        if(maxInner < left.first) {
            maxInner = left.first;
        }
        if(maxInner < right.first) {
            maxInner = right.first;
        }
        if(maxInner < left.second + right.second + root.val) {
            maxInner = left.second + right.second + root.val;
        }
        if(maxInner < left.second + root.val) {
            maxInner = left.second + root.val;
        }
        if(maxInner < right.second + root.val) {
            maxInner = right.second + root.val;
        }
        if(maxPath < left.second + root.val) {
            maxPath = left.second + root.val;
        }
        if(maxPath < right.second + root.val) {
            maxPath = right.second + root.val;
        }
        left.first = maxInner;
        left.second = maxPath;
        return left;
    }
}
