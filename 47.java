/*
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. 
*/
import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        ArrayList<Integer> v = new ArrayList<>(num.length);
        for(int i = 0; i < num.length; ++i) {
            v.add(num[i]);
        }
        List<List<Integer>> result = new ArrayList<>();
        heapAlgorithm(v,0,result);
        return result;
    }
    public void heapAlgorithm(ArrayList<Integer> A, int start, List<List<Integer>> result) {
        if(start == A.size()- 1) {
            result.add(A);
            return ;
        }
        for(int i = start+1; i <= A.size(); ++i) {
            ArrayList<Integer> base = (ArrayList<Integer>) A.clone();
            heapAlgorithm(base,start+1,result);
            while(i < A.size() && A.get(i) == A.get(start)) {
                ++i;
            }
            if(i < A.size()) {
                int swap = A.get(start);
                A.set(start,A.get(i));
                A.set(i,swap);
            }
        }
    }
}
