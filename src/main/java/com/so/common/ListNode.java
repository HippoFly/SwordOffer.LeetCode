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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append("->");
            }
            current = current.next;
        }
        return sb.toString();
    }

    /**
     * 静态方法：打印链表
     */
    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append("->");
            }
            current = current.next;
        }
        return sb.toString();
    }

}
