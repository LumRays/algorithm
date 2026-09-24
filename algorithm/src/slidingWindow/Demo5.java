package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Demo5 {

    // 水果成篮
    // https://leetcode.cn/problems/fruit-into-baskets/

    public static int totalFruit(int[] fruits) {
        // 问题转化
        // 找到一个最长的子数组 且子数组中水果类型不超过 2 种
        // 统计窗口内水果的种类
        Map<Integer, Integer> hash = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = fruits.length;
        int ret = 0;
        for(right = 0; right < n; right++) {
            int in = fruits[right];
            // 进窗口
            hash.put(in, hash.getOrDefault(in, 0) + 1);
            while(hash.size() > 2) {
                int out = fruits[left];
                // 出窗口
                hash.put(out, hash.get(out) - 1);
                if(hash.get(out) == 0) {
                    hash.remove(out);
                }
                left++;
            }
            // 更新结果
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 2};
        int[] arr2 = {1, 2, 3, 2, 2};
        System.out.println(totalFruit(arr));
        System.out.println(totalFruit(arr2));

    }

}
