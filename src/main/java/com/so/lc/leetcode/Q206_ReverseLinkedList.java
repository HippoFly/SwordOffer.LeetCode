package com.so.lc.leetcode;

import com.so.common.ListNode;

/**
 * 206. 反转链表
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 18:43
 * @tag 链表
 **/

public class Q206_ReverseLinkedList {

    /**
     * 初始化三个指针：prev（前驱节点，初始为null）、curr（当前节点，初始为头节点）、next（下一节点，初始为null）。
     * 遍历链表，每次循环中：
     * 先保存当前节点的下一个节点到next，防止断链。
     * 将当前节点的next指向prev，实现局部反转。
     * 移动prev和curr指针到下一个位置。
     * 当遍历结束时，prev指向新的头节点，返回prev。
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 前
        ListNode prev = null;
        // 现在
        ListNode curr = head;
        // 后
        ListNode next = null;
        while (curr != null) {
            //先指针指向下一节点，记录下载，防止断连
            next = curr.next;

            // 指针反转前
            curr.next = prev;

            // 前指针指向当前解答
            prev = curr;
            // 当前指针指向下一个节点
            curr = next;
        }
        return prev;
    }
}
