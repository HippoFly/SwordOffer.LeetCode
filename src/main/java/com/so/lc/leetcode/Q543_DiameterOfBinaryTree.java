package com.so.lc.leetcode;

import com.so.common.TreeNode;

/**
 * 543. 二叉树的直径
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * <p>
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * <p>
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-15 09:21
 * @tag 二叉树，DFS
 * @link <a href=""></a>
 **/
public class Q543_DiameterOfBinaryTree {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    /**
     * 计算二叉树的高度
     * 此方法同时用于计算最大直径（任意两个节点路径的最大值）
     *
     * @param node 当前节点
     * @return 当前节点的高度
     */
    private int height(TreeNode node) {
        // 如果节点为空，返回高度为0
        if (node == null) {
            return 0;
        }

        // 递归计算左子树的高度
        int leftHeight = height(node.left);
        // 递归计算右子树的高度
        int rightHeight = height(node.right);

        // 更新最大直径，当前节点的左子树高度加右子树高度可能形成新的最大直径
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        /*
        * 在二叉树中，节点的高度是指从该节点到其最远叶子节点之间的边数。换句话说，节点的高度表示从当前节点出发，向下到达最深叶子节点需要经过的路径长度。
            特殊情况：
            叶子节点的高度：叶子节点没有子节点，因此其高度为 0 + 1 = 1。
            空节点的高度：如果节点为 null（即不存在），则其高度定义为 0。叶子节点的高度定义为 1 是为了保持递归逻辑的一致性，并正确反映树的高度定义。这种定义方式中的“虚拟边”并不是真正存在的边，而是为了方便计算和定义而引入的概念。如果将叶子节点的高度定义为 0，会导致整个树的高度计算出现偏差，进而影响二叉树直径等依赖高度计算的问题的正确性。
        * */
        // 返回当前节点的高度，取左右子树中较大的高度值加1
        // 举个例子比如是叶子节点，此时左右都是0，但是叶子节点的高度是1
        return Math.max(leftHeight, rightHeight) + 1;
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

        Q543_DiameterOfBinaryTree solution = new Q543_DiameterOfBinaryTree();

        System.out.println("Original Tree:");
        printTree(root);

        int invertedRoot = solution.diameterOfBinaryTree(root);

        System.out.println("\nTree: "+invertedRoot);
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
