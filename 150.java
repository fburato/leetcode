/*
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

*/
public class Solution {
    enum Type {PLUS, MINUS, MULT, DIV, NUM}
    static class StackNode {
        public int val;
        public StackNode next;
        public StackNode(int v, StackNode n) {
            val = v;
            next = n;
        }
    }
    
    public int evalRPN(String[] tokens) {
        StackNode stack = null;
        for(int i = 0; i < tokens.length; ++i) {
            Type t = Type.NUM;
            String s = tokens[i];
            if(s.equals("+")) {
                t = Type.PLUS;
            } else if(s.equals("-")){
                t = Type.MINUS;
            } else if(s.equals("*")) {
                t = Type.MULT;
            } else if(s.equals("/")) {
                t = Type.DIV;
            }
            if(t == Type.NUM) {
                int num = Integer.decode(s);
                stack = new StackNode(num,stack);
            } else {
                int op1 = 0, op2 = 0;
                if(stack == null) {
                    throw new RuntimeException("Tokens not in RPN");
                }
                op2 = stack.val; stack = stack.next;
                if(stack == null) {
                    throw new RuntimeException("Tokens not in RPN");
                }
                op1 = stack.val; stack = stack.next;
                int val = 0;
                switch(t) {
                    case PLUS : 
                        val = op1 + op2;
                        break;
                    case MINUS :
                        val = op1 - op2;
                        break;
                    case MULT :
                        val = op1 * op2;
                        break;
                    case DIV :
                        val = op1 / op2;
                }
                stack = new StackNode(val,stack);
            }
        }
        if(stack == null) {
            return 0;
        } else {
            return stack.val;
        }
    }
}
