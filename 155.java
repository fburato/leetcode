/*
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

*/
import java.util.Stack;

class MinStack {
    private Stack<Integer> elements = new Stack<>();
    private Stack<Integer> minimums = new Stack<>();
    
    public void push(int x) {
        elements.push(x);
        if(minimums.isEmpty() || minimums.peek() >= x) {
            minimums.push(x);
        }
    }

    public void pop() {
        if(elements.size() > 0) {
            int i = elements.pop();
            if(minimums.peek() == i) {
                minimums.pop();
            }
        }
    }

    public int top() {
        if(elements.isEmpty()) {
            throw new RuntimeException("Empty stack");
        }
        return elements.peek();
    }

    public int getMin() {
        if(elements.isEmpty()) {
            throw new RuntimeException("Empty stack");
        }
        return minimums.peek();
    }
}

