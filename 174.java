/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
-2 (K) 	-3 	3
-5 	-10 	1
10 	30 	-5 (P)
*/

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 1;
        }
        // dungeon is valid
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int min[] = new int[cols];
        if(dungeon[rows-1][cols-1] < 0) {
            min[cols-1] = 1 - dungeon[rows-1][cols-1];
        } else {
            min[cols-1] = 1;
        }
        
        for(int i = cols-2; i >= 0; i--) {
            min[i] = minHP(dungeon[rows-1][i],min[i+1]);
        }
        for(int i = rows-2; i >= 0; i--) {
            min[cols-1] = minHP(dungeon[i][cols-1],min[cols-1]);
            for(int j = cols-2; j >= 0 ;j--) {
                int below = minHP(dungeon[i][j],min[j]);
                int right = minHP(dungeon[i][j],min[j+1]);
                if(below < right) {
                    min[j] = below;
                } else {
                    min[j] = right;
                }
            }
        }
        return min[0];
    }
    
    public static int minHP(int cell, int next) {
        int start = cell >= 0 ? 1 : 1 - cell;
        int inc = 0;
        if(next != 1 && start + cell < next) {
            inc = next - (start+cell);
        }
        return start+inc;
    }
}
