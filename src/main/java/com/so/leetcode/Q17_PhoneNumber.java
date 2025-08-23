package com.so.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-08 14:39
 * @tag
 * @link <a href=""></a>
 **/
public class Q17_PhoneNumber {
    private final String[] letterMap = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // 输入边界处理
        if (digits == null || digits.length() == 0) {
            return result;
        }
        //
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    /**
     * 回溯函数，用于生成所有可能的字母组合
     * 注意这里结果组合长度 == 输入数字个数
     * 并且是组合，所以递归需要在for遍历中
     * @param digits 输入的数字字符串
     * @param index  当前处理的数字字符的索引
     * @param path   当前生成的字母组合路径
     * @param result 存储所有生成的字母组合的结果列表
     */
    private void backtrack(String digits, int index, StringBuilder path, List<String> result) {
        // 当前处理的数字字符索引等于数字字符串长度时，将当前路径转换为字符串并添加到结果列表中
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        // 输入数字 -> 对应字母表
        // digits本身就是一个数组，那么从0开始取出输入数组
        String letters = letterMap[digits.charAt(index) - '0'];
        // 遍历当前数字字符对应的所有可能的字母
        for (char c : letters.toCharArray()) {
            path.append(c); // 做出选择
            // 在做出选择后，递归调用回溯函数处理下一个数字字符
            backtrack(digits, index + 1, path, result); // 进入下一层
            // 回溯，撤销之前的选择
            path.deleteCharAt(path.length() - 1); // 回溯
        }
    }

}
