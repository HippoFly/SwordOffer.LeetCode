package com.so.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。
 * 返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/5 10:44
 **/

public class Q76_MinimumWindowSubstring {

    /**
     * 1,初始化数据结构：
     * 使用两个哈希表 targetFreq 和 windowFreq 分别记录目标字符串 t 和当前窗口中字符的频率。
     * 定义两个指针 left 和 right 表示滑动窗口的左右边界。
     * 定义变量 matchCount 记录窗口中已经匹配的字符数量。
     * 2,扩展窗口：
     * 不断移动右指针 right，将新字符加入窗口，并更新 windowFreq。
     * 如果某个字符的频率刚好满足 targetFreq 的要求，则增加 matchCount。
     * 3,收缩窗口：
     * 当 matchCount 等于 targetFreq.size() 时，表示当前窗口已完全覆盖 t。
     * 尝试移动左指针 left，缩小窗口，同时更新最小窗口的边界。
     * 如果移除的字符导致窗口不再满足覆盖条件，则减少 matchCount。
     * 4,返回结果：
     * 遍历结束后，返回最小窗口的子串。
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        // 1. 初始化数据结构
        Map<Character, Integer> need = new HashMap<>();   // 需要的字符频次
        Map<Character, Integer> window = new HashMap<>(); // 窗口中的字符频次

        // 2. 统计目标字符串的字符频次
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 3. 初始化滑动窗口指针和变量
        int left = 0, right = 0;
        int valid = 0; // 窗口中满足need条件的字符种类数
        int start = 0, len = Integer.MAX_VALUE; // 记录最小覆盖子串的起始索引和长度

        // 4. 滑动窗口主循环nide
        while (right < s.length()) {
            // 5. 扩张窗口
            char c = s.charAt(right);
            right++;

            // 6. 更新窗口数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 7. 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 8. 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // 9. 收缩窗口
                char d = s.charAt(left);
                left++;

                // 10. 更新窗口数据
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        // 11. 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
