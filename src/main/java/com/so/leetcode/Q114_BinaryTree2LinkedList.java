package com.so.leetcode;

import com.so.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 114. 二叉树展开为链表
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-16 11:17
 * @tag
 * @link <a href=""></a>
 **/
public class Q114_BinaryTree2LinkedList {
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        helper(root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void helper(TreeNode root) {
        if (root==null){return;}

        list.add(root);
        helper(root.left);
        helper(root.right);
    }
}
