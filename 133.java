/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors. 
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode,UndirectedGraphNode> copies = new HashMap<>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        copies.put(node, new UndirectedGraphNode(node.label));
        queue.addLast(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode s = queue.removeFirst();
            UndirectedGraphNode t = copies.get(s);
            for(UndirectedGraphNode v : s.neighbors) {
                UndirectedGraphNode vDest = copies.get(v);
                if(vDest == null) {
                    vDest = new UndirectedGraphNode(v.label);
                    copies.put(v, vDest);
                    queue.addLast(v);
                }
                t.neighbors.add(vDest);
            }
        }
        return copies.get(node);
    }
    
    
}
