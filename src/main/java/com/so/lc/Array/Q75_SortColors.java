package com.so.lc.Array;

import java.util.Arrays;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 15:12
 **/

public class Q75_SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        // 处理特殊情况，数组为空或长度为 0，直接返回

        int left = 0, right = nums.length - 1;
        // 定义左右两个指针，分别指向已经排好的 0 的右边界和已经排好的 2 的左边界

        int curr = 0;
        // 当前遍历的指针

        while (curr <= right) {
            // 循环直到当前遍历指针超过了已经排好的 2 的左边界

            if (nums[curr] == 0) {
                // 如果当前元素是 0

                swap(nums, curr, left);
                // 将当前元素和已经排好的 0 的右边界的下一个位置交换

                curr++;
                // 当前指针右移
                left++;
                // 已排好的 0 的右边界右移

            } else if (nums[curr] == 2) {

                // 如果当前元素是 2
                swap(nums, curr, right);
                // 将当前元素和已经排好的 2 的左边界的前一个位置交换
                right--;
                // 已排好的 2 的左边界左移
                // 注意：此时不需要移动当前指针，因为交换后当前位置可能是 0 或 1，需要继续判断

            } else {
                // 如果当前元素是 1

                curr++;
                // 当前指针右移，继续判断下一个元素
            }
        }
    }
    private void swap(int[] nums, int i, int j) { // 定义交换元素的方法
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) { // 主函数用于测试
        int[] nums = {2,0,2,1,1,0}; // 示例输入数组
        Q75_SortColors solution = new Q75_SortColors(); // 创建解决问题的对象
        solution.sortColors(nums); // 调用排序方法
        System.out.println(Arrays.toString(nums)); // 输出排序后的数组
    }
}
