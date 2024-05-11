package com.so.lc.Array;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 11:20
 **/

public class Q42_TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0; // 如果数组为空，则返回 0

        int left = 0, right = height.length - 1; // 定义左右指针分别指向数组两端
        int leftMax = 0, rightMax = 0; // 初始化左右两侧的最大高度为 0
        int result = 0; // 初始化结果变量为 0，用于累计雨水容量

        while (left < right) {
            // 从矮处开始
            // 如果左侧高度小于右侧高度，
            if (height[left] < height[right]) {
                // 当前列为最大，不计算积水，只更新高度，因为装不住水
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // 最高左比当前高度还高 可以装水
                    result += leftMax - height[left]; // 计算当前位置的雨水容量并累加到结果中
                }
                left++; // 左指针向右移动
                // 如果右侧高度小于等于左侧高度
            } else {
                // 如果当前右侧高度大于等于右侧最大高度
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // 更新右侧最大高度
                } else {
                    result += rightMax - height[right]; // 计算当前位置的雨水容量并累加到结果中
                }
                right--; // 右指针向左移动
            }
        }

        return result; // 返回总的雨水容量
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1/*,0,1,3,2,1,2,1*/};
        Q42_TrappingRainWater solution = new Q42_TrappingRainWater();
        int result = solution.trap(height);
        System.out.println(result);
    }

}
