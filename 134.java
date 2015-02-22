/*
 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique. 
*/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; ++i) {
            if(canComplete(gas,cost,i)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean canComplete(int gas[], int cost[], int starting) {
        int tank = 0;
        int current = starting;
        int next = (current+1)%gas.length;
        do{
            tank = gas[current] - cost[current];
            if(tank < 0) {
                return false;
            }
            current = next;
            next = (current+1) % gas.length;
        } while(current != starting);
        return true;
    }
}
