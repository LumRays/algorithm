package slidingWindow;

public class Demo2 {

    // 无重复字符的最长子串
    // https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/

    public static int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        // 用数组模拟哈希表 下标所对应的 ASCII 值足以满足题目条件
        int[] hash = new int[128];
        int left = 0;
        int right = 0;
        int ret = 0;
        int n = s.length();
        while(right < n) {
            // 进入窗口
            hash[ss[right]]++;
            // 判断
            while(hash[ss[right]] > 1) {
                hash[ss[left]]--;
                // 出窗口
                left++;
            }
            // 更新结果
            ret = Math.max(ret, right - left + 1);
            // 让下一个字符进入窗口
            right++;
        }
        return ret;
    }

    public static void main(String[] args) {

        String str = "dabcedbcaf";
        int result = lengthOfLongestSubstring(str);
        System.out.println("不含有重复字符的最长子串的长度为: " + result);

    }

}
