/*
 There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give? 
*/
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int candy(int[] ratings) {
        final int[] fRatings = new int[ratings.length];
        Integer[] indexes = new Integer[ratings.length];
        int[] candies  = new int[ratings.length];
        int totalCandies = ratings.length;
        for(int i = 0; i < indexes.length; ++i) {
            fRatings[i] = ratings[i];
            indexes[i] = i;
            candies[i] = 1;
        }
        Arrays.sort(indexes, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return fRatings[a] - fRatings[b];
            }
        });
        for(int i = 0; i < indexes.length; ++i) {
            int left = indexes[i] - 1;
            int cur = indexes[i];
            int right = indexes[i] +1;
            if(left >= 0 && ratings[left] < ratings[cur] && candies[cur]<= candies[left]) {
                totalCandies += candies[left] + 1 - candies[cur];
                candies[cur] = candies[left] +1;
            }
            if(right < indexes.length && ratings[right] < ratings[cur] && candies[cur] <= candies[right]) {
                totalCandies += candies[right] +1 - candies[cur];
                candies[cur] = candies[right] +1;
            }
        }
        return totalCandies;
    }
}
