package com.so.lc.leetcode;

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
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return "";
        }

        // 目标字符频率表 <字符，出现频率>
        Map<Character, Integer> targetFreq = new HashMap<>();
        // 目标字符串按字符频率放入哈希
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        // 初始化窗口字符频率表
        Map<Character, Integer> windowFreq = new HashMap<>();

        // 滑动窗口的左右边界
        int left = 0, right = 0;
        // 已匹配的字符数
        int matchCount = 0;
        // 最小窗口长度
        int minLength = Integer.MAX_VALUE;
        // 最小窗口的起始位置
        int start = 0;

        // 保证right
        while (right < s.length()) {

            // 以下在while前先放入一个虚拟字符，保证left<=right

            // 扩展窗口：将右指针指向的字符加入窗口
            char rightChar = s.charAt(right);
            windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);

            // 如果当前字符在目标中且频率匹配，则增加匹配计数
            if (targetFreq.containsKey(rightChar) &&
                    windowFreq.get(rightChar).intValue() == targetFreq.get(rightChar).intValue()) {
                matchCount++;
            }

            // 收缩窗口：当窗口中的字符完全覆盖目标时
            while (matchCount == targetFreq.size()) {
                // 更新最小窗口
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // 移动左指针，尝试缩小窗口
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                // 如果移除的字符导致不匹配，则减少匹配计数
                if (targetFreq.containsKey(leftChar) &&
                        windowFreq.get(leftChar).intValue() < targetFreq.get(leftChar).intValue()) {
                    matchCount--;
                }

                left++; // 缩小窗口
            }

            right++; // 扩展窗口
        }

        // 返回结果
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

}
