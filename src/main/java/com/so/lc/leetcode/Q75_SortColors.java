package com.so.lc.leetcode;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 15:12
 **/

public class Q75_SortColors {
    /**
     * 使用了三个指针：
     * left：指向最后一个 已经排好的 0 的后面（即下一个非 0 元素应该放的位置）；
     * curr：当前正在处理的元素；
     * right：指向第一个 已经排好的 2 的前面（即下一个非 2 元素应该放的位置）；
     *
     * 所以对于
     * 当前是1，则不处理，cur右移
     * 当前是0，交换到left
     * 当前是2，交换到right
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        // 处理特殊情况，数组为空或长度为 0，直接返回
        if (nums == null || nums.length == 0) return;

        // 定义左右两个指针，分别指向已经排好的 0（红色） 的右边界和已经排好的 2（蓝色） 的左边界
        int left = 0, right = nums.length - 1;
        // 当前遍历的指针
        int curr = 0;

        // 循环直到当前遍历指针超过了已经排好的 2 的左边界
        while (curr <= right) {

            // 如果当前元素是 0
            if (nums[curr] == 0) {

                // 将当前元素和已经排好的 0（红色） 的右边界的下一个位置交换
                swap(nums, curr, left);

                // 当前指针右移
                curr++;
                // 已排好的 0 的右边界右移
                left++;

                // 如果当前元素是 2
            } else if (nums[curr] == 2) {

                swap(nums, curr, right);
                // 将当前元素和已经排好的 2 的左边界的前一个位置交换
                // 已排好的 2 的左边界左移
                right--;

                // 注意：此时不需要移动当前指针，因为交换后当前位置可能是 0 或 1，需要继续判断

            } else {
                // 如果当前元素是 1

                curr++;
                // 当前指针右移，继续判断下一个元素
            }
        }
    }

    /**
     * 交换数组中的两个元素
     * 此方法用于在给定数组中交换两个指定位置的元素
     *
     * @param nums 数组，其中的元素将被交换
     * @param i    第一个交换元素的索引
     * @param j    第二个交换元素的索引
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) { // 主函数用于测试
        int[] nums = {2, 0, 2, 1, 1, 0}; // 示例输入数组
        Q75_SortColors solution = new Q75_SortColors(); // 创建解决问题的对象
        solution.sortColors(nums); // 调用排序方法
        System.out.println(Arrays.toString(nums)); // 输出排序后的数组
    }
}
