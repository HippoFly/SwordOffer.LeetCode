package com.so.lc.leetcode;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 11:20
 * @tag 栈，双指针，数组，动态规划，单调栈
 * @see <a href="https://leetcode.cn/problems/trapping-rain-water/">42. 接雨水</a>
 **/
public class Q42_TrappingRainWater {


    /**
     * 解法1： 双指针
     *
     * 择矮端，然后从矮子端内移动，遇到新高则更替高墙，减去洼地
     *
     * @param height 高度数组
     * @return 雨水最多的雨水量
     */
    public int trap(int[] height) {
        // 如果数组为空，则返回 0
        if (height == null || height.length == 0) {
            return 0;
        }

        // 定义左右指针分别指向数组两端
        int left = 0, right = height.length - 1;
        // 初始化左右两侧的最大高度为 0
        int leftMax = 0, rightMax = 0;
        // 初始化结果变量为 0，用于累计雨水容量
        int result = 0;

        // 双指针向中间移动
        while (left < right) {

            // 总是处理较矮的一边（因为较矮的一边是瓶颈）

            if (height[left] < height[right]) {

                // 更新左边最大值或计算雨水

                //情况1：height[left] >= leftMax（当前位置比左边最高还高或相等）
                //这意味着当前位置是一个"高点"，无法在它上面接雨水
                //它只能成为别人接雨水的"墙"
                //所以我们要更新左边最高墙的记录：leftMax = height[left]
                if (height[left] >= leftMax) {
                    leftMax = height[left];  // 更新最大值

                    //情况2：height[left] < leftMax（当前位置比左边最高低）
                    //这意味着当前位置是一个"低点"，它可以接雨水
                    //所以要计算当前位置能接多少雨水
                    //即：当前位置的高度减去左边最高墙的高度
                } else {
                    result += leftMax - height[left];  // 累加雨水
                }
                left++;
            } else {
                // 更新右边最大值或计算雨水
                if (height[right] >= rightMax) {
                    rightMax = height[right];  // 更新最大值
                } else {
                    result += rightMax - height[right];  // 累加雨水
                }
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {3, 0, 1, 0, 2, 1/*,0,1,3,2,1,2,1*/};
        Q42_TrappingRainWater solution = new Q42_TrappingRainWater();
        int result = solution.trap(height);
        System.out.println(result);
    }

}





