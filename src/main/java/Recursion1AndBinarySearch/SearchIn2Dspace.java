package Recursion1AndBinarySearch;

import java.util.Arrays;

public class SearchIn2Dspace {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int target = 1;
        System.out.println(target + " is in the index of " + Arrays.toString(getIndexArray(matrix, target)));
    }

    private static int[] getIndexArray(int[][] matrix, int target) {
        int[] result = new int[]{-1, -1};
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = row * col - 1;

        while (i <= j) {
            int mid = (j - i) / 2 + i;
            int r = mid / col;
            int c = mid % col;
            if (matrix[r][c] == target) {
                result[0] = r;
                result[1] = c;
                return result;
            } else if (matrix[r][c] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return result;
    }
}
