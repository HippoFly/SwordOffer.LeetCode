package com.so.leetcode;

import com.so.common.TreeNode;
import org.junit.Test;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-15 15:11
 * @tag
 * @link <a href=""></a>
 **/
public class Q106_ConstructBinaryTreeFromInorderPostorder {
    // 记录后序遍历的当前索引，从末尾开始
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 初始化postIndex为后序遍历的最后一个元素索引
        postIndex = postorder.length - 1;
        // 中序遍历的起始索引和结束索引第一次是整个数组
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1);
    }

    /**
     * 递归辅助函数，用于构建二叉树
     * 该函数使用中序遍历和后序遍历的结果来重构二叉树
     *
     * @param inorder   中序遍历数组
     * @param postorder 后序遍历数组
     * @param inStart   中序遍历的起始索引
     * @param inEnd     中序遍历的结束索引
     * @return 返回构建的二叉树的根节点
     */
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd) {
        // 递归终止条件：中序遍历的起始索引大于结束索引，说明已经没有节点来构建树
        if (inStart > inEnd) {
            return null;
        }

        // 后序遍历在postIndex的节点为根节点，取出val构造根节点
        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历中找到根节点的位置
        int inIndex = findIndex(inorder, inStart, inEnd, rootVal);

        // 移动到下一个后序遍历的节点 => 下一个头节点
        postIndex--;

        // 递归构建右子树和左子树
        // 注意：必须先构建右子树，因为后序遍历是左->右->根，所以倒序是根->右->左
        // 右子树基于父节点 更新inStart为跟节点在中序遍历的（位置+1）=> index+1
        root.right = buildTreeHelper(inorder, postorder, inIndex + 1, inEnd);
        // 左子树只基于父节点 更新inEnd为跟节点在中序遍历的（位置-1）=> index-1
        root.left = buildTreeHelper(inorder, postorder, inStart, inIndex - 1);

        // 返回构建的二叉树的根节点
        return root;
    }

    /**
     * 在中序遍历数组中查找指定值的索引
     *
     * @param inorder 中序遍历数组
     * @param start   查找的起始索引
     * @param end     查找的结束索引
     * @param value   需要查找的值
     * @return 找到的索引，如果未找到则返回 -1（理论上不会发生）
     */
    private int findIndex(int[] inorder, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        return -1; // 如果未找到，返回 -1（理论上不会发生）
    }

    @Test
    public void testBuildTree() {
        // 中序遍历和后序遍历序列
        /*
              1
             / \
            2   3
           / \ / \
          4  5 6  7
         */
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        Q106_ConstructBinaryTreeFromInorderPostorder solution = new Q106_ConstructBinaryTreeFromInorderPostorder();
        TreeNode root = solution.buildTree(inorder, postorder);

        // 验证构建的二叉树是否正确
        // 通过后序遍历来验证

        // 预期的后序遍历结果

        // 验证结果是否正确
    }
}