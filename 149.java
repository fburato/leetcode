/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length <= 1) {
            return points.length;
        }
        int max = 2;
        for(int i = 0; i < points.length; ++i) {
            for(int j = i+1; j < points.length; ++j) {
                int counter = 2;
                for(int k = j+1; k < points.length; ++k) {
                    if(inLine(points[i],points[j],points[k])) {
                        counter++;
                    }
                }
                if(counter > max) {
                    max = counter;
                }
            }
        }
        return max;
    }
    
    public boolean inLine(Point p1, Point p2, Point p3) {
        if(p1.x == p2.x && p1.y == p2.y || p1.x == p3.x && p1.y == p3.y || p2.x == p3.x && p2.y == p3.y) {
            return true;
        }
        if(p1.x == p2.x || p1.x == p3.x) {
            return p1.x == p3.x && p1.x == p2.x;
        }
        return Math.abs(Math.atan((p2.y-p1.y)/(p2.x-p1.x)) - Math.atan((p3.y-p1.y) / (p3.x-p1.x))) < 0.0000001;
    }
    
    public int  gcd(int a, int b) {
        if(a == 0) {
            return gcd(b,a);
        }
        int swap;
        while(b != 0) {
            swap = a % b;
            a = b;
            b = swap;
        }
        return a;
    }
}
