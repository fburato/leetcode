/*
 Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary

For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.

*/
import java.util.LinkedList;
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(!dict.contains(start)) {
            dict.add(start);
        }
        if(!dict.contains(end)) {
            dict.add(end);
        }
        String[] arr = dict.toArray(new String[0]);
        LinkedList<Integer>[] adj = (LinkedList<Integer>[]) new LinkedList[arr.length];
        for(int i = 0; i < adj.length; ++i) {
            adj[i] = new LinkedList<>();
        }
        for(int i = 0; i < arr.length; ++i) {
            for(int j = i+1; j < arr.length; ++j) {
                if(hamming(arr[i],arr[j]) == 1) {
                    adj[i].addLast(j);
                    adj[j].addLast(i);
                }
            }
        }
        boolean[] visited = new boolean[arr.length];
        int[] distances = new int[arr.length];
        // perform BFS on the graph
        // find index of start in the array
        int s = -1;
        for(int i = 0; s == -1 && i < arr.length; ++i) {
            if(arr[i].equals(start)) {
                s = i;
            }
        }
        // perform BFS
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addLast(s);
        distances[s] = 0;
        visited[s] = true;
        while(!stack.isEmpty()) {
            int next = stack.removeFirst();
            if(arr[next].equals(end)) {
                return distances[next]+1;
            }
            for(int i : adj[next]) {
                if(!visited[i]) {
                    visited[i] = true;
                    distances[i] = distances[next] + 1;
                    stack.addLast(i);
                }
            }
        }
        return 0;
    }
    
    public int hamming(String s1, String s2) {
        int count = 0;
        for(int i = 0; i < s1.length(); ++i) {
            count = count + (s1.charAt(i) == s2.charAt(i) ? 0 : 1);
        }
        return count;
    }
}
