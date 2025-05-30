package com.so.lc.leetcode;

/**
 * 287. 寻找重复数
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/5 11:44
 **/

public class Q287_FindDuplicateNumber {
    /**
     * 链表快慢指针法（抽象）
     * <p>
     * 初始化： 定义两个指针，一个慢指针 slow 和一个快指针 fast，初始时它们都指向数组的第一个元素。
     * 原理
     * 移动： 快指针 fast 每次移动两步，慢指针 slow 每次移动一步，直到它们相遇。此时，快指针移动的总步数是慢指针的两倍。
     * 检测环： 如果快指针 fast 和慢指针 slow 相遇，说明数组中存在环。此时将快指针重新置为数组的第一个元素，并且将两个指针以相同的速度移动，直到它们再次相遇。相遇的点就是环的入口，即重复的数字。
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        // 定义快慢指针，初始时都指向数组的第一个元素
        int slow = nums[0];
        int fast = nums[nums[0]];

        // 找到快慢指针相遇的点
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // 将快指针重新置为数组的第一个元素
        fast = 0;

        // 快慢指针以相同的速度移动，直到它们再次相遇
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // 返回相遇的点，即重复的数字
        return slow;

    }

    /**
     * 二分法（好记）
     *
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        Q287_FindDuplicateNumber findDuplicateNumber = new Q287_FindDuplicateNumber();
        System.out.println(findDuplicateNumber.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
