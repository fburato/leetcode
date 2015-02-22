/*
 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively. 
*/
public class Solution {
    public void sortColors(int[] A) {
        if(A == null) {
            return ;
        }
        int numColors[] = {0,0,0};
        for(int i = 0; i < A.length; ++i) {
            numColors[A[i]]++;
        }
        int next = 0;
        for(int i = 0; i < numColors.length; ++i) {
            for(int j = 0; j < numColors[i]; ++j) {
                A[next++] = i;
            }
        }
    }
}
