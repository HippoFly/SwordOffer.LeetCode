package com.so.leetcode;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
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
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保nums1是较短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m; //短数组的左右指针，通过移动他们，确定短数组的切割线，进而确定长数组的切割线mid
        int halfLen = (m + n + 1) / 2;   // “+1”这里巧妙处理了奇偶分别讨论，奇数情况（totalLen = 7）：(7 + 1) / 2 = 4→ 左半部分长度为4（包含中位数）偶数情况（totalLen = 8）：(8 + 1) / 2 = 4→ 左半部分长度为4（包含中位数的左半部分）

        while (left <= right) {
            int i = left + (right - left) / 2;  // nums1的分割点
            int j = halfLen - i;                // nums2的分割点
            
            /*
            a.先明确分割点的物理意义
            
                在二分查找过程中，我们需要：

                1.在 nums1中选一个位置 i，将 nums1分成左右两部分：

                 左半部分 ：nums1[0..i-1]（共 i个元素）
                 右半部分 ：nums1[i..m-1]（共 m-i个元素）

                2.在 nums2中选一个位置 j，将 nums2分成左右两部分：

                 左半部分 ：nums2[0..j-1]（共 j个元素）
                 右半部分 ：nums2[j..n-1]（共 n-j个元素）

             b. 四个变量的定义
                变量名  含义
                nums1Left  nums1左半部分的最后一个元素 （即左半部分的最大值）

                nums1Right nums1右半部分的第一个元素 （即右半部分的最小值）

                nums2Left nums2左半部分的最后一个元素 （即左半部分的最大值）

                nums2Right nums2右半部分的第一个元素 （即右半部分的最小值）

           c.为什么需要这些变量？ 为了确保合并后的数组满足以下条件：

            1.左半部分的所有元素 ≤ 右半部分的所有元素 （中位数的核心性质）

            2.具体需要验证：

            nums1Left（nums1左半的最大值） ≤ nums2Right（nums2右半的最小值）
            nums2Left（nums2左半的最大值） ≤ nums1Right（nums1右半的最小值）
            
             */
            // 处理边界情况
            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1]; // I==0 代表短数组全部很大，最左的也大于中线
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i]; // I==m 代表短数组全部很小，最右的也小于中线
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) { // 1. 左半部分所有元素 ≤ 右半部分所有元素，切割得刚刚好
                // 找到正确的分割点
                if ((m + n) % 2 == 0) { //是偶数
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                } else { // 奇数
                    return Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) { // 2.短数组nums1的左半部分太大，需要向左移动分割点 （right 左移，下次更好的取左边的 mid）
                right = i - 1;
            } else {     // 3.短数组nums1的右半部分太小，需要向右移动分割点
                left = i + 1;
            }
        }

        return 0.0;
    }
}
