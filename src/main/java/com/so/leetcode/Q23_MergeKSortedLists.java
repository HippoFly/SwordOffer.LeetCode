package com.so.leetcode;

import com.so.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并 K 个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-12 15:55
 * @tag 链表，优先队列
 * @link <a href=""></a>
 **/
public class Q23_MergeKSortedLists {


    /**
     * 优先队列法：先把数组每一个头节点加入优先队列，
     * 然后开始大循环：每次从优先队列中取出最小的节点，并更新当前节点的next指针，然后如果节点的next不为空，则将节点加入优先队列，循环结束后，
     * 直到优先队列为空。
     * 整个过程类似剥离葵花籽，先剥外层，再把内加入队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null; // 如果输入为空或长度为0，直接返回null
        }

        // 初始化优先队列，按照节点的值进行排序（小堆顶）
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        // 将每个链表的头节点加入优先队列
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // 创建虚拟头节点，用于简化结果链表的构建
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 合并链表
        while (!minHeap.isEmpty()) {
            // 从优先队列中取出最小的节点
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;

            // 如果取出的节点有下一个节点，则将下一个节点加入优先队列
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return dummy.next; // 返回合并后的链表头节点
    }

    public static void main(String[] args) {
        // 创建链表节点
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        // 将链表放入数组
        ListNode[] lists = new ListNode[]{list1, list2, list3};

        // 创建 Q23_MergeKSortedLists 类的实例
        Q23_MergeKSortedLists solution = new Q23_MergeKSortedLists();

        // 合并链表
        ListNode mergedList = solution.mergeKLists(lists);

        // 打印合并后的链表
        printList(mergedList);
    }

    // 辅助方法：打印链表
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
