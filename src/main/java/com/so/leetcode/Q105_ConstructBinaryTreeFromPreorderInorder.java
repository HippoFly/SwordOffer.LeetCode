package com.so.leetcode;

import com.so.common.TreeNode;
import org.junit.Test;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-15 15:11
 * @tag
 * @link <a href=""></a>
 **/
public class Q105_ConstructBinaryTreeFromPreorderInorder {
    // 记录先序遍历的当前索引
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 中序遍历的起始索引和结束索引第一次是整个数组
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
    }

    /**
     * 递归辅助函数，用于构建二叉树
     * 该函数使用先序遍历和中序遍历的结果来重构二叉树
     *
     * @param preorder 先序遍历数组
     * @param inorder 中序遍历数组
     * @param inStart 中序遍历的起始索引
     * @param inEnd 中序遍历的结束索引
     * @return 返回构建的二叉树的根节点
     */
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inStart, int inEnd) {
        // 递归终止条件：中序遍历的起始索引大于结束索引，说明已经没有节点来构建树
        if (inStart > inEnd) {
            return null;
        }

        // 先序遍历在preIndex的节点为根节点，取出val构造根节点
        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历中找到根节点的位置
        int inIndex = findIndex(inorder, inStart, inEnd, rootVal);

        // 移动到下一个先序遍历的节点 => 下一个头节点
        preIndex++;

        // 递归构建左子树和右子树
        // 左子树只基于父节点 更新inEnd为跟节点在中序遍历的（位置-1）=> index-1
        root.left = buildTreeHelper(preorder, inorder, inStart, inIndex - 1);
        // 右子树基于父节点 更新inStart为跟节点在中序遍历的（位置+1）=> index+1
        root.right = buildTreeHelper(preorder, inorder, inIndex + 1, inEnd);

        // 返回构建的二叉树的根节点
        return root;
    }

    /**
     * 在中序遍历数组中查找指定值的索引
     *
     * @param inorder 中序遍历数组
     * @param start    查找的起始索引
     * @param end      查找的结束索引
     * @param value    需要查找的值
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
        // 前序遍历和中序遍历序列
        /*
              1
             / \
            2   3
           / \ / \
          4  5 6  7
         */
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};

        Q105_ConstructBinaryTreeFromPreorderInorder solution = new Q105_ConstructBinaryTreeFromPreorderInorder();
        TreeNode root = solution.buildTree(preorder, inorder);

        // 验证构建的二叉树是否正确
        // 通过前序遍历来验证

        // 预期的前序遍历结果

        // 验证结果是否正确
    }


}
