package binarySearch;

public class Demo4 {

    // 搜索插入位置
    // https://leetcode.cn/problems/search-insert-position/description/

    public static int searchInsert(int[] nums, int target) {
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
        if(nums[left] < target) {
            return left + 1;
        }
        return left;
    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 7, 23, 45, 65};
        System.out.println(searchInsert(arr,88));
        System.out.println(searchInsert(arr,7));
        System.out.println(searchInsert(arr,6));

    }

}
