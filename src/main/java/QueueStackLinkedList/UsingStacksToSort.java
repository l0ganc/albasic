package QueueStackLinkedList;

import java.util.Stack;

public class UsingStacksToSort {
    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        // This is a temporary stack
        Stack<Integer> tmpStack = sortStack(input);
        System.out.println("Sorted numbers are : ");
        while (!tmpStack.isEmpty()) {
            System.out.print(tmpStack.pop() + " ");
        }
    }

    private static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<>();
        while (!input.isEmpty()) {
            // pop put the first element
            int tmp = input.pop();

            // while temporary stack is not empty and top of stack is greater than temp
            while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                // pop from temporary stack and push it to input stack
                input.push(tmpStack.pop());
            }

            // push tmp into temporary stack
            tmpStack.push(tmp);
        }

        return tmpStack;
    }
}
