/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree. 
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
import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> parents; // parents.peek() is parent of current
    private TreeNode current;
    public BSTIterator(TreeNode root) {
        parents = new Stack<>();
        current = root;
        // set current to 
        if(current != null) {
            while(current.left != null) {
                parents.push(current);
                current = current.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current != null;
    }

    /** @return the next smallest number */
    public int next() {
        int val = current.val;
        current = successor(current);
        return val;
    }
    private TreeNode successor(TreeNode cur) {
        if(cur.right != null) {
            parents.push(cur);
            TreeNode n = cur.right;
            while(n.left != null) {
                parents.push(n);
                n = n.left;
            }
            return n;
        }
        if(parents.isEmpty()) {
            return null;
        }
        TreeNode p = parents.pop();
        while(p != null && cur == p.right) {
            cur = p;
            if(parents.isEmpty()) {
                p = null;
            } else {
                p = parents.pop();
            }
        }
        return p;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
