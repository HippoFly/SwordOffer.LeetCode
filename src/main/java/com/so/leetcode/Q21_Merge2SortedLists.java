package com.so.leetcode;

import com.so.common.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-09 17:41
 * @tag 链表，指针
 * @link <a href=""></a>
 **/
public class Q21_Merge2SortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建一个虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 遍历两个链表，直到其中一个为空
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 将剩余的部分连接到新的链表
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // 返回合并后的链表的头节点
        return dummy.next;
    }
}
