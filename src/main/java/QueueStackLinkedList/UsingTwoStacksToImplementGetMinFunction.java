package QueueStackLinkedList;

import java.util.Stack;

/**
 *
 * Stack1:      1     3      2
 * Stack2:      1     1       1
 * keep the push()  and pop()  in sync between stack1 and stack2
 */
class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(x);
        } else {
            int curMin = stack2.peek();
            if (curMin > x) {
                stack2.push(x);
            } else {
                stack2.push(curMin);
            }
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
public class UsingTwoStacksToImplementGetMinFunction {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
