package com.so.lc.leetcode;

import com.so.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * <p>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 18:47
 * @tag 链表，快慢指针
 **/

public class Q234_PalindromeLinkedList {


    /**
     * 遍历+双指针
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        // 创建一个列表来存储链表的节点值
        List<Integer> integerList = new ArrayList<>();

        // 遍历链表，将节点值存入列表
        while (head != null) {
            integerList.add(head.val);
            head = head.next;
        }

        // 使用双指针从列表的两端向中间比较
        int left = 0;
        int right = integerList.size() - 1;
        while (left < right) {
            if (!integerList.get(left).equals(integerList.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        // 如果所有对应位置的元素都相等，则返回 true
        return true;
    }
}
