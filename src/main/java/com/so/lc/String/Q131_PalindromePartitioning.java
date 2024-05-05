package com.so.lc.String;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/5 14:58
 **/

public class Q131_PalindromePartitioning {
    public static void main(String[] args) {
        Q131_PalindromePartitioning partitioning = new Q131_PalindromePartitioning();
        System.out.println(partitioning.partition("AAABB"));
    }
    public List<List<String>> partition(String s) {
        string = s;
        result = new ArrayList<>();
        currentPartition = new ArrayList<>();

        backtrack(0);
        return result;
    }

    String string;
    List<String> currentPartition;
    List<List<String>> result;

    private void backtrack(int start) {
        // 如果起始位置已经到达字符串末尾，说明已经生成了一种分割方案，加入结果列表中
        if (start == string.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        // 遍历所有可能的分割点
        for (int i = start; i < string.length(); i++) {
            String substring = string.substring(start, i + 1);
            // 如果当前子串是回文字符串，加入当前分割方案，并继续向下生成
            if (isPalindrome(substring)) {
                currentPartition.add(substring);
                backtrack(i + 1);
                // 回溯，移除当前加入的子串，尝试其他分割方案
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    /**
     * 判断回文
     *
     * @param s
     * @return
     */
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
