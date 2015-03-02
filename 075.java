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
    public void sortColors2(int[] A) {
        int z = 0, o = 0, t = A.length-1;
        while(z < A.length && A[z] == 0) {
            z++;
        }
        while(t >= 0 && A[t] == 2) {
            t--;
        }
        o = z;
        //A[z] != 0, A[t] != 2, z<= o
        while(o <= t) {
            if(A[o] == 2) {
                int swap = A[o];
                A[o] = A[t];
                A[t] = swap;
            } else if(A[o] == 0) {
                int swap = A[o];
                A[o] = A[z];
                A[z] = swap;
            } else {
                o++;
            }
            while(z < A.length && A[z] == 0) {
                z++;
            }
            while(t >= 0 && A[t] == 2) {
                t--;
            }
            if(o < z) {
                o = z;
            }
        }
    }
}
