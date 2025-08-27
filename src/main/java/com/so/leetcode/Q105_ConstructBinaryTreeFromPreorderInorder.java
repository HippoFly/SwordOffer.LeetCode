package com.so.leetcode;

import com.so.common.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-15 15:11
 * @tag
 * @link <a href=""></a>
 **/
public class Q105_ConstructBinaryTreeFromPreorderInorder {
    // 记录先序遍历的当前索引
    private int preIndex = 0;

    /**
     * 思路一句话
     *
     * 前序第一个一定是当前子树的根；在中序里找到这个根，把中序数组切成“左半（左子树）/右半（右子树）”；再用两边的元素个数去切前序数组，对左右子树递归构造。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    // 为了 O(1) 找到某个值在中序遍历中的位置：值 -> 该值在 inorder 中的索引
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
       // 1. 全加 map 找中序遍历索引
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        // 2.进入递归（ 前序数组，0，末尾索引
        // 中序数组，0，末尾索引
        // ）
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder,  int inStart,  int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        // 1. 前序首元素是根
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 2. 在中序中找到根位置
        int mid = inorderIndexMap.get(rootVal);
        int leftSize = mid - inStart; // 左子树大小

        // 3. 构造左子树 （
        // 前序数组，前序开始+1，前序开始+左子树大小，
        // 中序，中序开始，中序根索引-1
        // ）
        root.left = build(preorder,preStart + 1, preStart + leftSize,   // 前序左子树区间
                inorder, inStart, mid - 1);                  // 中序左子树区间

        // 4. 构造右子树（
        // 前序数组，前序开始+左子树大小+1，前序末尾索引，
        // 中序，中序根索引+1，中序末尾索引
        // ）
        root.right = build(preorder,preStart + leftSize + 1, preEnd,   // 前序右子树区间
                inorder,mid + 1, inEnd);                   // 中序右子树区间

        return root;
    }


    @Test
    public void testBuildTree() {
        // 前序遍历和中序遍历序列
        /*
              1
             / \
            2   3
           / \ / \
          4  5 6  7
         */
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};

        Q105_ConstructBinaryTreeFromPreorderInorder solution = new Q105_ConstructBinaryTreeFromPreorderInorder();
        TreeNode root = solution.buildTree(preorder, inorder);

        // 验证构建的二叉树是否正确
        // 通过前序遍历来验证

        // 预期的前序遍历结果

        // 验证结果是否正确
    }


}
