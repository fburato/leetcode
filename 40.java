/*
 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6] 
*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> partial = new LinkedList<>();
        combinationSum2(candidates,target,0,result,partial);
        return result;
    }
    
    public void combinationSum2(int[] candidates, int target, int start, List<List<Integer>> result, LinkedList<Integer> partial) {
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
                combinationSum2(candidates,target-candidates[i],i+1,result,partial);
                partial.removeLast();
            }
        }
    }
}
