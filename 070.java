/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
*/
public class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int pred1 = 1, pred2 = 2;
        n= n-2;
        while(n > 0) {
            int swap = pred1;
            pred1 = pred2;
            pred2 = swap+pred1;
            n--;
        }
        return pred2;
    }
}
