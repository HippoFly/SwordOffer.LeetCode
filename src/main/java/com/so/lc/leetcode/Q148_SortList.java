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
     * 思路
     *
     * 找中点：快慢指针，slow 到中点，fast 到尾。
     *
     * 断开：把链表分成左右两半。
     *
     * 递归：对左右两半分别排序。
     *
     * 合并：合并两个有序链表。
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Step1: 找到中点
        ListNode mid = head, fast = head, midPrev = null;
        while (fast != null && fast.next != null) {
            midPrev = mid;
            mid = mid.next;
            fast = fast.next.next;
        }
        midPrev.next = null; // 断开链表

        // Step2: 递归排序左右
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);

        // Step3: 合并
        return merge(l1, l2);
    }



    /**
     * 辅助方法：合并两个有序链表
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        // dummy 是虚拟头结点，方便返回结果
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 遍历两个链表，只要都有节点，就比较大小
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                // 如果 l1 当前值更小，把 l1 接到结果链表后面
                current.next = l1;
                l1 = l1.next; // l1 往前走一步
            } else {
                // 否则 l2 当前值更小，把 l2 接到结果链表后面
                current.next = l2;
                l2 = l2.next; // l2 往前走一步
            }
            current = current.next; // 结果链表的尾指针往前走一步
        }

        // 如果有链表还没走完，直接接到结果链表尾部
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        // dummy.next 就是合并后的有序链表头结点
        return dummy.next;
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
