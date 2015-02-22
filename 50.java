/*
Implement pow(x, n). 
*/
public class Solution {
    public double pow(double x, int n) {
        if(x==0 && n == 0) {
            throw new ArithmeticException("Cannot compute 0^0");
        }
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(n < 0) {
            if(n == Integer.MIN_VALUE) {
                return (1/pow(x,-Integer.MAX_VALUE))/x;
            }
            return 1/pow(x,-n);
        }
        if(x < 0) {
            if(n % 2 == 0) {
                return pow(-x,n);
            } else {
                return -pow(-x,n);
            }
        }
        // x > 0, n > 0
        double mid = pow(x,n/2);
        mid = mid * mid;
        if(n % 2 == 1){
            mid = mid * x;
        }
        return mid;
    }
}
