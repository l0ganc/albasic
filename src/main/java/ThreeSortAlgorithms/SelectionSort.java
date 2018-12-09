package ThreeSortAlgorithms;

/**
 * what is selection sort?
 * Every time find a global minimum element and swap it into the right position
 * time Complexity = O(1 + 2 + 3 + ... + n) = O(n ^ 2) It can be described as n to the power of 2
 *
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{-2, -4, -1, 9, 0, -2, -4, 5, 2, 5, 6, 3};
        int[] result = SelectSortMethod(array);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
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
