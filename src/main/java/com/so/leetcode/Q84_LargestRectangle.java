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
     *
     * @param heights 柱状图的高度数组
     * @return 最大矩形面积
     */
    public int largestRectangleArea(int[] heights) {
        // 在 heights 数组两端添加高度为 0 的柱子，以便处理边界情况
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        // 使用 for 循环复制 heights 数组到 newHeights 数组
        for (int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }

        int n = newHeights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        /*
        对每个柱子，做两件事：

        如果当前柱子比栈顶柱子高，就直接把索引压进栈，保持递增。
        如果当前柱子矮于栈顶柱子，说明栈顶柱子再往右延伸就不行了，所以需要：
        弹出栈顶元素，计算以这个弹出的柱子为“最矮高度”的矩形面积。
        矩形的宽度是：i - stack.peek() - 1
        解释：i是当前柱子的位置，stack.peek()是弹出后的栈顶（也就是左边第一个比它矮的柱子）。
        中间夹着的那些柱子都比弹出的那个高，所以宽度是两者之间的数量。
        然后不断更新最大面积。
        */
        // 遍历新的高度数组
        for (int i = 0; i < n; i++) {
            // 当栈不为空且当前柱子高度小于栈顶柱子高度时，计算矩形面积
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];
                // -1是当前差距的数量
                int width = i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            // 当前柱子的索引入栈
            stack.push(i);
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
