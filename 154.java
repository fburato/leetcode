/*


    Follow up for "Find Minimum in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/
public class Solution {
    public int findMin(int[] num) {
        return findMin(num,0,num.length-1);
    }
    
    public int findMin(int[] num, int start, int end) {
        if(start == end) {
            return num[start];
        }
        if(num[start] < num[end]){
            return num[start];
        }
        // num[start] >= num[end]
        int med = (start+end) / 2;
        if(med == start) {
            // 2 elements
            return Math.min(num[start],num[end]);
        }
        // start < med < end
        if(num[start] == num[end] && num[start] == num[med]) {
            return Math.min(findMin(num,start,med), findMin(num,med+1,end));
        }
        if(num[start] == num[end]) {
            if(num[start] > num[med]) {
                return findMin(num,start,med);
            } else {
                return findMin(num,med+1,end);
            }
        }
        //num[start] > num[end]
        if(num[med] > num[med+1]) {
            return num[med+1];
        }
        if(num[start] > num[med]) {
            return findMin(num,start,med);
        }
        return findMin(num,med+1,end);
    }
}
