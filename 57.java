/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.LinkedList;
public class Solution {
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<Interval>();
        if(intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        Interval last = null;
        boolean started = false;
        if(newInterval.end < intervals.get(0).start) {
            res.add(newInterval);
            started = true;
        }
        for(Interval i : intervals) {
            if(last == null) {
                last = i;
            } else {
                if(!started){
                    if(intersect(last,newInterval)) {
                        last.start = Math.min(last.start,newInterval.start);
                        last.end = Math.max(last.end,newInterval.end);
                        started = true;
                    } else if(newInterval.end < i.start) {
                        res.add(last);
                        last = newInterval;
                        started = true;
                    }
                } 
                if(intersect(last,i)){
                    last.start = Math.min(last.start,i.start);
                    last.end = Math.max(last.end,i.end);
                } else {
                    res.add(last);
                    last = i;
                }
            }
        }
        if(!started){
            if(intersect(last,newInterval)) {
                last.start = Math.min(last.start,newInterval.start);
                last.end = Math.max(last.end,newInterval.end);
            } else {
                res.add(last);
                last = newInterval;
            }
        }
        res.add(last);
        return res;
    }
    
    public static boolean intersect(Interval a, Interval b) {
        if(a.start <= b.start) {
            return b.start <= a.end;
        } else {
            return a.start <= b.end;
        }
    }
}
