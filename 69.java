/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/
public class Solution {
    public int sqrt(int x) {
        if(x < 0) {
            throw new ArithmeticException("sqrt of negative number is undefined");
        }
        if(x == 0) {
            return 0;
        }
        int start = 1, end = x;
        // start <= sqrt < end
        while(start < end) {
            int med = (start+end) / 2;
            if(x / med == med) {
                return med;
            } else if(x/med < med) {
                end = med;
            } else {
                if(start == med) {
                    end = med;
                }
                start = med;
            }
        }
        return end;
    }
}
