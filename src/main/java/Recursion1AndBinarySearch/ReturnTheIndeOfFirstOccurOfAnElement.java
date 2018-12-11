package Recursion1AndBinarySearch;

public class ReturnTheIndeOfFirstOccurOfAnElement {
    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 5, 5, 5, 5, 6, 8, 10};
        int target = 12;

        System.out.println(getIndexOfFirstOccurTarget(a, target));
    }


    /**
     * 依然需要提前一步停下来，d
     * ne当L 跟 R 相邻的时候跳出while循环，再用post-processing来判断L 跟 R 究竟哪个是最终答案
     * @param a
     * @param target
     * @return
     */
    private static int getIndexOfFirstOccurTarget(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int left = 0;
        int right = a.length - 1;

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (a[mid] == target) {
                right = mid;        // 这里不能用right = mid - 1
            } else if (a[mid] < target) {
                left = mid;         // 这里用left = mid + 1也是可以的
            } else {
                right = mid;        // 这里用right = mid - 1也是可以的
            }
        }

        // post-processing
        if (a[left] == target) {
            return left;
        }
        if (a[right] == target) {
            return right;
        }

        return -1;
    }
}