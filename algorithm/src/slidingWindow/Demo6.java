package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class Demo6 {

    // 找到字符串中所有字母异位词
    // https://leetcode.cn/problems/find-all-anagrams-in-a-string/

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        // 统计字符串 p 中每一个字符出现的个数
        int[] hash1 = new int[26];
        for(char ch : p1) {
            hash1[ch - 'a']++;
        }
        // 统计窗口中每一个字符出现的个数
        int[] hash2 = new int[26];
        int left = 0;
        int right = 0;
        int count = 0;
        int n = s1.length;
        int m = p1.length;
        for(right = 0; right < n; right++) {
            char in = s1[right];
            // 进窗口
            hash2[in - 'a']++;
            // 维护 count 变量
            if(hash2[in - 'a'] <= hash1[in - 'a']) {
                count++;
            }
            if(right - left + 1 > m) {
                char out = s1[left++];
                if(hash2[out - 'a'] <= hash1[out - 'a']) {
                    count--;
                }
                hash2[out - 'a']--;
            }
            // 更新结果
            if(count == m) {
                ret.add(left);
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        String str1 = "cbaebabacd";
        String str2 = "abc";
        List<Integer> result = findAnagrams(str1, str2);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

    }

}
