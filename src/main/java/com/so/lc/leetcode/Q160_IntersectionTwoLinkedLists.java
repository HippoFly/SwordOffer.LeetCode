package com.so.lc.leetcode;

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
     * 解决这个问题的关键是找到两个链表长度的差值，然后让较长的链表先走几步，直到两个链表剩下的长度一样
     * 这样就可以同时遍历两个链表，找到交点
     * 如果没有交点，两个指针最终都会变成null，循环结束，返回null
     *
     * @param headA 第一个链表的头节点
     * @param headB 第二个链表的头节点
     * @return 返回两个链表的交点节点，如果没有交点，则返回null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 检查输入的链表头节点是否为空
        if (headA == null || headB == null) return null;

        // 生成两个指针，分别指向两个链表的头节点
        ListNode pA = headA, pB = headB;

        // 进入一个循环，只有当 pA 和 pB 指向同一个节点时才退出循环，即找到了交点或者遍历到链表末尾（没有交点）。
        // 这里有一个默认条件：每一个链表最后都是null，那么即使俩链表没有交点，最后第二轮会同时到null
        while (pA != pB) {
            // 如果 pA 到达链表末尾，则将其重定位到 headB
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }

            // 如果 pB 到达链表末尾，则将其重定位到 headA
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }

        // 如果找到了交点，pA和pB会指向同一个节点；如果没有交点，pA和pB最终都会变成null
        // 返回pA或pB都可以，因为它们指向的是同一个节点
        return pA;
    }

    public static void main(String[] args) {
        // Create nodes for listA
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        // Connect nodes for listA
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Create nodes for listB
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(1);

        // Connect nodes for listB
        node6.next = node7;
        node7.next = node8;
        node8.next = node3; // Connect to intersecting node in listA

        // Test intersection
        ListNode headA = node1;
        ListNode headB = node6;


        Q160_IntersectionTwoLinkedLists twoLinkedLists = new Q160_IntersectionTwoLinkedLists();
        ListNode intersectionNode = twoLinkedLists.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);

        // Print the result
        if (intersectionNode != null) {
            System.out.println("Intersection node value: " + intersectionNode.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
