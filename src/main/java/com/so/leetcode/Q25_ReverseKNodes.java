package com.so.leetcode;

import com.so.common.ListNode;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-12 10:20
 * @tag
 * @link <a href=""></a>
 **/
public class Q25_ReverseKNodes {
    /**
     * 第一步，递归终止判断（这里是不够K个返回《本来的head》）
     * 第二步，反转当前 k 个节点，反转后的头节点成为《新的头节点Head'》
     * 第三步，《本来的head》已然成为尾节点，指向递归后的头节点
     * 第四步，返回《新的头节点Head'》
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        //
        ListNode next = head;
        // 判断当前是否有 k 个节点
        for (int i = 0; i < k; i++) {
            if (next == null) {
                return head; // 不足 k 个节点，直接返回原链表
            }
            next = next.next;
        }
        //经过for后next指向当前的k个节点的最后节点

        // 翻转当前 k 个节点
        ListNode newHead = reverseList(head, next);

        // 递归处理后续链表
        head.next = reverseKGroup(next, k);


        return newHead;
    }


    /**
     * 辅助方法：翻转从 start 到 end 的链表（不包括 end）
     */
    public ListNode reverseList(ListNode start, ListNode end) {
        // 定义三个指针，分别指向前一个节点、当前节点和下一个节点
        ListNode prev = null, curr = start, next = null;

        // 循环：当当前指针指向end时，对end反转已经完成，这是while的特性
        while (curr != end) {
            // 先指针记录下一节点，防止断连
            next = curr.next;
            // 当前节点指向前一节点
            curr.next = prev;

            // 以下是为下一轮的节点做准备：前指针指向当前节点，当前指针指向下一个节点
            prev = curr;
            curr = next;
        }
        return prev; // 返回新的头节点：这里end 只会参与判断，不会被返回，从 end 本身以及之后依然保持顺序
    }

    public static void main(String[] args) {
        Q25_ReverseKNodes solution = new Q25_ReverseKNodes();

        // 创建链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 打印原始链表
        System.out.println("Original List: " + ListNode.toString(head));

        // 调用 reverseKGroup 方法反转链表，每 2 个一组
        int k = 2;
        ListNode reversedHead = solution.reverseKGroup(head, k);

        // 打印反转后的链表
        System.out.println("Reversed List: " + ListNode.toString(reversedHead));
    }
}
