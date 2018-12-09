package ThreeSortAlgorithms;

import java.util.Arrays;

/**
 * what is selection sort?
 * Every time find a global minimum element and swap it into the right position
 * Time Complexity = O(1 + 2 + 3 + ... + n) = O(n ^ 2) It can be described as n to the power of 2
 * Space Complexity = O(1)
 *
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{-2, -4, -1, 9, 0, -2, -4, 5, 2, 5, 6, 3};
        int[] result = SelectSortMethod(array);
        System.out.println(Arrays.toString(result));
    }

    private static int[] SelectSortMethod(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int globalMinIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[globalMinIndex]) {
                    globalMinIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[globalMinIndex];
            array[globalMinIndex] = temp;
        }
        return array;
    }

}
