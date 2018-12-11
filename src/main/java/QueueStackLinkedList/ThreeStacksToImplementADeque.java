package QueueStackLinkedList;

/**
 * using three stacks to implement a deque, Amortized time = O(1)
 *
 * 1 2 3 4 5 6 7 8 9
 *
 *      1 2 3 4 5||stack1  stack2||
 *
 *      Stack3:
 *
 *    we can use three stacks: stack1, stack2, stack3
 *    first, we pop 1 2 3 from stack1 and push them to stack3      O(0.5n + 0.5n)
 *            4 5||stack1  stack2||
 *      Stack3: 3 2 1
 *
 *    second, we pop 4 5 from stack1 and push them into stack2     O(0.5n + 0.5n)
 *               ||stack1  stack2||4 5
 *      Stack3: 3 2 1
 *
 *    finally, we pop 1 2 3 from stack3 and push them into stack1  O(0.5n + 0.5n)
 *          3 2 1||stack1  stack2||4 5
 *      Stack3:
 *
 *     So the total time complexity is : O (3n) / n = O(3) = O (1)
 *
 *
 *   However, if we use two stacks to implement deque, we can not guarantee Amortized time = O(1),
 *   In this case, the amortized time is O(n)
 *
 *   e.q :    1 2 3 4 5||stack1  stack2||
 *
 *   If we want to do delete node in stack2(5), then we need to pop all elements in stack1 and
 *   push them to stack2,
 *            ||stack1  stack2||1 2 3 4 5    O(n)
 *   If we want to delete 1 now, we need to do the above operation again ....
 *
 *
 */


// below is the implement of deque using two stacks
public class ThreeStacksToImplementADeque {
}
