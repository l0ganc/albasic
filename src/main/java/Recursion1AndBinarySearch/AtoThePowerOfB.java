package Recursion1AndBinarySearch;


/**
 * Time = O(1 + 1 + 1 + ... + 1) = O(logb) because there are totally logb nodes in the recursion tree
 * Space = O(logb)  because there are logb call stacks
 */
public class AtoThePowerOfB {
    public static void main(String[] args) {
        int a = 3;
        int b = 1000;
        System.out.println("a ^ b = " + calcu(a, b));
    }

    private static int calcu(int a, int b) {
        if (b == 0) {
            return 1;
        }

        int half_result = calcu(a, b / 2);
        if (b % 2 == 0) {
            return half_result * half_result;
        } else {
            return a * half_result * half_result;
        }
    }
}
