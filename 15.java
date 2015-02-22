/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
public class Solution {
    
    public int binarySearch(int num[], int el, int start, int end) {
        if(start > end || start == end && num[start] != el) {
            return -1;
        }
        if(start == end && num[start] == el) {
            return start;
        } 
        // start < end
        int med = (start+end) / 2;
        if(num[med] == el) {
            return med;
        } else if(num[med] < el) {
            return binarySearch(num,el,med+1,end);
        }
        return binarySearch(num,el,start,med-1);
    }
    public List<List<Integer>> threeSum(int[] num) {
        if(num.length < 3) {
            return new LinkedList<List<Integer>>();
        }
        Arrays.sort(num);
        List<List<Integer>> result = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < num.length -2 ; ++i) {
            if(!set.contains(num[i])) {
                set.add(num[i]);
                HashSet<Integer> setSecond = new HashSet<>();
                for(int j = i+1; j < num.length -1; ++j) {
                    if(!setSecond.contains(num[j])) {
                        setSecond.add(num[j]);
                        int last = binarySearch(num,0-num[i]-num[j],j+1,num.length-1);
                        if(last != -1){
                            List<Integer> list = new LinkedList<>();
                            list.add(num[i]);
                            list.add(num[j]);
                            list.add(num[last]);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }
}
