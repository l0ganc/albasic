package ThreeSortAlgorithms;

import java.util.Arrays;

/**
 * 用到了recursion的思想，
 * 从前有座山，山里有座庙，庙里有个小和尚，那么不禁问："哪座山，哪座庙，哪个小和尚"
 * Time = O(nlogn)
 * Space = O(1)
 *
 * main function that calls MergeSortMethod
 * left: the left index of the sub array
 * right: the right index of the sub array
 *
 * merge sort is a Divide and Conquer algorithm.
 * It divides input array in two halves, calls itself for the two halves and then
 * merge the two sorted halves
 * T(n) = 2T(n / 2) + O(n)
 * So the time complexity is O(nlogn)
 */
public class MergeSort {
    public static int[] array = new int[]{-2, -4, -1, 9, 0, -2, -4, 5, 2, 5, 6, 3};
    public static void main(String[] args) {

        int left = 0;
        int right = array.length - 1;
        MergeSortMethod(array, left, right);
        System.out.print(Arrays.toString(array));
    }

    private static void MergeSortMethod(int[] array, int low, int high) {
        if (low < high) {
            int mid = (high - low) / 2 + low;
            MergeSortMethod(array, low, mid);
            MergeSortMethod(array, mid + 1, high);

            combine(array, low, mid, high);
        }
    }

    private static void combine(int[] array, int low, int middle, int high) {
        int[] helper = new int[array.length];
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft++];
            } else {
                array[current] = helper[helperRight++];
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }
}
