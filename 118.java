/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/
import java.util.ArrayList;
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0) {
            return res;
        }
        ArrayList<Integer> last = new ArrayList<>(1);
        last.add(1);
        res.add(last);
        for(int i = 2; i <= numRows ; ++i) {
            ArrayList<Integer> next = new ArrayList<>(i);
            next.add(1);
            for(int j = 1; j < i-1 ; ++j ) {
                next.add(last.get(j-1)+last.get(j));
            }
            next.add(1);
            last = next;
            res.add(next);
        }
        return res;
    }
}
