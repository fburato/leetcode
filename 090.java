/*
 Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/
import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashSet;
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] S) {
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
        HashSet<Integer> used = new HashSet<>();
        for(int i = curr; i <= n-(k-counter)+1; ++i) {
            if(!used.contains(arr[i-1])){
                used.add(arr[i-1]);
                partial.addLast(arr[i-1]);
                combine(n,k,i+1,counter+1,result,partial,arr);
                partial.removeLast();
            }
        }
    }
}
