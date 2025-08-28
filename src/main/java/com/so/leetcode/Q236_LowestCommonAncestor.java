package com.so.leetcode;

import com.so.common.TreeNode;

/**
 * 236. 二叉树的最近公共祖先 （所有的节点值不同）
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-16 17:01
 * @tag
 * @link <a href=""></a>
 **/
public class Q236_LowestCommonAncestor {
    /**
     * 找到二叉树中两个节点的最近公共祖先
     * 利用了二叉树遍历的特点
     * 1，如果当前节点为空或等于 p 或 q，则返回。
     * 2，定义遍历返回的 left 和 right，分别表示在左子树和右子树中查找 p 和 q 的结果。
     * 3，对所有结果分条件返回
     *
     * @param root 树的根节点
     * @param p    节点 p
     * @param q    节点 q
     * @return 最近公共祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空或等于 p 或 q，则返回。
        //root == null：表示当前节点为空，即递归已经到达了树的叶子节点的子节点（空节点），在这种情况下返回 null。
        //root == p：表示当前节点正好是目标节点 p，此时直接返回 p，因为如果在某个子树中找到了 p 或 q，那么这个子树的最近公共祖先就可能是 p 或 q 本身。
        //root == q：与 root == p 类似，表示当前节点正好是目标节点 q，此时直接返回 q。
        if (root == null || root == p || root == q) {
            return root;
        }

        // 递归查找左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归查找右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左子树返回非空，右子树也返回非空 → 说明 p、q 分别在左右子树，那当前 root 就是最近公共祖先。
        if (left != null && right != null) {
            return root;
        }

        // 如果左子树找到了节点，返回左子树找到的节点
        if (left != null) return left;
        // 如果右子树找到了节点，返回右子树找到的节点
        if (right != null) return right;

        return null;
    }

    public static void main(String[] args) {
        Q236_LowestCommonAncestor solution = new Q236_LowestCommonAncestor();

        // 构造二叉树 [3,5,1,6,2,0,8,null,null,7,4]
        //            3
        //           / \
        //          5   1
        //         / \ / \
        //        6  2 0  8
        //          / \
        //         7   4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left.left; // 节点 6
        TreeNode q = root.left.right; // 节点 2

        // 输出最近公共祖先
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        if (lca != null) {
            System.out.println("最近公共祖先的值: " + lca.val); // 输出 5
        } else {
            System.out.println("未找到最近公共祖先");
        }
    }
}
