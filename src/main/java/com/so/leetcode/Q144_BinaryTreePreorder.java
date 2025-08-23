package com.so.leetcode;

import com.so.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 144. 二叉树的前序遍历
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-15 15:29
 * @tag 二叉树
 * @link <a href=""></a>
 **/
public class Q144_BinaryTreePreorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        preorderHelper(root, integers);
        return integers;
    }

    private void preorderHelper(TreeNode root, ArrayList<Integer> integers) {
        if (root == null) {
            return;
        }
        integers.add(root.val);
        preorderHelper(root.left, integers);
        preorderHelper(root.right, integers);
    }

    public static void main(String[] args) {
        Q144_BinaryTreePreorder binaryTreePreorder = new Q144_BinaryTreePreorder();
    }
    @Test
    public void testPreorderTraversal() {
        // 构建测试用例的二叉树
        /**
         *       1
         *      / \
         *     2   3
         *    / \ / \
         *   4  5 6  7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Q144_BinaryTreePreorder solution = new Q144_BinaryTreePreorder();
        List<Integer> result = solution.preorderTraversal(root);

        // 预期的前序遍历结果
        List<Integer> expected = Arrays.asList(1, 2, 4, 5, 3, 6, 7);

        // 验证结果是否正确：[1, 2, 4, 5, 3, 6, 7]
        System.out.println(result);
    }
}
