package com.so.lc.leetcode;

import com.so.common.ListNode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-12 15:48
 * @tag 链表、归并排序、递归，排序
 * @link <a href=""></a>
 **/
// TODO 归并排序
public class Q148_SortList {

    /**
     * 归并排序（最热门）
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // 递归终止条件：空链表或单个节点链表
        }

        // 找到链表的中间节点
        ListNode mid = getMiddle(head);

        // 断开链表，形成两个独立的子链表
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        // 递归排序两个子链表
        ListNode sortedLeft = sortList(left);
        ListNode sortedRight = sortList(right);

        // 合并两个有序链表
        return merge(sortedLeft, sortedRight);
    }

    /**
     * 辅助方法：找到链表的中间节点
     */
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // 返回中间节点
    }

    /**
     * 辅助方法：合并两个有序链表
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 将剩余的节点连接到结果链表
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next; // 返回合并后的链表头节点
    }

    public static void main(String[] args) {
        Q148_SortList solution = new Q148_SortList();

        // 创建链表 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        // 打印原始链表
        System.out.println("Original List: " + ListNode.toString(head));

        // 调用 sortList 方法排序链表
        ListNode sortedHead = solution.sortList(head);

        // 打印排序后的链表
        System.out.println("Sorted List: " + ListNode.toString(sortedHead));
    }

}
