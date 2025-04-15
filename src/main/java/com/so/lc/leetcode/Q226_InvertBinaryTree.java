package com.so.lc.leetcode;

import com.so.common.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-14 17:08
 * @tag 二叉树，递归，二叉树反转
 * @link <a href=""></a>
 **/
public class Q226_InvertBinaryTree {
    /**
     * 翻转二叉树
     * 1，root为null，直接返回
     * 2，递归翻转左子树和右子树
     * 3，交换当前节点的左右子节点（当前的左右是递归反转返回的，
     *      如果当前已经是叶节点，2，会返回俩null
     *      如果是次级叶节点，那么递归会返回传递的左右节点，
     *      ）
     * 4，返回当前root节点
     *
     * @param root 二叉树的根节点
     * @return 返回翻转后的二叉树的根节点
     */
    public TreeNode invertTree(TreeNode root) {
        // 如果当前节点为空，直接返回
        if (root == null) {
            return null;
        }
        // 递归翻转左子树
        TreeNode left = invertTree(root.left);
        // 递归翻转右子树
        TreeNode right = invertTree(root.right);
        // 交换当前节点的左右子节点
        root.left = right;
        root.right = left;
        // 返回当前节点
        return root;
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

        Q226_InvertBinaryTree solution = new Q226_InvertBinaryTree();

        System.out.println("Original Tree:");
        printTree(root);

        TreeNode invertedRoot = solution.invertTree(root);

        System.out.println("\nInverted Tree:");
        printTree(invertedRoot);
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
