package QueueStackLinkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyStack {
    // two inbuilt queues
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    // to maintain current number of elements
    static int curr_size;

    MyStack () {
        curr_size = 0;
    }

    public void push(int x) {
        curr_size++;

        // push x first in empty s2
        q2.add(x);

        // push all the remaining elements in q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        // swap the names of the two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public void pop() {
        if (q1.isEmpty()) {
            return;
        }
        q1.remove();
        curr_size--;
    }

    public int top() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.peek();
    }

    public int size() {
        return curr_size;
    }
}
public class ImplementStackUsingQueue {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size: " + s.size());


    }
}
