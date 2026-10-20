package binarySearch;

public class Demo5 {

    // 山脉数组的峰顶索引
    // https://leetcode.cn/problems/peak-index-in-a-mountain-array/

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if(arr[mid] > arr[mid - 1]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 3, 5, 4, 3, 2, 1, 0};
        System.out.println(peakIndexInMountainArray(arr));

    }

}
