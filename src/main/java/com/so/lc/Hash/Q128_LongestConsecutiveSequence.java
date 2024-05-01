package com.so.lc.Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/1 15:51
 **/

public class Q128_LongestConsecutiveSequence {
    /**
     * 简单来说就是每个数都判断一次这个数是不是连续序列的开头那个数。
     *
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
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        // 去重
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            // 不是序列的开头（包含有小1的数字） 不开始计算
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                // 开始计数连续的
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        longestConsecutive(new int[]{1, 3, 2, 55, 2, 11, 23, 321, 24});
    }

}
