package com.so.lc.leetcode;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 15:14
 **/

public class Q24_SwapNodesInPairs {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 定义一个方法 swapPairs，用于将给定链表中的每相邻两个节点进行交换。
     *
     * @param head 链表的头节点
     * @return 交换后的链表头节点
     */
    public ListNode swapPairs(ListNode head) {
        // 如果链表为空，或者只有一个节点，无需交换，直接返回原链表头节点
        if (head == null || head.next == null) {
            return head;
        }

        // 'next' 指向当前节点的下一个节点，即即将成为新头部的节点
        ListNode next = head.next;

        // 递归地对 'next.next' 开始的后续链表进行相同的操作
        // 此步骤会返回交换后的新链表头，该头节点将成为当前 'next' 节点的新后继
        head.next = swapPairs(next.next);

        // 完成交换：原链表的头节点 'head' 变为当前 'next' 节点的后继节点，
        // 而 'next' 节点则成为新链表的头节点
        next.next = head;

        // 返回交换后链表的新头部
        return next;
    }
}
