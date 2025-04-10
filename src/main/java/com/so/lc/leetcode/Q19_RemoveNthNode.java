package com.so.lc.leetcode;

import com.so.common.ListNode;

/**
 *19. 删除链表的倒数第 N 个结点
 * @description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-09 23:47
 * @tag 链表, 双指针
 * @link <a href=""></a>
 **/
public class Q19_RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建虚拟头节点，方便处理删除头节点的情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 定义快慢指针
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 快指针先移动 n+1 步 因为加了占位空头
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // 快慢指针同时移动，直到快指针到达链表末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除倒数第 n 个节点
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        // 示例用例
        Q19_RemoveNthNode solution = new Q19_RemoveNthNode();

        // 构造链表 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2; // 删除倒数第 2 个节点
        ListNode result = solution.removeNthFromEnd(head, n);

        // 打印结果
        ListNode current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
