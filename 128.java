/*
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity. 
*/
import java.util.Arrays;

public class Solution {
    public int longestConsecutive(int[] num) {
        Arrays.sort(num);
        int longest = 1;
        int lastInSeq = num[0];
        int counter = 1;
        for(int i = 1; i < num.length; ++i) {
            if(lastInSeq + 1 == num[i]) {
                counter++;
                if(counter > longest) {
                    longest = counter;
                }
                lastInSeq = num[i];
            } else if(lastInSeq != num[i]) {
                counter = 1;
                lastInSeq = num[i];
            }
        }
        return longest;
    }
}
