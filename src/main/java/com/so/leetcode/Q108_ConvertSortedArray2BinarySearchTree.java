package com.so.leetcode;

import com.so.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-16 09:33
 * @tag
 * @link <a href=""></a>
 **/
public class Q108_ConvertSortedArray2BinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    /**
     * 递归辅助函数，用于构建二叉搜索树
     *
     * @param nums 有序数组
     * @param left 数组的起始索引
     * @param right 数组的结束索引
     * @return 返回构建的二叉搜索树的根节点
     */
    private TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        // 递归终止条件：起始索引大于结束索引，说明已经没有节点来构建树
        if (left > right) {
            return null;
        }

        // 选择中间元素作为根节点
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // 递归构建左子树和右子树
        root.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, right);

        // 返回构建的二叉搜索树的根节点
        return root;
    }

    @Test
    public void testSortedArrayToBST() {
        // 测试用例
        int[] nums = {-10, -3, 0, 5, 9};

        Q108_ConvertSortedArray2BinarySearchTree solution = new Q108_ConvertSortedArray2BinarySearchTree();
        TreeNode root = solution.sortedArrayToBST(nums);

        // 验证构建的二叉搜索树是否正确
        // 通过前序遍历来验证
        List<Integer> result = new ArrayList<>();
        System.out.println(root);
    }
}
