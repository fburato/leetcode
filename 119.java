/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space? 
*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> last = new ArrayList<>(1);
        last.add(1);
        for(int i = 2; i <= rowIndex+1 ; ++i) {
            ArrayList<Integer> next = new ArrayList<>(i);
            next.add(1);
            for(int j = 1; j < i-1 ; ++j ) {
                next.add(last.get(j-1)+last.get(j));
            }
            next.add(1);
            last = next;
        }
        return last;
    }
}
