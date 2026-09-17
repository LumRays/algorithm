package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo7 {

    // 三数之和
    // https://leetcode.cn/problems/3sum/description/

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        // 先对数组进行排序
        Arrays.sort(nums);
        int length = nums.length;
        // 利用双指针算法解决问题
        // 先固定一个数
        // 由于循环一次后 i 已经到了正确的位置(遍历了每一个数 && 不与前一个数相同) 因此不需要再 i++ 了
        for(int i = 0; i < length; ) {
            // 数组已经有序的条件下 若 nums[i] > 0 就不需要往后找了
            if(nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = length - 1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum < -nums[i]) {
                    left++;
                } else if(sum > -nums[i]) {
                    right--;
                } else {
                    ret.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 缩小区间 继续寻找
                    left++;
                    right--;
                    // 进行去重操作
                    // 注意 left 不可以超过 right
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
            // nums[i] 也要进行去重
            i++;
            // 注意 i 也不可以越界
            while(i < length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(arr);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> elem = result.get(i);
            for (int j = 0; j < elem.size(); j++) {
                System.out.print(elem.get(j) + " ");
            }
            System.out.println();
        }

    }

}
