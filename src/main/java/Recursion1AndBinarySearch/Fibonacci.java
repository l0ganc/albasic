package Recursion1AndBinarySearch;


/**
 * For binary tree, the number of all leaf nodes in the binary tree is larger than the rest nodes in the bianry tree
 * Thus, we only care about the nodes in the leaf level
 *
 * Space: O(n) 取决于call stack一共压栈了多少层 = how many call stacks are there in the recursion tree == level of recursion tree
 *
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci(" + n + ") = " + FiboCalculate(n));
    }

    private static int FiboCalculate(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return FiboCalculate(n - 1) + FiboCalculate(n - 2);
    }


}
