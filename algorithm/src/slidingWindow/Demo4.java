package slidingWindow;

public class Demo4 {

    // 将 x 减到 0 的最小操作数
    // https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/

    public static int minOperations(int[] nums, int x) {
        // 问题转化
        // 找到最长子数组的长度 且这个子数组的元素之和恰好为 sum - x (正难则反)
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int ret = -1;
        for(int a : nums) {
            sum += a;
        }
        int target = sum - x;
        if(target < 0) {
            return -1;
        }
        int tmp = 0;
        for(right = 0; right < n; right++) {
            // 进窗口
            tmp += nums[right];
            while(tmp > target) {
                // 出窗口
                tmp -= nums[left];
                left++;
            }
            if(tmp == target) {
                // 更新结果
                ret = Math.max(ret, right - left + 1);
            }
        }
        if(ret == -1) {
            return -1;
        } else {
            return n - ret;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 4, 2, 3};
        int[] arr2 = {5, 6, 7, 8, 9};
        int[] arr3 = {3, 2, 20, 1, 1, 3};
        System.out.println("将 x 减小到 0 的最小操作数为 " + minOperations(arr, 5));
        System.out.println("将 x 减小到 0 的最小操作数为 " + minOperations(arr2, 4));
        System.out.println("将 x 减小到 0 的最小操作数为 " + minOperations(arr3, 10));

    }

}
