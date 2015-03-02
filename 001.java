/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2 
*/
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // add every number to the map
        HashMap<Integer,Integer> numMap = new HashMap<>(numbers.length);
        for(int i = 0; i < numbers.length; ++i) {
            numMap.put(numbers[i], i);
        }
        
        //look for target in the array
        for(int i = 0; i < numbers.length; ++i) {
            if(numMap.get(target-numbers[i]) != null && numMap.get(target-numbers[i]) != i) {
                int[] result = {i+1,numMap.get(target-numbers[i])+1};
                return result;
            }
        }
        return null;
    }
}
