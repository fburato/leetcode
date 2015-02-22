/*
 Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary

For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]

Note:

    All words have the same length.
    All words contain only lowercase alphabetic characters.

*/
import java.util.LinkedList;

public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
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
    }
}
