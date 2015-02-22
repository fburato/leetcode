/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/
public class Solution {
    public int trailingZeroes(int n) {
        int total = 0;
        long nL = n;
        long power = 5;
        while(n >= power) {
            total += (int) (n / power);
            power *= 5;
        }
        return total;
    }
}
