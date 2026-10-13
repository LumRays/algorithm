package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo7 {

    // 串联所有单词的子串
    // https://leetcode.cn/problems/substring-with-concatenation-of-all-words/

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<Integer>();
        Map<String, Integer> hash1 = new HashMap<String, Integer>();
        // 保存 words 中所有单词的频次
        for(String str:words) {
            hash1.put(str, hash1.getOrDefault(str, 0) + 1);
        }
        int len = words[0].length();
        int m = words.length;
        for(int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> hash2 = new HashMap<String, Integer>();
            for(right = i; right + len <= s.length(); right += len) {
                // 进窗口 + 维护 count
                String in = s.substring(right, right + len);
                hash2.put(in, hash2.getOrDefault(in, 0) + 1);
                if(hash2.get(in) <= hash1.getOrDefault(in, 0)) {
                    count++;
                }
                // 判断
                if(right - left + 1 > len * m) {
                    // 出窗口 + 维护 count
                    String out = s.substring(left, left + len);
                    if(hash2.get(out) <= hash1.getOrDefault(out, 0)) {
                        count--;
                    }
                    hash2.put(out, hash2.get(out) - 1);
                    left += len;
                }
                // 更新结果
                if(count == m) {
                    ret.add(left);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        String str = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        List<Integer> ret = findSubstring(str, words);
        for(int elem:ret) {
            System.out.print(elem + " ");
        }

    }

}
