package com.so.leetcode;

import java.util.Stack;

/**
 * 394. 字符串解码
 * 没有嵌套括号
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-24 17:35
 * @tag
 * @link <a href=""></a>
 **/
public class Q394_DecodeString {
    /**
     * 解码字符串
     * 字符几大条件
     * 1，是数字，'['前乘10进位
     * 2，是'['，俩入栈，两复位
     * 3，是']'，出栈，拼接字符串，重复次数*拼接字符串，入栈
     * 4，是字母，直接拼接字符串
     *
     * @param s 输入的编码字符串
     * @return 解码后的字符串
     */
    public String decodeString(String s) {

        // 存储重复次数
        Stack<Integer> countStack = new Stack<>();
        // 存储当前的字符串片段
        Stack<StringBuilder> stringStack = new Stack<>();
        // 当前正在处理的字符串
        StringBuilder currentString = new StringBuilder();
        // 当前的重复次数
        int k = 0;

        for (char ch : s.toCharArray()) {

            // 如果是数字，更新重复次数 k
            if (Character.isDigit(ch)) {    // *记住这个 API 可以节省很多代码
                // 这里k是从0开始，所以不用担心第一次多十倍
                k = k * 10 + (ch - '0'); //这个公式记下，不好自己推导

                // 遇到左括号，压入（1，当前的字符串；2，重复次数）
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                // 复位（当前字符，计数）
                currentString = new StringBuilder();
                k = 0;


                // 遇到右括号，1.记住未压舱字符，弹出栈顶字符串，重复指定次数
            } else if (ch == ']') {
                StringBuilder curStrSuffix = currentString; //记下未压栈的字符
                currentString = stringStack.pop(); //弹出最后字符
                int repeatTimes = countStack.pop(); //弹出重复次数
                for (int i = 0; i < repeatTimes; i++) {
                    currentString.append(curStrSuffix); // 这里很重要: 弹出栈的 + 栈外的 * repeatTimes
                }

                // 如果是普通字符，直接添加到当前字符串
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        Q394_DecodeString solution = new Q394_DecodeString();

        // 测试用例
        String s1 = "3[a]2[bc]";
        System.out.println(solution.decodeString(s1)); // 输出: aaabcbc

        String s2 = "3[a2[c]]";
        System.out.println(solution.decodeString(s2)); // 输出: accaccacc

        String s3 = "2[abc]3[cd]ef";
        System.out.println(solution.decodeString(s3)); // 输出: abcabccdcdcdef
    }
}
