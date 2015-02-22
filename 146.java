/*
 Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
*/
import java.util.HashMap;

public class LRUCache {
    static class Triple {
        public int key;
        public long lastused;
        public int value;
        public Triple(int k, long l, int v){
            key = k;
            lastused = l;
            value = v;
        }
    }
    
    private long usage = 0;
    private Triple[] heap;
    private HashMap<Integer,Integer> map;
    private int heapSize;
    public LRUCache(int capacity) {
        heap = new Triple[capacity];
        map = new HashMap<>(capacity);
        heapSize = 0;
    }
    
    public int get(int key) {
        Integer index = map.get(key);
        if(index == null) {
            return -1;
        } else {
            heap[index].lastused = usage++;
            int val = heap[index].value;
            heapfy(index);
            return val;
        }
    }
    
    public void set(int key, int value) {
        Integer index = map.get(key);
        if(index == null) {
            // new insert
            if(heapSize == heap.length) {
                Triple lru = heap[0];
                map.remove(lru.key);
                lru.key = key;
                lru.value = value;
                lru.lastused = usage++;
                map.put(key,0);
                heapfy(0);
            } else {
                Triple recent = new Triple(key,usage++,value);
                heap[heapSize] = recent;
                map.put(key,heapSize);
                heapSize++;
            }
        } else {
            heap[index].value = value;
            heap[index].lastused = usage++;
            heapfy(index);
        }
    }
    
    private void heapfy(int i) {
        int left = 2*(i+1)-1, right = left+1, min = i;
        if(left < heapSize && heap[min].lastused > heap[left].lastused) {
            min = left;
        }
        if(right < heapSize && heap[min].lastused > heap[right].lastused) {
            min = right;
        }
        if(min != i) {
            Triple swap = heap[min];
            heap[min] = heap[i];
            heap[i] = swap;
            map.put(heap[min].key,min);
            map.put(heap[i].key,i);
            heapfy(min);
        }
    }
}
