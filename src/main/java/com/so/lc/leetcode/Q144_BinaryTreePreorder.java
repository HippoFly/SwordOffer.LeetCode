package com.so.lc.leetcode;

import com.so.common.TreeNode;

import java.util.ArrayList;
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
}
