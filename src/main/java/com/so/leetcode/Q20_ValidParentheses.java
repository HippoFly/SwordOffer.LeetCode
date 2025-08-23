package com.so.leetcode;

import java.util.Stack;

/**
 *
 * 20. 有效的括号
 *
 * \给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *  示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([])"
 * 输出：true
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-24 16:07
 * @tag 栈
 * @link <a href=""></a>
 **/
public class Q20_ValidParentheses {
    /**
     * 判断字符串中的括号是否有效
     *
     * @param s 输入的字符串
     * @return 如果括号有效返回 true，否则返回 false
     */
    public boolean isValid(String s) {
        // 使用栈来存储左括号
        Stack<Character> stack = new Stack<>();

        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // 左括号入栈
                stack.push(c);
            } else {
                // 右括号时，检查栈顶元素是否匹配
                if (stack.isEmpty()) {
                    return false; // 栈为空，说明没有匹配的左括号
                }
                char top = stack.pop(); // 弹出栈顶元素
                if (!isMatch(top, c)) {
                    return false; // 栈顶元素与当前右括号不匹配
                }
            }
        }

        // 最终检查栈是否为空
        return stack.isEmpty();
    }

    /**
     * 判断左右括号是否匹配
     *
     * @param left  左括号
     * @param right 右括号
     * @return 如果匹配返回 true，否则返回 false
     */
    private boolean isMatch(char left, char right) {
        return (left == '(' && right == ')') ||
                (left == '{' && right == '}') ||
                (left == '[' && right == ']');
    }

}
