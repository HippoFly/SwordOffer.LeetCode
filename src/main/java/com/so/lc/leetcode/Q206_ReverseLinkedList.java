package com.so.lc.leetcode;

import com.so.common.ListNode;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 18:43
 **/

public class Q206_ReverseLinkedList {
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

            // 整体指针后挪
            prev=curr;
            curr = next;
        }
        return prev;
    }
}
