/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/
public class Solution {
    public int numTrees2(int n) {
        return numTrees(1,n);
    }
    
    public int numTrees(int start, int end) {
        if(start == end) {
            return 1;
        }
        int total = 0;
        for(int i = start; i <= end; ++i) {
            if(i== start) {
                total = total + numTrees(start+1,end);
            } else if(i == end) {
                total = total + numTrees(start, end-1);
            } else {
                int left = numTrees(start,i-1);
                int right = numTrees(i+1,end);
                total = total + left*right;
            }
        }
        return total;
    }
    
    public int numTrees(int n) {
        if(n<=1) {
            return 1;
        }
        //n >= 2
        int previous[] = new int[n];
        previous[0] = 1;
        for(int i = 2; i <= n ;++i) {
            int total = 0;
            for(int left = 0; left < i; ++left) {
                int right = i-1-left;
                if(left == 0) {
                    total += previous[right-1];
                } else if(right == 0) {
                    total += previous[left-1];
                } else {
                    total += previous[left-1] * previous[right-1];
                }
            }
            previous[i-1] = total;
        }
        return previous[n-1];
    }
}
