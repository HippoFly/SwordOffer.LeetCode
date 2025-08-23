package com.so.leetcode;

import com.so.common.ListNode;

/**
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 18:21
 * @tag 链表
 **/

public class Q160_IntersectionTwoLinkedLists {

    /**
     * 解决这个问题的关键是拼接
     * 相交，一起走到交点
     * 不相交，一起走到末尾null
     *
     * @param headA 第一个链表的头节点
     * @param headB 第二个链表的头节点
     * @return 返回两个链表的交点节点，如果没有交点，则返回null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 边界判断
        if (headA == null || headB == null) return null;

        // 生成两个指针，分别指向两个链表的头节点
        ListNode pA = headA, pB = headB;

        // 结束循环： 相交 -> 拼接后走到相交点  不相交 -> 拼接后走到末尾null 一起结束
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }

            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }

        return pA;
    }

    public static void main(String[] args) {



        Q160_IntersectionTwoLinkedLists twoLinkedLists = new Q160_IntersectionTwoLinkedLists();


        // Create non-intersecting lists: 1->2->3 and 4->5->6
        ListNode node10 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);

        ListNode node13 = new ListNode(4);
        ListNode node14 = new ListNode(5);
        ListNode node15 = new ListNode(6);
        ListNode node16 = new ListNode(7);

        node10.next = node11;
        node11.next = node12;

        node13.next = node14;
        node14.next = node15;
        node15.next = node16;

        // Test non-intersection
        ListNode headC = node10;
        ListNode headD = node13;

        ListNode nonIntersectionNode = twoLinkedLists.getIntersectionNode(headC, headD);
        System.out.println(nonIntersectionNode);

        if (nonIntersectionNode != null) {
            System.out.println("Intersection node value: " + nonIntersectionNode.val);
        } else {
            System.out.println("No intersection found for non-intersecting lists.");
        }
    }
}
