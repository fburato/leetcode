/*
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6. 
*/
public class Solution {
    public int maxProduct(int[] A) {
        //compute product
        int[] products = new int[A.length];
        int[] lastNeg = new int[A.length];
        int end = A.length -1;
        while(end >= 0 && A[end] == 0) {
            end--;
        }
        if(end < 0) {
            return 0;
        }
        // end is index of the last non zero element
        int lastNegInd = -1;
        int prod = 1;
        for(int i = end; i >= 0; --i) {
            if(A[i] == 0) {
            	lastNegInd = -1;
                prod = 1;
                lastNeg[i] = lastNegInd;
                products[i] = 0;
            } else {
                lastNeg[i] = lastNegInd;
                if(A[i] < 0 && lastNegInd == -1) {
                	lastNegInd = i;
                }
                prod = prod * A[i];
                products[i] = prod;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < products.length; ++i) {
            if(products[i] < 0 && lastNeg[i] != -1) {
                products[i] = products[i] / products[lastNeg[i]];
            }
            if(products[i] < 0 && lastNeg[i] == -1) {
                products[i] = A[i];
            }
            if(products[i] > max) {
                max = products[i];
            }
        }
        return max;
    }
}
