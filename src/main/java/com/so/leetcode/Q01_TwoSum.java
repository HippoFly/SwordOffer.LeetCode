package com.so.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/1 14:55
 **/

public class Q01_TwoSum {

    /**
     * 寻找两个数，使它们的和等于目标值
     * 此方法使用哈希表来优化查找过程，避免了不必要的重复搜索
     *
     * 1. 一边把数组数值放入一个哈希表 key 数组序号 value 数组数值
     * 2. 取出哈希中的target- i 的数值 得到数组序号
     *
     * @param nums 输入的整数数组
     * @param target 目标值，我们需要找到两个数的和等于这个值
     * @return 返回一个包含这两个数索引的数组如果找不到这样的两个数，则返回null
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if(index !=null){
                return new int[]{i,index};
            }else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int[]{9,2, 7, 11, 15}, 9)));
    }
}
