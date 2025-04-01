package com.so.lc.leetcode;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 9:39
 **/

public class Q11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int ans = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, area);
            // 这里是关键 有一个比较小则迁移它，试图寻求较大值
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return ans;

    }

    private void compare(int big1, int big2, int i) {
        if(i>big1){
            big1 = i;
        }else {
            if(i>big2){
                big2 = i;
            }
        }
    }
}
