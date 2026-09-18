package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo8 {

    // 四数之和
    // https://leetcode.cn/problems/4sum/

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for(int i = 0; i < length; ) {
            for(int j = i + 1; j < length; ) {
                int left = j + 1;
                int right = length - 1;
                long aim = (long)target - nums[i] - nums[j];
                while(left < right) {
                    int sum = nums[left] + nums[right];
                    if(sum > aim) {
                        right--;
                    } else if(sum < aim) {
                        left++;
                    } else {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
                j++;
                while(j < length && nums[j] == nums[j - 1]) {
                    j++;
                }
            }
            i++;
            while(i < length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, -1, 0, -2, 2};
        int[] arr2 = {2, 2, 2, 2, 2};
        List<List<Integer>> result = fourSum(arr, 0);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> elem = result.get(i);
            for (int j = 0; j < elem.size(); j++) {
                System.out.print(elem.get(j) + " ");
            }
            System.out.println();
        }

    }

}
