/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container. 
*/

import java.util.Arrays;
import java.util.Comparator;
public class Solution {
    public int maxArea(int[] height) {
        if(height.length <= 1) {
            return 0;
        }
        int max = 0;
        final int[] fHeight = height;
        Integer index[] = new Integer[height.length];
        for(int i = 0; i < index.length; ++i) {
            index[i] = i;
        }
        Arrays.sort(index, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return fHeight[a] - fHeight[b];
            }
        });
        int limitLeft = height.length-1, limitRight = height.length-1;
        int i = height.length-2;
        while(i >= 0 && height[index[i]] == height[index[limitRight]]) {
            limitLeft = i;
            i--;
        }
        // limitLeft and limitRight are the highest columns
        max = (index[limitRight] - index[limitLeft]) * height[index[limitRight]];
        // i is the first element different from the maximum
        while(i >= 0) {
            // determine the area of the current value
            int j = i-1;
            while(j >= 0 && height[index[j]] == height[index[i]]) {
                j--;
            }
            j++;
            if(index[j] < index[limitLeft]) {
                limitLeft = j;
            }
            if(index[j] > index[limitRight]) {
                limitRight = j;
            }
            if(index[i] < index[limitLeft]) {
                limitLeft = i;
            }
            if(index[i] > index[limitRight]) {
                limitRight = i;
            }
            if((index[limitRight] - index[limitLeft]) * height[index[i]] > max) {
                max = (index[limitRight] - index[limitLeft]) * height[index[i]];
            }
            i = j -1;
        }
        return max;
    }
}
