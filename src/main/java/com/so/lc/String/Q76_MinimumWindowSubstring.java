package com.so.lc.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/5 10:44
 **/

public class Q76_MinimumWindowSubstring {
    // 覆盖字串返回且唯一，请返回
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetFreq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();

        // 目标字符串中字符的出现频率
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }
        // 定义窗口的左右边界 这里左右是要移动的
        int left = 0, right = 0;

        // 这里的左是记录符合覆盖字串的左边界
        int minLeft = 0;
        int minRight = Integer.MAX_VALUE;

        // 记录窗口中已经匹配的字符数量
        int matchCount = 0;

        // 移动右指针，扩展窗口
        while (right < s.length()) {

            // 右边界填字符
            char c = s.charAt(right);
            // 更新窗口中字符的出现频率
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            right++;

            // 单个字符频率匹配
            // 窗口中当前字符的出现频率等于目标字符串中该字符的出现频率，则匹配数加1(不是整个词组匹配)
            if (targetFreq.containsKey(c) && windowFreq.get(c).intValue() == targetFreq.get(c).intValue()) {
                matchCount++;
            }

            // 窗口中包含了目标字符串，则尝试缩小窗口
            while (matchCount == targetFreq.size()) {
                // 更新最小 左边界 有边界
                if (right - left < minRight-minLeft) {
                    minRight = right  ;
                    minLeft = left;
                }

                // 左边界右移，移除左字符
                char leftCharInWindow = s.charAt(left);
                left++;
                windowFreq.put(leftCharInWindow, windowFreq.get(leftCharInWindow) - 1);

                // 如果窗口中某个字符的出现频率小于目标字符串中该字符的出现频率，则匹配数减1
                if (targetFreq.containsKey(leftCharInWindow) && windowFreq.get(leftCharInWindow) < targetFreq.get(leftCharInWindow)) {
                    matchCount--;
                }
            }
        }

        // 如果找到了最小窗口，则返回对应的子串，否则返回空串
        return minRight == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight);
    }

}
