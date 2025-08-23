package com.so.leetcode;

import com.so.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-15 15:42
 * @tag
 * @link <a href=""></a>
 **/
public class Q145_PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode root, List<Integer> result) {
        if (root == null){
            return;
        }
        postorderHelper(root.left, result);
        postorderHelper(root.right, result);
        result.add(root.val);
    }
}
