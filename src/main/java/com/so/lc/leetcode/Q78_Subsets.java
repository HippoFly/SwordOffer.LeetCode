package com.so.lc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-08 10:23
 * @tag
 * @link <a href=""></a>
 **/
public class Q78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * 使用回溯法生成给定数组nums的所有子集
     * 回溯法是一种通过试错来寻找解决方案的算法，它通过增量方式构建候选解决方案，并在确定某一步不正确时回退
     *
     * @param nums    原始数组，用于生成子集
     * @param start   当前考虑的数组起始索引，避免重复选择
     * @param current 当前构建的子集
     * @param result  存储所有生成的子集的结果列表
     */
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // 每一层递归都记录当前子集，因为每个节点都可以是一个子集
        result.add(new ArrayList<>(current));

        // 从当前索引开始遍历数组元素
        for (int i = start; i < nums.length; i++) {
            // 将当前元素添加到子集中，这是做出选择的步骤
            current.add(nums[i]);
            // 进入下一层递归，继续选择下一个元素
            backtrack(nums, i + 1, current, result);
            // 回溯，撤销之前的选择，以便尝试其他可能的元素组合
            current.remove(current.size() - 1);
        }
    }

}
