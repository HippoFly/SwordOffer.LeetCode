package com.so.lc.leetcode;

/**
 *  给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 9:39
 * @tag 数组，双指针
 * @link <a href="https://leetcode.cn/problems/container-with-most-water/description/">装最多水</a>
 **/

public class Q11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        // 初始化最大面积为0，左右指针分别指向数组的两端
        int ans = 0, left = 0, right = height.length - 1;
        // 当左指针小于右指针时，进行循环
        while (left < right) {
            // 计算当前左右指针指向的点形成的面积
            int area = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, area);
            // 如果左边的点高度小于右边的点高度，则将左边的指针向右移动一位，反之亦然
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
            System.out.println("left:"+left+" right:"+right+" area:"+area);
            System.out.println("ans:"+ans);
            System.out.println("===================");
        }
        return ans;

    }

    public static void main(String[] args) {
        Q11_ContainerWithMostWater containerWithMostWater = new Q11_ContainerWithMostWater();
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(containerWithMostWater.maxArea(ints));
    }
}
