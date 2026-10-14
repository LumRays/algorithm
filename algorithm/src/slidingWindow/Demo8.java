package slidingWindow;

public class Demo8 {

    // 最小覆盖子串
    // https://leetcode.cn/problems/minimum-window-substring/

    public static String minWindow(String ss, String tt) {
        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();
        // 统计字符串 tt 中的字符种数
        int kinds = 0;
        // 统计字符串 tt 中字符的频次
        int[] hash1 = new int[128];
        // 统计窗口中字符出现的频次
        int[] hash2 = new int[128];
        for(char ch : t) {
            if(hash1[ch] == 0) {
                kinds++;
            }
            hash1[ch]++;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int minlen = Integer.MAX_VALUE;
        int begin = -1;
        for(; right < s.length; right++) {
            char in = s[right];
            // 进窗口
            hash2[in]++;
            // 维护 count
            if(hash1[in] == hash2[in]) {
                count++;
            }
            // 判断
            while(kinds == count) {
                // 更新结果
                if(right - left + 1 < minlen) {
                    begin = left;
                    minlen = right - left + 1;
                }
                char out = s[left];
                left++;
                // 维护 count
                if(hash1[out] == hash2[out]) {
                    count--;
                }
                // 出窗口
                hash2[out]--;
            }
        }
        if(begin == -1) {
            return new String();
        } else {
            return ss.substring(begin,begin + minlen);
        }
    }

    public static void main(String[] args) {

        String str1 = "ADOBECODEBANC";
        String str2 = "ABC";
        System.out.println(minWindow(str1,str2));

    }

}
