/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/
import java.util.ArrayList;
public class Solution {
    public int pow2(int n) {
        if(n == 0){
            return 1;
        }
        int prod = 2;
        for(int i = 2 ; i<= n; ++i){
            prod = prod *2;
        }
        return prod;
    }
    public List<Integer> grayCode(int n) {
        if(n < 0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<>(pow2(n));
        res.add(0);
        for(int i = 0; i < n; ++i) {
            int start = pow2(i);
            for(int j = 0; j < start; ++j) {
                res.add(start+res.get(start-1-j));
            }
        }
        return res;
    }
}
