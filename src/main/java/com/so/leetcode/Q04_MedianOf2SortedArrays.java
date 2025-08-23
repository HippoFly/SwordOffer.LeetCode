package com.so.leetcode;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-24 14:45
 * @tag
 * @link <a href=""></a>
 **/
public class Q04_MedianOf2SortedArrays {
    /**
     * 我们需要找到两个已排序数组 nums1 和 nums2 的中位数。中位数的定义是：
     * 如果合并后的数组长度为奇数，则中位数是中间的那个数。
     * 如果合并后的数组长度为偶数，则中位数是中间两个数的平均值。
     *
     * 总长度：totalLength 是两个数组的长度之和。
     * 奇数情况：如果总长度为奇数，直接返回第 (totalLength / 2 + 1) 小的元素。
     * 偶数情况：如果总长度为偶数，需要找到第 totalLength / 2 和第 totalLength / 2 + 1 小的两个元素，然后取它们的平均值
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 1) {
            // 奇数
            return getKthElement(nums1, nums2, totalLength / 2 + 1);
        } else {
            // 偶数
            int left = getKthElement(nums1, nums2, totalLength / 2);
            int right = getKthElement(nums1, nums2, totalLength / 2 + 1);
            return (left + right) / 2.0;
        }
    }

    /**
     * 初始索引：index1 和 index2 分别表示当前在 nums1 和 nums2 中的起始位置。
     * 边界处理：
     * 如果 nums1 已经遍历完，则直接从 nums2 中取出第 k 小的元素。
     * 如果 nums2 已经遍历完，则直接从 nums1 中取出第 k 小的元素。
     * 如果 k == 1，则比较 nums1[index1] 和 nums2[index2]，返回较小的那个。
     * 正常情况：
     * 每次尝试跳过 k/2 个元素（即二分法的思想），通过比较 pivot1 和 pivot2 来决定舍弃哪个数组的部分元素。
     * 更新 k 和对应的索引位置，继续迭代直到找到目标元素。
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    private int getKthElement(int[] nums1, int[] nums2, int k) {
       // 初始索引
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况处理
            if (index1 == nums1.length) {
                return nums2[index2 + k - 1];
            }
            if (index2 == nums2.length) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            // 要跳过的元素个数
            int half = k / 2;
            // half = k / 2：表示每次尝试跳过大约一半的元素（即二分法的思想）。
            // index1 + half 和 index2 + half：表示从当前索引开始，尝试向前移动 half 个位置。
            // Math.min(..., nums1.length) 和 Math.min(..., nums2.length)：确保不会超出数组的边界。
            // - 1：将索引调整为实际需要比较的位置（因为是从当前索引开始计算的偏移量）。
            // 最终，newIndex1 和 newIndex2 分别表示在 nums1 和 nums2 中要比较的元素位置
            int newIndex1 = Math.min(index1 + half, nums1.length) - 1;
            int newIndex2 = Math.min(index2 + half, nums2.length) - 1;

            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];

            // 条件判断：如果 pivot1 <= pivot2，
            // 说明 nums1 中从 index1 到 newIndex1 的所有元素都不可能是第 k 小的元素，因此可以舍弃这些元素。
            if (pivot1 <= pivot2) {
                // 如果舍弃了 nums1 的部分元素，则需要将 k 减去舍弃的元素个数 (newIndex1 - index1 + 1)。
                // 右边解释：newIndex1是 数组1的当前逻辑的中心，index1是数组1的逻辑起始点，1是补1
                k -= (newIndex1 - index1 + 1);
                // 舍弃后逻辑起点是中心+1
                index1 = newIndex1 + 1;

                // 以下是舍弃数组2的对比做法
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
