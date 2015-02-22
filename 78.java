/*
 Given a set of distinct integers, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> partial = new LinkedList<>();
        result.add(partial);
        for(int i = 1; i <= S.length; ++i) {
            combine(S.length,i,1,0,result,partial,S);
        }
        return result;
    }
    
    
    public void combine(int n, int k, int curr, int counter, List<List<Integer>> result, LinkedList<Integer> partial, int[] arr) {
        if(counter == k) {
            result.add((List<Integer>) partial.clone());
            return ;
        }
        for(int i = curr; i <= n-(k-counter)+1; ++i) {
            partial.addLast(arr[i-1]);
            combine(n,k,i+1,counter+1,result,partial,arr);
            partial.removeLast();
        }
    }
}
