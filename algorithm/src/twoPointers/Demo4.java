package twoPointers;

public class Demo4 {

    // 盛最多水的容器
    // https://leetcode.cn/problems/container-with-most-water/description/

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ret = 0;
        while(left < right) {
            int vol = Math.min(height[left], height[right]) * (right - left);
            ret = Math.max(ret, vol);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));

    }

}
