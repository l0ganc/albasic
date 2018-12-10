package Recursion1AndBinarySearch;

public class FindElementInArrayThatIsClosetToTargetNumber {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 8, 9};
        int target = 4;

        System.out.println(getIndexOfClosestToTarget(a, target));
    }

    /**
     * 这题需要提前一步停下来，经典的binary search不太适用
     * @param a
     * @param target
     * @return
     */
    private static int getIndexOfClosestToTarget(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int left = 0;
        int right = a.length - 1;

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                left = mid;    // 这里不能写成left = mid + 1
            } else {
                right = mid;   // 这里不能写成right = mid - 1
            }
        }

        // 非经典的binary search在while循环后需要加判断
        if (Math.abs(a[left] - target) <= Math.abs(a[right] - target)) {
            return left;
        } else {
            return right;
        }
    }
}
