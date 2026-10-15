package binarySearch;

public class Demo1 {

    // 二分查找
    // https://leetcode.cn/problems/binary-search/

    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left <= right) {
            // 防止溢出
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {-1,0,3,5,9,12};
        System.out.println(search(arr,9));

    }

}
