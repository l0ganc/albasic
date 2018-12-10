package Recursion1AndBinarySearch;

public class BinarySearchClassicalVersion {
    public static void main(String[] args) {
        // array must be sorted
        int[] a = new int[]{-3, -1, 4, 6, 9, 13, 38, 49};
        int[] b = new int[]{1, 2, 3};
        int target = 3;
        System.out.println(target + " is in the index of " + binary_search(b, target));
    }

    private static int binary_search(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int left = 0;
        int right = a.length - 1;

        /**
        // 如果是left跟right相邻就停下里，那么while循环下面要加判断
        // 如果是经典的left <= right 写法， 就不需要加判断了
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                left = mid + 1;    // left = mid 也可以
            } else {
                right = mid - 1;   // right = mid 也可以
            }
        }
        if (a[left] == target) {
            return left;
        } else if (a[right] == target) {
            return right;
        }

        return -1;

         */


        /**
         * 经典的写法中下面的mid + 1跟mid - 1是必须的，
         * 否则在[1, 2, 3]这种case下会有死循环
         */
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

    }
}
