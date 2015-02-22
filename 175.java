/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.


*/
public class Solution {
    public String largestNumber(int[] num) {
        if(num == null || num.length == 0) {
            return "";
        }
        heapSort(num);
        StringBuilder s = new StringBuilder("");
        for(int i = num.length - 1; i >= 0; --i) {
            s.append(num[i]);
        }
        if(s.charAt(0) == '0') {
            int last = 0;
            while(last < s.length() - 1 && s.charAt(last) == '0') {
                last++;
            }
            s.delete(0,last);
        }
        return s.toString();
    }
    
    public boolean lessThan(int a, int b) {
        return ("" + a + b).compareTo("" + b + a) < 0;
    }
    
    public void heapfy(int[] num, int i, int heapSize) {
        int max = i, left = 2*(i+1)-1, right = left+1;
        if(left < heapSize && lessThan(num[max],num[left])) {
            max = left;
        }
        if(right < heapSize && lessThan(num[max],num[right])) {
            max = right;
        }
        if(max != i) {
            int swap = num[max];
            num[max] = num[i];
            num[i] = swap;
            heapfy(num,max,heapSize);
        }
    }
    
    public void buildMaxHeap(int num[]) {
        for(int i = (num.length-1)/ 2; i >= 0; --i) {
            heapfy(num,i,num.length);
        }
    }
    
    public void heapSort(int num[]) {
        buildMaxHeap(num);
        System.gc();
        for(int i = num.length-1; i >=1; --i) {
            int swap = num[0];
            num[0] = num[i];
            num[i] = swap;
            heapfy(num,0,i);
        }
    }
}
