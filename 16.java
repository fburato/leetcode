/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

import java.util.HashSet;
import java.util.Arrays;
public class Solution {
    public int binarySearchClosest(int num[], int el, int start, int end) {
        if(start > end){
            return -1;
        }
        if(start == end) {
            return start;
        }
        // start < end
        int med = (start+end)/2;
        if(num[med] == el) {
            return med;
        } else if(num[med] < el) {
            if(med+1 <= end && num[med+1] < el) {
                return binarySearchClosest(num,el,med+1,end);
            } else if(med+1 <= end) {
                if(Math.abs(el-num[med]) < Math.abs(el-num[med+1])){
                    return med;
                } else {
                    return med+1;
                }
            } 
            return med;
        }
        // num[med] > el
        if(med-1 >= start && num[med-1]> el) {
            return binarySearchClosest(num,el,start, med-1);
        } else if(med-1 >= start) {
            if(Math.abs(el-num[med]) < Math.abs(el-num[med-1])) {
                return med;
            } else {
                return med-1;
            }
        }
        return med;
    }
    
    public int threeSumClosest(int[] num, int target) {
        if(num.length < 3) {
            return 0;
        }
        Arrays.sort(num);
        int minimal = target - Integer.MAX_VALUE ;
        HashSet<Integer> setFirst = new HashSet<>();
        for(int i = 0; i < num.length -2; ++i) {
            if(!setFirst.contains(num[i])) {
                setFirst.add(num[i]);
                HashSet<Integer> setSecond = new HashSet<>();
                for(int j = i+1; j < num.length -1; ++j) {
                    if(!setSecond.contains(num[j])) {
                        setSecond.add(num[j]);
                        int index = binarySearchClosest(num,target-num[i]-num[j],j+1,num.length-1);
                        if(index != -1 && Math.abs(target - num[i] - num[j] - num[index]) < Math.abs(target - minimal)) {
                            minimal = num[i] + num[j] + num[index];
                        }
                    }
                }
            }
        }
        return minimal;
    }
}
