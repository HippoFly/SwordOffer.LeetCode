package com.so.common;

/**
 * 链表节点，包含 random 指针
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode random;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
