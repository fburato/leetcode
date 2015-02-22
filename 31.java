/*
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] num) {
        // find the substitute if it exists
        boolean swapped = false;
        int j = 0;
        int end = num.length-1;
        while(end > 0 && num[end-1] >= num[end]){
            end--;
        }
        // num[end..num.length-1] is in descending order, end-1 >= 0 -> num[end-1] < num[end]
        if(end > 0) {
            // find the lowest index i in num[end..num.length-1] s.t. num[end-1] < num[i] 
            end--;
            for(int i = num.length -1; !swapped && i > end; --i) {
                if(num[end] < num[i]) {
                    int swap = num[i];
                    num[i] = num[end];
                    num[end] = swap;
                    swapped = true;
                }
            }
            end++;
        }
        Arrays.sort(num,end,num.length);
    }
}
