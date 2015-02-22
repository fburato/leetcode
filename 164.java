/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
*/
import java.util.Arrays;
public class Solution {
    public int maximumGap(int[] num) {
        if(num.length < 2) {
            return 0;
        }
        // num.length >= 2
        Arrays.sort(num);
        int max = num[1] - num[0];
        for(int i = 2; i < num.length; ++i) {
            if(num[i] - num[i-1] > max) {
                max = num[i] - num[i-1];
            }
        }
        return max;
    }
}
