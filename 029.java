/*
 Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT. 
*/
public class Solution {
    public int divide(int idividend, int idivisor) {
        if(idivisor == 0){
            throw new ArithmeticException("Cannot divide by 0");
        }
        boolean positive = true;
        if(idividend >= 0 != idivisor >= 0) {
            positive = false;
        }
        long dividend = idividend, divisor = idivisor, quotient = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend > 0 && dividend >= divisor) {
            long current = divisor;
            long times = 1;
            while(dividend >= current << 1) {
                current <<= 1;
                times <<= 1;
            }
            dividend -= current;
            quotient += times;
        }
        if(positive && -quotient == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(positive) {
            return (int) quotient;
        } else {
            return (int) -quotient;
        }
    }
    
    
}
