package binarySearch;

public class Demo2 {

    // 在排序数组中查找元素的第一个和最后一个位置
    // https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/

    public static int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        // 处理边界情况
        if(nums.length == 0) {
            return ret;
        }
        // 二分左端点
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 判断是否有结果
        if(nums[left] != target) {
            return ret;
        } else {
            ret[0] = right;
        }
        // 二分右端点
        //left = 0;
        right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        // 判断是否有结果
        if(nums[right] != target) {
            return ret;
        } else {
            ret[1] = left;
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] arr = {5, 7, 7, 8, 8, 10};
        int[] arr2 = {};
        int[] ret = searchRange(arr,8);
        int[] ret2 = searchRange(arr2,0);
        for(int elem : ret) {
            System.out.print(elem + " ");
        }
        System.out.println();
        for(int elem : ret2) {
            System.out.print(elem + " ");
        }

    }

}
