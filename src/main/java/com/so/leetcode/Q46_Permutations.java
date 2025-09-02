package com.so.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-05 11:31
 * @tag 回溯算法，排列
 * @link <a href=""></a>
 **/
public class Q46_Permutations {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length]; // 标记数组已经使用的状态
        List<Integer> cur = new ArrayList<>(); // 当前正在构建的排列
        backtrack(nums, cur, used);
        return result;
    }

    /**
     * 使用回溯法生成给定数组nums的所有排列
     *
     * @param nums    原始数组，包含不重复的整数
     * @param current 当前正在构建的排列
     * @param used    标记数组，用于指示nums中的每个元素是否已被使用
     */
    private void backtrack(int[] nums, List<Integer> current, boolean[] used) {
        // 0.加入结果 并终止递归
        // 当当前排列的长度与原始数组长度相等时，添加当前排列到结果中
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素未被使用，则尝试将其添加到当前排列中
            if (!used[i]) {
                // 1.暂态标记
                used[i] = true;
                current.add(nums[i]);

                // 2.开始递归
                backtrack(nums, current, used);

                // 3.回溯，移除刚才加的元素，撤销刚才标记
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

}
