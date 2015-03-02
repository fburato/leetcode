/*
 Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3]. 
*/
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null) {
            return 0;
        } 
        if(A.length <= 2) {
            return A.length;
        }
        // A.length > 2
        int toOverwrite = 1, nextElement = 1;
        int lastWritten = A[0], numWritten = 1;
        while(nextElement < A.length) {
            if(lastWritten == A[nextElement] && numWritten < 2) {
                A[toOverwrite] = A[nextElement];
                numWritten++;
                toOverwrite++;
            } else if(lastWritten == A[nextElement]) {
                while(nextElement < A.length && A[nextElement] == lastWritten) {
                    nextElement++;
                }
                if(nextElement < A.length) {
                    A[toOverwrite] = A[nextElement];
                    lastWritten = A[nextElement];
                    numWritten = 1;
                    toOverwrite++;
                }
            } else {
                A[toOverwrite] = A[nextElement];
                lastWritten = A[nextElement];
                numWritten = 1;
                toOverwrite++;
            }
            nextElement++;
        }
        return toOverwrite;
    }
}
