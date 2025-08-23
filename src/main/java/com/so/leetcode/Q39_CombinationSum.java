package com.so.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * <p>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-08 16:57
 * @tag
 * @link <a href=""></a>
 **/
public class Q39_CombinationSum {

 /*
    // 这里没有剪枝，而且也有重复排序问题
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;

    }

    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, Integer tempSum) {
        if (tempSum > target) {
            return;
        }
        if (tempSum == target) {
//            res.add(path);
            res.add(new ArrayList<>(path)); // ✅ 正确方式
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            path.add(candidates[i]);
            tempSum += candidates[i];
            backtrack(res, path, candidates, target, tempSum);
            path.remove(path.size() - 1);
            tempSum -= candidates[i];
        }

    }*/

    /*
    * ✅ 引入 start 参数 防止回头选择之前的元素，避免产生 [2,3,2] 和 [2,2,3] 被视为不同组合的问题
      ✅ 对 candidates 排序 确保我们能按顺序处理，便于剪枝和组合唯一性判断
      ✅ 使用 backtrack(..., i) 而不是 i + 1 表示同一个数字可以被多次选取
    *
    * */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 排序是为了剪枝和去重（保证组合不重复）
        backtrack(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    /**
     * 使用回溯法寻找所有加和为特定目标数的组合
     *
     * @param res        存储所有符合条件的组合的列表
     * @param path       当前遍历路径
     * @param candidates 候选数字数组
     * @param target     目标和
     * @param tempSum    当前路径的和
     * @param start      当前候选数字的起始索引
     */
    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int tempSum, int start) {
        // 如果当前路径的和超过了目标和，回溯
        if (tempSum > target) {
            return;
        }
        // 如果当前路径的和等于目标和，将当前路径添加到结果中，并回溯
        if (tempSum == target) {
            res.add(new ArrayList<>(path)); // 添加当前路径的拷贝
            return;
        }

        // 遍历候选数字，尝试添加到当前路径中
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]); // 添加当前候选数字到路径
            tempSum += candidates[i]; // 更新当前路径的和
            // 递归调用，继续探索下一个数字，允许重复使用当前元素
            backtrack(res, path, candidates, target, tempSum, i);
            // 回溯，移除当前数字，尝试下一个可能的数字
            path.remove(path.size() - 1);
            tempSum -= candidates[i]; // 更新当前路径的和
        }
    }


}
