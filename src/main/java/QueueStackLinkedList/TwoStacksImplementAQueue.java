package QueueStackLinkedList;

import java.util.Stack;


/**
 * Stack1:    To  buffer all new elements    --->  push(x)  goes to Stack1
 * Stack2:    To  pop out the 1st elements
 *   		Class2.1   If  stack2 is empty,  then we move all the element from stack1 to stack2 one by one.  Then  pop the element from Stack2
 *     		Calss2.2   If  stack2 is NOT  empty,  then we can call stack2.pop()
 *
 * Time  complexity:    Push()    -->    O(1)
 *      Pop()     -->     O(n)      ??????    Wrong
 * Amortized  time complexity =  O(1)
 */
class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            try {
                throw new Exception("queue is empty.");
            } catch (Exception e) {

            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}


public class TwoStacksImplementAQueue {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(7);
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());
        obj.push(4);
        obj.push(7);
        obj.push(0);
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());
    }
}
