package twoPointers;

import java.util.Arrays;

public class Demo6 {

    // 两数之和
    // https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/

    public static int[] twoSum(int[] price, int target) {
        int left = 0;
        int right = price.length - 1;
        while(left < right) {
            if(price[left] + price[right] < target) {
                left++;
            } else if(price[left] + price[right] > target) {
                right--;
            } else {
                return new int[]{price[left], price[right]};
            }
        }
        return new int[]{0};
    }

    public static void main(String[] args) {

        int[] arr = {2, 5, 18, 33, 35, 46};
        System.out.println(Arrays.toString(twoSum(arr, 53)));

    }

}
