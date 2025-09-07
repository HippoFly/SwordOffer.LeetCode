package com.so.leetcode;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 看图才能懂
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-28 23:34
 * @tag 单调栈
 * @link <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/"></a>
 **/
public class Q84_LargestRectangle {
    /**
     * 计算柱状图中最大的矩形面积
     * 单调栈
     * •
     * 1.每个柱子都入栈，但如果没有发生单调变化，我们放内部不管
     * 2.只有当前柱子比栈顶柱子矮时：说明其已经产生变小的威胁，弹出并计算它，但是不用担心其之后哪怕更矮会通过宽度弥补，因为它本身以后还要入栈
     *
     * @param heights 柱状图的高度数组
     * @return 最大矩形面积
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        // 遍历每个柱子
        for (int i = 0; i <= n; i++) {
            // 当前高度（这里特意让 i 可以==n，超出数组范围时设为0）
            /*
            * 强制触发栈的弹出操作 当 i = n时，currHeight = 0（虚拟柱子），此时所有栈中剩余的柱子都会满足 currHeight < heights[stack.peek()]，从而被弹出并计算面积。
            * */
            int currHeight = (i == n) ? 0 : heights[i];

            // 当遇到比栈顶柱子矮的柱子时，代表其对比，要开始计算面积
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // 弹出栈顶柱子的高度
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i); // 当前索引入栈
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Q84_LargestRectangle solution = new Q84_LargestRectangle();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = solution.largestRectangleArea(heights);
        System.out.println("最大矩形面积: " + result); // 输出 10
    }
}
