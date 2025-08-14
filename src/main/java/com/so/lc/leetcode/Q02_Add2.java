package com.so.lc.leetcode;

import com.so.common.ListNode;

/**
 * 2. 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-09 23:20
 * @tag 链表
 * @link <a href=""></a>
 **/
public class Q02_Add2 {

    /**
     * 思路：
     * 1. 创建一个虚拟头节点，用于返回合并后的链表。
     * 2. 初始化当前节点为虚拟头节点，初始 carry 为 0。
     * 3. 循环：遍历两个链表，直到全为空。
     *      3.1. 对 左右 当前节点求和，分别取下一点
     *      3.2. 创建新节点并连接到 current，更新 current。
     *  4. 如果最后还有进位，添加一个新节点。
     * 7. 返回合并后的链表的头节点。**/
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        // 创建一个虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // 遍历两个链表，直到两个全为 null
        // 注意这里的条件，只要一个不为空，就继续循环，结合内部if判断就可以即使一个链表远远长于另一个也可以处理完毕
        while (list1 != null || list2 != null) {
            // 每次循环都要初始化 sum 并且加上一次的进位
            int sum = carry;

            if (list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }
            if (list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }

            // 计算当前位的值和新的 carry
            carry = sum / 10;
            sum = sum % 10;

            // 创建新节点并连接到 current
            current.next = new ListNode(sum);
            current = current.next;
        }

        // 如果最后还有进位，添加一个新节点
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // 返回合并后的链表的头节点
        return dummy.next;
    }

    // 测试用例
    public static void main(String[] args) {
        Q02_Add2 solution = new Q02_Add2();

        // 构造链表 1：7 -> 3 -> 9
        ListNode list1 = new ListNode(7);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(9);

        // 构造链表 2：8 -> 4 -> 2 -> 1 -> 6
        ListNode list2 = new ListNode(8);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(2);
        list2.next.next.next = new ListNode(1);
        list2.next.next.next.next = new ListNode(6);

        // 执行相加操作
        ListNode result = solution.addTwoNumbers(list1, list2);
        System.out.println(result);
    }
}

