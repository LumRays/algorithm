package twoPointers;

import java.util.Arrays;

public class Demo5 {

    // 有效三角形的个数
    // https://leetcode.cn/problems/valid-triangle-number/

    public static int triangleNumber(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        // 利用双指针解决问题
        int ret = 0;
        int length = nums.length;
        // 先固定最大的数
        for(int i = length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while(left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    ret += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] arr = {2, 2, 3, 4};
        System.out.println(triangleNumber(arr));

    }

}
