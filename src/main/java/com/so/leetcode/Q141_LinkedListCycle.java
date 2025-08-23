package com.so.leetcode;

import com.so.common.ListNode;

/**
 * 141. 环形链表
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-09 14:51
 * @tag 快慢指针,链表
 * @link <a href=""></a>
 **/
public class Q141_LinkedListCycle {
    /**
     * 检查链表中是否存在环
     * 使用快慢指针策略，慢指针每次移动一步，快指针每次移动两步
     * 如果链表中存在环，快慢指针最终会相遇；如果链表中没有环，快指针会先到达链表尾部
     *
     * @param head 链表的头节点
     * @return 如果链表中存在环，则返回true；否则返回false
     */
    public static boolean hasCycle(ListNode head) {
        // 判断链表是否为空或只有一个节点，这些情况下链表不可能有环
        if (head == null || head.next == null) {
            return false;
        }

        // 初始化慢指针slow和快指针fast
        ListNode slow = head;
        ListNode fast = head.next;

        // 当快慢指针未相遇时，继续遍历链表
        while (slow != fast) {
            // 如果快指针到达链表尾部，说明链表没有环
            if (fast == null || fast.next == null) {
                return false;
            }
            // 慢指针向前移动一步
            slow = slow.next;
            // 快指针向前移动两步
            fast = fast.next.next;
        }

        // 如果快慢指针相遇，说明链表中存在环
        return true;
    }

    public static void main(String[] args) {
        try {
            // 示例输入：构建链表并检测是否存在环
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = head; // 构建环

            boolean hasCycle = hasCycle(head);
            System.out.println("是否存在环: " + hasCycle);
        } catch (Exception e) {
            // 捕获并处理异常
            System.err.println("程序运行时发生错误: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
