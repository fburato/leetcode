/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
*/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }
        List<Integer> last = triangle.get(triangle.size()-1);
        int size = last.size();
        int sums[] = new int[size];
        int i = 0;
        for(int val : last) {
            sums[i++] = val;
        }
        for(int j = triangle.size()-2; j >= 0; --j) {
            last = triangle.get(j);
            for(int k = 0; k < last.size(); ++k) {
                sums[k] = last.get(k) + Math.min(sums[k],sums[k+1]);
            }
        } 
        return sums[0];
    }
}
