/*
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/
import java.util.LinkedList;
public class Solution {
    
    public List<List<Integer>> combine(int n, int k) {
        // TODO check for boundaries
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> partial = new LinkedList<>();
        combine(n,k,1,0,result,partial);
        return result;
    }
    
    public void combine(int n, int k, int curr, int counter, List<List<Integer>> result, LinkedList<Integer> partial) {
        if(counter == k) {
            result.add((List<Integer>) partial.clone());
            return ;
        }
        for(int i = curr; i <= n-(k-counter)+1; ++i) {
            partial.addLast(i);
            combine(n,k,i+1,counter+1,result,partial);
            partial.removeLast();
        }
    }
}
