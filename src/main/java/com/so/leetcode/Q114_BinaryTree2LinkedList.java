package com.so.leetcode;

import com.so.common.TreeNode;

import java.util.*;

/**
 * 114. 二叉树展开为链表
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 给定一棵二叉树，把它原地修改成一种“链表形态”：
 *
 * 修改后，每个节点的 right 指针指向下一个节点；
 *
 * 每个节点的 left 指针必须设为 null；
 *
 * 这个链表的顺序要和 二叉树的先序遍历顺序（根 → 左 → 右） 完全一致。
 *
 * 📌 举例
 *
 * 输入树：
 *
 *     1
 *    / \
 *   2   5
 *  / \    \
 * 3   4    6
 *
 *
 * 先序遍历的顺序是：1 → 2 → 3 → 4 → 5 → 6
 *
 * 所以修改后，树要变成：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
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
        if (root == null) return;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        // previousNode 指向“已经拍扁的链表”的最后一个节点
        TreeNode previousNode = null;

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();

            // ① 把当前节点接到链表尾部（由 previousNode 指向）
            if (previousNode != null) {
                previousNode.left = null;        // 题意要求 left 置空
                previousNode.right = currentNode; // 串到右边，形成“向右的链表”
            }

            // ② 注意压栈顺序：先压右，再压左（这样弹出时先访问左）
            if (currentNode.right != null) stack.push(currentNode.right);
            if (currentNode.left  != null) stack.push(currentNode.left);

            // ③ 更新链表尾巴
            previousNode = currentNode;
        }
    }
    /**
     * 以输入：
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     *
     *
     * 先序顺序应为： 1 → 2 → 3 → 4 → 5 → 6
     *
     * 栈与链接演化（只写关键）：
     *
     * 初始：stack=[1]，previous=null
     *
     * 弹 1：接到 previous（无操作），                  压入 1.right(5) 再 1.left(2) ⇒ stack=[5,2]；previous=1
     *
     * 弹 2：previous(1).right=2，previous.left=null；压 2.right(4) 再 2.left(3) ⇒ stack=[5,4,3]；previous=2
     *
     * 弹 3：previous(2).right=3，previous.left=null；压 stack=[5,4]；previous=3
     *
     * 弹 4：previous(3).right=4，previous.left=null；   压 stack=[5]；previous=4
     *
     * 弹 5：previous(4).right=5，previous.left=null；   压 5.right(6) ⇒ stack=[6]；previous=5
     *
     * 弹 6：previous(5).right=6，previous.left=null；   压stack=[]；previous=6
     * 结束。
     * 得到链：1→2→3→4→5→6，且所有 left=null。
     */
}
