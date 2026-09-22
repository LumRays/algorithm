package slidingWindow;

public class Demo3 {

    // 最大连续 1 的个数
    // https://leetcode.cn/problems/max-consecutive-ones-iii/

    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int count = 0;
        int ret = 0;
        for(right = 0; right < n; right++) {
            if(nums[right] == 0) {
                count++;
            }
            while(count > k) {
                if(nums[left] == 0) {
                    count--;
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes(arr, 2));

    }

}
