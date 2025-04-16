package com.so.lc.leetcode;

import com.so.common.TreeNode;

/**
 * 437. 路径总和 III
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-16 11:30
 * @tag
 * @link <a href=""></a>
 **/
public class Q437_PathSumIII {

    private int count = 0;

    /**
     * 双重递归解法的详细解释
     * 主函数 pathSum：
     * 遍历树中的每个节点，将每个节点作为起点调用辅助函数 countPaths。
     * 对每个节点，调用 countPaths 计算从该节点出发的所有路径和等于 targetSum 的路径数目。
     * 递归调用 pathSum(root.left, targetSum) 和 pathSum(root.right, targetSum)。
     * 辅助函数 countPaths：
     * 从当前节点出发，递归计算路径和等于 targetSum 的路径数目。
     * 更新 targetSum 为 targetSum - node.val。
     * 如果 targetSum 等于 0，则计数加一。
     * 递归调用 countPaths(node.left, targetSum) 和 countPaths(node.right, targetSum)。
     *
     *
     * @param root 树的根节点
     * @param targetSum 目标路径和
     * @return 满足条件的路径数目
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        // 从根节点开始计算路径和
        countPaths(root, targetSum);

        // 对左右子树递归计算路径和
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;
    }

    /**
     * 从当前节点出发，计算路径和等于给定值的路径数目
     *
     * @param node 当前节点
     * @param targetSum 目标路径和
     */
    private void countPaths(TreeNode node, int targetSum) {
        if (node == null) {
            return;
        }

        // 减去当前节点的值
        targetSum -= node.val;

        // 如果路径和等于目标值，则计数加一
        if (targetSum == 0) {
            count++;
        }

        // 递归遍历左子树和右子树
        countPaths(node.left, targetSum);
        countPaths(node.right, targetSum);
    }

    public static void main(String[] args) {
        Q437_PathSumIII solution = new Q437_PathSumIII();

        // 构造二叉树 [10,5,-3,3,2,null,11,3,-2,null,1]
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        // 输出路径和等于 8 的路径数目
        System.out.println(solution.pathSum(root, 8)); // 输出 3
    }
}
