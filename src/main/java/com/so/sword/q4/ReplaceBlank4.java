package com.so.sword.q4;

import java.util.Arrays;

/**
 * 第4题
 * 将一个字符串中的空格替换成"%20"
 *
 */
public class ReplaceBlank4 {

    /**
     * 解法一：使用StringBuffer
     *
     * @param input
     * @return
     */
    public static String replaceBlank1(String input) {
        if (input == null) {
            return null;
        }
        StringBuffer outputBuffer = new StringBuffer();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                outputBuffer.append("%20");
            } else {
                outputBuffer.append(input.charAt(i));
            }
        }

        return outputBuffer.toString();
    }

    /**
     * 解法二：使用StringBuilder
     *
     * @param input
     * @return
     */
    public static String replaceBlank2(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (" ".equals(String.valueOf(input.charAt(i)))) {
                sb.append("%20");
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 解法三：从后往前复制
     *
     * @param input
     * @return
     */
    public static String replaceBlank3(String input) {
        if (input == null) {
            return null;
        }
        int blankCount = 0;
        int length = input.length();
        int newLength = 0;
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == ' ') {
                blankCount++;
            }
        }
        // 替换后的字符串长度
        newLength = length + 2 * blankCount;
        char[] newChars = new char[newLength];
        int index = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (input.charAt(i) == ' ') {
                newChars[index--] = '0';
                newChars[index--] = '2';
                newChars[index--] = '%';
            } else {
                newChars[index--] = input.charAt(i);
            }
        }
        return Arrays.toString(newChars);
    }
}
