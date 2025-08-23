package com.so.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-27 10:57
 * @tag 单调栈
 * @link <a href=""></a>
 **/
public class Q739_DailyTemperatures {
    /**
     * 思路如下：
     * 对温度数组遍历，依次push每一个元素
     * 但是在push前记得用当前温度 依次对比栈内的 索引处温度
     * （一个数字还在栈内本身就说明其索引处未标记接下来高温）
     *  总而言之，栈内就是未标记索引，while循环就是当前为高进行回溯标记
     * @param temperatures 每日气温列表，每个元素代表一天的气温
     * @return 每天到气温升高之前的等待天数数组
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // 气温列表长度
        int n = temperatures.length;
        // 存储结果的数组，初始值都为0，表示如果没有找到更高的气温，则等待天数为0
        int[] answer = new int[n];
        // 单调递减栈，存储索引，用于记录气温递减的日期索引
        Stack<Integer> stack = new Stack<>();

        // 遍历气温列表
        for (int i = 0; i < n; i++) {

            // 当栈不为空且当前气温大于栈顶索引对应的气温时，说明找到了更高气温的日子
            // temperatures[stack.peek()]具体来说，它获取的是栈顶索引所指向的那一天的气温。
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 弹出栈顶索引，计算当前索引与栈顶索引的差值，即等待天数
                int prevIndex = stack.pop();
                // i当前天，prevIndex是
                answer[prevIndex] = i - prevIndex;
            }
            // 当前索引入栈，维持单调递减栈
            stack.push(i);

        }

        // 返回结果数组
        return answer;
    }

    public static void main(String[] args) {
        Q739_DailyTemperatures solution = new Q739_DailyTemperatures();
//        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] result = solution.dailyTemperatures(temperatures);
//        System.out.println(Arrays.toString(result)); // 输出 [1, 1, 4, 2, 1, 1, 0, 0]
        int[] temperatures2 = {5, 6, 7, 3, 1, 4, 8, 5};
        int[] result2 = solution.dailyTemperatures(temperatures2);
        System.out.println(Arrays.toString(result2)); // 输出 [1, 1, 4, 2, 1, 1, 0, 0]
    }

}
