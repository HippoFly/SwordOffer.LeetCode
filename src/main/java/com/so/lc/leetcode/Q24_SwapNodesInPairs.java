package com.so.lc.leetcode;

import com.so.common.ListNode;

/**
 * 24. 两两交换链表中的节点
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 15:14
 * @tag 递归
 **/

public class Q24_SwapNodesInPairs {


    /**
     * 定义一个方法 swapPairs，用于将给定链表中的每相邻两个节点进行交换。
     * 递归
     * 1，判空，临界点
     * 2，记住当前Head的next
     * 3，（递归）Head的指针指向下一对节点的Next‘（也就是当前Next的Next）
     * 4，Next指向Head
     * 5，返回Next
     *
     * @param head 链表的头节点
     * @return 交换后的链表头节点
     */
    public ListNode swapPairs(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }

        // 记录第二个节点
        ListNode newHead = head.next;
        // 第一个节点指向后续递归处理结果
        head.next = swapPairs(newHead.next);
        // 第二个节点指向第一个节点
        newHead.next = head;

        return newHead;
    }


    public static void main(String[] args) {
        // 创建测试链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 打印原始链表
        System.out.println("原始链表:");
        printList(head);

        // 创建 Q24_SwapNodesInPairs 对象并调用 swapPairs 方法
        Q24_SwapNodesInPairs solution = new Q24_SwapNodesInPairs();
        ListNode newHead = solution.swapPairs(head);

        // 打印交换后的链表
        System.out.println("交换后的链表:");
        printList(newHead);
    }

    /**
     * 打印链表
     *
     * @param head 链表的头节点
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
