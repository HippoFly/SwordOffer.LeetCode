package com.so.lc.BaseConversion;

import java.util.Scanner;

/**
 *  描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 * 示例1
 * 输入：
 * 0xAA
 * 复制
 * 输出：
 * 170
 * @author FH
 */
public class BaseConversion {
    public static void main(String[] args) {

    }


    public static void hexString2Decimal(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) {
            // 全小写避免判断
            String s = in.nextLine().toLowerCase();
            int count = 0;
            int length = s.length();
            // i=2: '0x' eradicate
            for (int i = 2; i < length; i++) {
                char c = s.charAt(i);
                int t = 0;
                if (c >= '0' && c <= '9') {
                    t = c - '0';
                }else if (c >= 'a' && c <= 'f') {
                    t = c - 'a' + 10;
                }
                // (length - i - 1)： length-i是前缀 1是本身 例如 0xA2 -> A = 10 * 16 ^(4-2-1)
                count += t * Math.pow(16, length - i - 1);
            }
            System.out.println(count);
        }
    }
}
