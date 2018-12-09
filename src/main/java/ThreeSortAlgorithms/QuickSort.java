package ThreeSortAlgorithms;

import java.util.Arrays;

/**
 * Like Merge Sort, Quick Sort is also a Divide and Conquer algorithm.
 * It picks a element as pivot and partitions the given array around the picked pivot.
 *
 * Below is a method implementing quick sort algorithm
 *
 * e.q Always pick the last element as pivot, put all elements smaller than the pivot into its left part and
 * put all elements bigger than pivot to its right and finally put pivot into the right position
 *
 * T(n) = T(k) + T(n-k-1) + \theta(n)
 * The first two terms are for two recursive calls, the last term is for the partition process.
 * k is the number of elements which are smaller than pivot.
 * The time taken by QuickSort depends upon the input array and partition strategy.
 * The worse case time complexity is O(n ^ 2) : when the array is already sorted in increasing or decreasing order.
 *
 * Best Case: The best case occurs when the partition process always picks the middle element as pivot.
 * Following is recurrence for best case.
 * T(n) = 2T(n/2) + \theta(n)  The solution of above recurrence is \theta(nLogn). It can be solved using case 2 of Master Theorem.
 *
 * Space = O(1)
 *
 */
public class QuickSort {
    public static void main (String[] args) {
        int[] array = new int[]{-2, -4, -1, 9, 0, -2, -4, 5, 2, 5, 6, 3};
        int low = 0;
        int high = array.length - 1;
        QuickSortMethod(array, low, high);
        System.out.println(Arrays.toString(array));
    }

    private static void QuickSortMethod(int[] array, int low, int high) {
        if (low < high) {
            // pi is partitioning index, array[pi] is now at right place
            int pi = partition(array, low, high);

            // Recursively sort elements before partition and after partition
            QuickSortMethod(array, low, pi - 1);
            QuickSortMethod(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // take last element as pivot, places all smaller to left of pivot, and the right
        // finally place pivot into the right position by swapping
        int pivot = array[high];
        int i = low - 1;    // index of smaller element
        for (int j = low; j < high; j++) {
            // if current element is smaller than or equal to pivot, do swap operation
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // finally place pivot into the right place
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }


}
