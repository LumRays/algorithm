package twoPointers;

public class Demo1 {

    // https://leetcode.cn/problems/move-zeroes/

    public static void moveZeroes(int[] nums) {
        int cur = 0;
        int dest = -1;
        for(cur = 0; cur < nums.length; cur++) {
            if(nums[cur] != 0) {
                dest++;
                int tmp = nums[cur];
                nums[cur] = nums[dest];
                nums[dest] = tmp;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 12};
        int[] arr2 = {0};
        moveZeroes(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
