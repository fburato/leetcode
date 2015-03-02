/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321 
*/
public class Solution {
    public int reverse(int x) {
        long reversed = auxReverse(x);
        if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) reversed;
        }
    }
    
    public long auxReverse(long x) {
        if(x == 0) {
            return 0;
        }
        if(x < 0) {
            return -auxReverse(-x);
        }
        // x >0
        long reversed = 0;
        while(x > 0) {
            reversed = reversed * 10 + x %10;
            x = x /10;
        }
        return reversed;
    }
}
