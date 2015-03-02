/*
 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10. 
*/
public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int maximal = 0;
        for(int i = 0; i < height.length; ++i) {
            if(height[i] != 0) {
                int maxLength = maxLength(height,i);
                if(maxLength*height[i] > maximal) {
                    maximal = maxLength*height[i];
                } 
            }
        }
        return maximal;
    }
    public int maxLength(int[] height, int index) {
        int length = 1;
        int actualHeight = height[index];
        for(int i = index+1; i < height.length && height[i] >= actualHeight; ++i) {
            length++;
        }
        for(int i = index-1; i >= 0 && height[i] >= actualHeight; --i) {
            length++;
        }
        return length;
    }
}
