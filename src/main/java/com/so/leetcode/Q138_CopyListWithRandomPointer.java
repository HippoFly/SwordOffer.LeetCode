package com.so.leetcode;

import com.so.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 18:58
 **/

public class Q138_CopyListWithRandomPointer {
    public ListNode copyRandomList(ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        Map<ListNode, ListNode> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }

}
