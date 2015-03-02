/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. 
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
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> l = new LinkedList<Interval>();
        if(intervals == null || intervals.size() == 0) {
            return l;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Interval last = null;
        for(Interval i : intervals) {
            if(last == null) {
                last = i;
            } else if(intersect(last,i)){
                last = new Interval(Math.min(last.start,i.start),Math.max(last.end,i.end));
            } else {
                l.add(last);
                last = i;
            }
        }
        if(last != null) {
            l.add(last);
        }
        return l;
    }
    
    public static boolean intersect(Interval a, Interval b) {
        if(a.start <= b.start) {
            return b.start <= a.end;
        } else {
            return a.start <= b.end;
        }
    }
}
