/*
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3] 
*/
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashSet;
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> partial = new LinkedList<>();
        combinationSum(candidates,target,0,result,partial);
        return result;
    }
    
    public void combinationSum(int[] candidates, int target, int start, List<List<Integer>> result, LinkedList<Integer> partial) {
        if(target == 0) {
            result.add((LinkedList<Integer>)partial.clone());
            return ;
        }
        // target > 0
        HashSet<Integer> set = new HashSet<>();
        for(int i = start; i < candidates.length && candidates[i] <= target; ++i) {
            if(!set.contains(candidates[i])){
                set.add(candidates[i]);
                partial.addLast(candidates[i]);
                combinationSum(candidates,target-candidates[i],i,result,partial);
                partial.removeLast();
            }
        }
    }
}
