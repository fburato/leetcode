/*
 Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
*/
import java.util.ArrayList;
public class Solution {
    public void heapAlgorithm(ArrayList<Integer> A, int n, List<List<Integer>> result) {
        if(n == 0) {
            result.add((ArrayList<Integer>)A.clone());
            return ;
        }
        for(int i = 0; i <= n; ++i) {
            heapAlgorithm(A,n-1,result);
            int j;
            if(n % 2 == 1){
                j = 0;
            } else {
                j = i;
            }
            int swap = A.get(j);
            A.set(j,A.get(n));
            A.set(n,swap);
        }
    }
    public List<List<Integer>> permute(int[] num) {
        ArrayList<Integer> v = new ArrayList<>(num.length);
        for(int i = 0; i < num.length; ++i) {
            v.add(num[i]);
        }
        List<List<Integer>> result = new ArrayList<>();
        heapAlgorithm(v,num.length-1,result);
        return result;
    }
}
