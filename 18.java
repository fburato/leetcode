/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.

    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)

*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(num.length < 4) {
            return res;
        }
        Arrays.sort(num);
        HashMap<Integer,Integer> elements = new HashMap<>(num.length);
        for(int i = 0; i < num.length; ++i){
            elements.put(num[i],i);
        }
        // save only the last element
        Integer last1 = null, last2 = null, last3 = null;
        boolean proceed = true;
        for(int i1 = 0; i1 < num.length; ++i1) {
            if(last1 == null || last1 != num[i1]) {
                last1 = num[i1];
            } else {
                proceed = false;
            } 
            for(int i2 = i1+1; proceed && i2 < num.length; ++i2) {
                if(last2 == null || last2 != num[i2]) {
                    last2 = num[i2];
                } else {
                    proceed = false;
                }
                for(int i3 = i2+1; proceed && i3 < num.length; ++i3) {
                    if(last3 == null || last3 != num[i3]) {
                        last3 = num[i3];
                    } else {
                        proceed = false;
                    }
                    if(proceed) {
                        int last =(int) (((long) target) - (((long)num[i1]) + num[i2] + num[i3]));
                        Integer index = elements.get(last);
                        if(index != null && index > i3) {
                            LinkedList<Integer> newarr = new LinkedList<>();
                            newarr.addLast(num[i1]);
                            newarr.addLast(num[i2]);
                            newarr.addLast(num[i3]);
                            newarr.addLast(last);
                            res.add(newarr);
                        }
                    }
                    proceed = true;
                }
                proceed = true;
            }
            proceed = true;
        }
        return res;
    }
    /*public int binarySearch(int num[], int el, int start, int end) {
        if(el > num[end] || el < num[start]) {
            return -1;
        }
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
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        if(num.length < 4) {
            return new LinkedList<List<Integer>>();
        }
        Arrays.sort(num);
        List<List<Integer>> result = new LinkedList<>();
        int selected[] = new int[4];
        nSum(num,1,4,0,result,target,selected);
        return result;
    }
    
    public void nSum(int[] num, int current, int total, int startIndex, List<List<Integer>> result, int target, int selected[]) {
        if(current == total) {
            // perform binary search
            int sum = 0;
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < total-1; ++i) {
                sum += selected[i];
                list.add(selected[i]);
            }
            int last = binarySearch(num,target - sum,startIndex,num.length-1);
            if(last != -1) {
                list.add(num[last]);
                result.add(list);
            }
        } else {
            // select next component
            HashSet<Integer> set = new HashSet<>();
            for(int i = startIndex; i < num.length - (total - current); ++i) {
                if(!set.contains(num[i])) {
                    set.add(num[i]);
                    selected[current-1] = num[i];
                    nSum(num,current+1,total,i+1,result,target,selected);
                }
            }
        }
    }*/
}
