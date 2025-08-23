package com.so.leetcode;

import com.so.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-16 11:09
 * @tag 二叉树，BFS
 * @link <a href=""></a>
 **/
public class Q199_BinaryTreeRightSideView {
    /**
     * 获取二叉树的右视图
     * BFS每一层的最后一个节点即为右视图的节点
     *
     * @param root 树的根节点
     * @return 右视图的节点值列表
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 层次遍历
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // 如果是当前层的最后一个节点，则加入结果
                if (i == levelSize - 1) {
                    result.add(node.val);
                }

                // 将左右子节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }
}
