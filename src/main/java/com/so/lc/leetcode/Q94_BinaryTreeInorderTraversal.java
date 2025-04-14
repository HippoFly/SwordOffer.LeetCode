package com.so.lc.leetcode;

import com.so.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-14 16:03
 * @tag
 * @link <a href=""></a>
 **/

public class Q94_BinaryTreeInorderTraversal {

    /**
     * 使用中序遍历方式返回二叉树中的节点值列表
     * 中序遍历首先访问左子树，然后访问根节点，最后访问右子树
     *
     * @param root 二叉树的根节点
     * @return 返回中序遍历结果的整数列表
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 初始化结果列表
        List<Integer> result = new ArrayList<>();
        // 调用辅助方法执行中序遍历
        inorderHelper(root, result);
        // 返回遍历结果
        return result;
    }

    /**
     * 中序遍历二叉树的辅助方法
     * 中序遍历的顺序是：左子树 -> 根节点 -> 右子树
     * 此方法通过递归调用实现对二叉树的中序遍历，并将遍历结果存储在列表中
     *
     * @param node 当前遍历到的树节点
     * @param result 存储中序遍历结果的列表
     */
    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        // 中序遍历：左子树 -> 根节点 -> 右子树
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }
}
