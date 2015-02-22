/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
import java.util.HashMap;

public class Solution {
    public int majorityElement(int[] num) {
        HashMap<Integer,Integer> map = new HashMap<>(num.length);
        for(int i = 0; i < num.length; ++i) {
            Integer counter = map.get(num[i]);
            if(counter == null) {
                counter = 1;
            } else {
                counter = counter + 1;
            }
            if(counter > num.length / 2) {
                return num[i];
            }
            map.put(num[i],counter);
        }
        return -1;
    }
}
