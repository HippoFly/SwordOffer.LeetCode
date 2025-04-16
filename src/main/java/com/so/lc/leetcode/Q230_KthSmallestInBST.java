package com.so.lc.leetcode;

import com.so.common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 230. 二叉搜索树中第 K 小的元素
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-16 10:07
 * @tag 二叉树，BST
 * @link <a href=""></a>
 **/
public class Q230_KthSmallestInBST {
    // 记录当前访问的节点个数
    private int count = 0;
    // 记录第 K 小的元素
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return result;
    }

    /**
     * 中序遍历二叉搜索树
     *
     * 这里利用了BST的数值升序特性
     * 结合把计数放在左遍历后，右遍历前，则count的增长可以从1开始，到k
     * 当计数等于 K 时，返回当前节点的值
     *
     * @param root 当前节点
     * @param k 第 K 小的元素
     */
    private void inorderTraversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        // 递归遍历左子树
        inorderTraversal(root.left, k);

        // 这里注意进行左遍历完毕后才会运行到这一步，count开始加，访问当前节点，计数+1
        count++;
        if (count == k) {
            result = root.val;
            return;
        }

        // 递归遍历右子树
        inorderTraversal(root.right, k);
    }

    @Test
    public void testKthSmallest() {
        Q230_KthSmallestInBST solution = new Q230_KthSmallestInBST();
        /*// 测试用例 1

        *//*
              3
             / \
            1   4
             \
              2
         *//*
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);

        assertEquals(1, solution.kthSmallest(root1, 1));
        assertEquals(2, solution.kthSmallest(root1, 2));
        assertEquals(3, solution.kthSmallest(root1, 3));
        assertEquals(4, solution.kthSmallest(root1, 4));*/

        // 测试用例 2
        /*
              5
             / \
            3   6
           / \
          2   4
         /
        1
         */
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);

        assertEquals(1, solution.kthSmallest(root2, 1));
        assertEquals(2, solution.kthSmallest(root2, 2));
        assertEquals(3, solution.kthSmallest(root2, 3));
        assertEquals(4, solution.kthSmallest(root2, 4));
        assertEquals(5, solution.kthSmallest(root2, 5));
        assertEquals(6, solution.kthSmallest(root2, 6));

       /* // 测试用例 3
        *//*
              1
             / \
            0   2
         *//*
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(0);
        root3.right = new TreeNode(2);

        assertEquals(0, solution.kthSmallest(root3, 1));
        assertEquals(1, solution.kthSmallest(root3, 2));
        assertEquals(2, solution.kthSmallest(root3, 3));*/
    }
}
