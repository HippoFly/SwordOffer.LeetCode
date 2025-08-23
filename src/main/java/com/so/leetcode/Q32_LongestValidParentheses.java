package com.so.leetcode;

import java.util.Stack;

/**
 *
 * 32. 最长有效括号
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-21 16:15
 * @tag
 * @link <a href=""></a>
 **/
public class Q32_LongestValidParentheses {
    /**
     * 栈的作用：
     * 栈中保存的是字符的索引。
     * 初始时压入 -1 作为“上一个不合法位置”的标记。
     * 每次遇到 '(' 就把它的索引压入栈。
     * 遇到 ')' 时，弹出栈顶元素，表示匹配了一个 '('。
     * 如何计算长度：
     * 如果此时栈为空，说明没有匹配成功，将当前位置压入栈，更新“上一个不合法的位置”。
     * 如果栈非空，说明找到了一对匹配的括号，用当前索引 i 减去栈顶元素得到当前有效子串的长度，并更新 maxLen。
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // 初始化，代表“上一个不合法的位置”
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);  // 左括号，入栈索引
            } else {
                stack.pop();  // 尝试匹配一个 '('
                if (stack.isEmpty()) {
                    stack.push(i);  // 没匹配成功，更新“上一个不合法位置”
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

}
