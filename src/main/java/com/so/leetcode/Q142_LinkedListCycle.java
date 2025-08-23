package com.so.leetcode;

import com.so.common.ListNode;

/**
 *
 * 142. 环形链表 II (这要给出环的入口位置)
 * <p>
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-09 14:57
 * @tag 链表，双指针，哈希表
 * @link <a href=""></a>
 **/
public class Q142_LinkedListCycle {
    public ListNode detectCycle(ListNode head) {
        // Step 1: 使用快慢指针检测是否有环
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // 慢指针每次移动一步
            fast = fast.next.next;    // 快指针每次移动两步

            // 这里之前我以为快慢指针追上一定是重合点，有错，其实是环内任意位置都可能
            //
            if (slow == fast) {       // 如果相遇，说明有环
                break;
            }
        }

        // 如果链表无环，直接返回 null
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2: 找到环的入口
        // 这里快指针依然在重合点，慢指针从头节点开始，再次相遇，两者相距
        slow = head;                  // 将慢指针重置为头节点
        while (slow != fast) {        // 两个指针以相同速度前进，直到再次相遇
            slow = slow.next;
            fast = fast.next;
        }

        return slow;                 // 返回相遇点，即环的入口
    }

    public static void main(String[] args) {
        // 创建链表: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3; // 形成环: 5 -> 3

        Q142_LinkedListCycle solution = new Q142_LinkedListCycle();
        ListNode cycleStart = solution.detectCycle(head);

        if (cycleStart != null) {
            System.out.println("环的入口节点值为: " + cycleStart.val);
        } else {
            System.out.println("链表中没有环");
        }
    }
}
