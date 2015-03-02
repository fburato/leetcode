/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
import java.util.LinkedList;
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0) {
            List<TreeNode> empty = new LinkedList<TreeNode>();
            empty.add(null);
            return empty;
        }
        return generateTrees(1,n);
    }
    
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if(start == end) { 
            list.add(new TreeNode(start));
        } else {
            for(int begin = start; begin <= end; ++begin) {
                if(begin == start) {
                    List<TreeNode> right = generateTrees(begin+1,end);
                    for(TreeNode p : right) {
                        TreeNode t = new TreeNode(begin);
                        t.right = p;
                        list.add(t);
                    }
                } else if(begin == end) {
                    List<TreeNode> left = generateTrees(start,begin-1);
                    for(TreeNode p : left) {
                        TreeNode t = new TreeNode(begin);
                        t.left = p;
                        list.add(t);
                    }
                } else {
                    List<TreeNode> left = generateTrees(start, begin-1);
                    List<TreeNode> right = generateTrees(begin+1,end);
                    for(TreeNode l : left) {
                        for(TreeNode r : right) {
                            TreeNode t = new TreeNode(begin);
                            t.left = l;
                            t.right = r;
                            list.add(t);
                        }
                    }
                }
            }
        }
        return list;
    }
}
