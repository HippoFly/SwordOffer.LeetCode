package com.so.leetcode;

import com.so.common.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-15 12:09
 * @tag 二叉树，BFS
 * @link <a href=""></a>
 **/
public class Q102_BinaryTreeLevelOrderTraversal {

    /**
     * BFS
     * 核心是利用队列
     * 1，创建一个队列，将根节点入队。并初始化一个空的结果列表。
     * 2，开始while循环：队列不为空，创建一个层次list，for循环：取出队列一个节点加入层次list，并判断左右子节点是否为空，不为空则入队。
     *   for结束，把层次list加入结果列表。
     * 3，while循环结束后，返回结果列表。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 结果列表
        List<List<Integer>> result = new ArrayList<>();

        // 如果根节点为空，直接返回空结果
        if (root == null) {
            return result;
        }

        // 使用队列：记住队列符合FIFO原则，即offer()队尾  poll()队首
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 根节点入队

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 当前层的节点数
            List<Integer> currentLevel = new ArrayList<>(); // 存储当前层的节点值

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // 取出队首节点
                currentLevel.add(node.val); // 添加节点值到当前层列表

                // 将左右子节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(currentLevel); // 将当前层的结果添加到最终结果
        }

        return result;
    }
    public static void main(String[] args) {
        // 创建一个包含节点 1 到 7 的二叉树
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        Q102_BinaryTreeLevelOrderTraversal solution = new Q102_BinaryTreeLevelOrderTraversal();

        System.out.println("Original Tree:");
        printTree(root);

        List<List<Integer>> lists = solution.levelOrder(root);

        System.out.println("\nTree: "+ lists);
    }

    /**
     * 打印二叉树（前序遍历）
     *
     * @param root 二叉树的根节点
     */
    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

}
