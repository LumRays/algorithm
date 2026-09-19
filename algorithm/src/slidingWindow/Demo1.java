package slidingWindow;

public class Demo1 {

    // 长度最小的子数组
    // https://leetcode.cn/problems/minimum-size-subarray-sum/description/

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for(right = 0; right < n; right++) {
            // 进窗口
            sum += nums[right];
            // 判断
            while(sum >= target) {
                // 更新结果
                len = Math.min(right - left + 1, len);
                // 出窗口
                sum -= nums[left];
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 2, 4, 3};
        int[] arr2 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minSubArrayLen(7, arr));
        System.out.println(minSubArrayLen(11, arr2));

    }

}
