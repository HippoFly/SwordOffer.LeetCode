package com.so.lc.leetcode;

import com.so.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 18:47
 **/

public class Q234_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        //通过快慢指针找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
        // 对于奇数，中点不需要翻转
            slow = slow.next;
        }
        //反转后半部分链表
        slow = reverse(slow);

        // 这里fast跟快没关系，只是复用指针，从头开始，而slow从尾巴开始
        fast = head;
        while (slow != null) {
            //然后比较，判断节点值是否相等
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    //反转链表
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public boolean isPalindrome2(ListNode head) {
        List<Integer> integerList = new ArrayList<>();
        while (head != null) {
            integerList.add(head.val);
            head = head.next;
        }
        // 4/2=2  <[2]  [0][1][2][3]
        // 5/2=2|  <[2]   [0][1][2][3][4]
        boolean flag = true;
        for (int i = 0; i < integerList.size()/2; i++) {
            if(integerList.get(i)!=integerList.get(integerList.size()-1-i)){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
