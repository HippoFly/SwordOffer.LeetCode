package com.so.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/1 15:51
 * @tag 哈希
 * @link <a href="https://leetcode.cn/problems/longest-consecutive-sequence/description/">最长连续</a>
 **/

public class Q128_LongestConsecutiveSequence {
    /**
     * 简单来说就是每个数都判断一次这个数是不是连续序列的开头那个数。
     * <p>
     * 怎么判断呢，就是用哈希表查找这个数前面一个数是否存在，即num-1在序列中是否存在。存在那这个数肯定不是开头，直接跳过。
     * 因此只需要对每个开头的数进行循环，直到这个序列不再连续，因此复杂度是O(n)。 以题解中的序列举例:
     * [100，4，200，1，3，4，2]
     * 去重后的哈希序列为：
     * [100，4，200，1，3，2]
     * 按照上面逻辑进行判断：
     * 元素100是开头,因为没有99，且以100开头的序列长度为1
     * 元素4不是开头，因为有3存在，过，
     * 元素200是开头，因为没有199，且以200开头的序列长度为1
     * 元素1是开头，因为没有0，且以1开头的序列长度为4，因为依次累加，2，3，4都存在。
     * 元素3不是开头，因为2存在，过，
     * 元素2不是开头，因为1存在，过。
     * @param nums 输入的整数数组
     * @return 返回最长连续序列的长度
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> allNumSet = new HashSet<>();
        // 去重
        for (int num : nums) {
            allNumSet.add(num);
        }

        int longestCount = 0;

        for (int num : allNumSet) {
            // 检测到是序列的开头（包含有小1的数字）
            if (!allNumSet.contains(num - 1)) {

                int currentNum = num;
                int currentCount = 1;
                // 开始计数连续的
                while (allNumSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentCount += 1;
                }

                longestCount = Math.max(longestCount, currentCount);
            }
        }

        return longestCount;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, 3, 2, 55, 2, 11, 23, 321, 24}));

    }

}
