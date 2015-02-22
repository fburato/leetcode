/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/
public class Solution {
    public String getPermutation(int n, int k) {
        if(n <= 0 || k <= 0 || k > factorial(n)) {
            return "";
        }
        int v[] = new int[n];
        for(int i = 0; i < n; ++i){
            v[i] = i+1;
        }
        return getPermutation(v,k-1);
    }
    
    public String getPermutation(int v[], int k) {
        int base = v.length -1;
        for(int i = 0; i < v.length -1; ++i) {
            int increment = factorial(base);
            if(increment <= k) {
                int count = 1;
                k = k - increment;
                while(increment <= k) {
                    k = k - increment;
                    count++;
                }
                int save = v[i+count];
                for(int j = i+count; j > i; j--) {
                    v[j] = v[j-1];
                }
                v[i] = save;
            }
            base--;
        }
        return arrToString(v);
    }
    
    public String arrToString(int v[]) {
        String res = "";
        for(int i = 0; i < v.length; ++i) {
            res = res + v[i];
        }
        return res;
    }
    public int factorial(int n) {
        if(n <= 1){
            return 1;
        }
        int prod = 1;
        for(int k = 2; k <= n; ++k) {
            prod = prod * k;
        }
        return prod;
    }
}
