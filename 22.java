/*
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()" 
*/

import java.util.LinkedList;

public class Solution {
    
    public List<String> generateParenthesis(int n) {
        if(n < 0) {
            return null;
        }
        LinkedList<String> par[] =(LinkedList<String>[]) new LinkedList[n+1];
        for(int i = 0; i < par.length; ++i) {
            par[i] = new LinkedList<>();
        }
        par[0].add("");
        for(int i = 1; i <= n; ++i) {
            for(int j = 0; j <= i-1; ++j) {
                for(String intern : par[j]) {
                    for(String extern : par[i-1-j]) {
                        par[i].add("("+intern+")"+extern);
                    }
                }
            }
        }
        return par[n];
    }
}
