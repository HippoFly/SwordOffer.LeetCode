package com.so.lc.leetcode;

import com.so.common.ListNode;
import com.so.sword.unfinished.Common;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 18:21
 **/

public class Q160_IntersectionTwoLinkedLists {
    /**
     * 两链表先走到尽头吗，再拼接，走对方的起点，第二轮无论如何最后肯定会相遇
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        //生成两指针
        ListNode pA = headA, pB = headB;
        //进入一个循环，只有当 pA 和 pB 指向同一个节点时才退出循环，即找到了交点或者遍历到链表末尾（没有交点）。
        while (pA != pB) {
            // a指针不为空，取下一个节点，直到为null，又连接B的头节点
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
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
