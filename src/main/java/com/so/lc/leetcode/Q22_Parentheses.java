package com.so.lc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-09 11:06
 * @tag
 * @link <a href=""></a>
 **/
public class Q22_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    /**
     * 使用回溯法生成所有可能的括号组合
     *  这里通过 有括号< 左括号< n
     * @param result  存储所有有效括号组合的列表
     * @param current 当前构建的括号字符串
     * @param leftBracket    已添加的左括号数量
     * @param rightBracket   已添加的右括号数量
     * @param n       指定的括号对数
     */
    private void backtrack(List<String> result, String current, int leftBracket, int rightBracket, int n) {
        // 当前括号字符串达到指定长度时，添加到结果列表
        // n是指定的括号对数
        if (current.length() == n * 2) {
            result.add(current);
            return;
        }
        // 如果左括号没有到限定的括号数,添加左括号
        if (leftBracket < n) {
            backtrack(result, current + "(", leftBracket + 1, rightBracket, n);
        }
        // 如果右括号数依然小于左括号，添加右括号
        if (rightBracket < leftBracket) {
            backtrack(result, current + ")", leftBracket, rightBracket + 1, n);
        }
    }

}
