package com.so.lc.leetcode;

import java.util.Stack;

/**
 * 155. 最小栈
 * 这道题比较难的思考题目在描述什么状态
 * 比如
 *  push(1)   [1]   min: [1]
 *  push(2)   [1,2]   min: [1]
 *  push(3)   [1,3,3]   min: [1] 其实这里这三个都对应最小1
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-24 16:40
 */
public class Q155_MinStack {

    // 主栈
    private Stack<Integer> stack=new Stack<>();
    // 辅助栈，用于存储最小值
    private Stack<Integer> minStack=new Stack<>();


    /**
     * 将元素 x 推入栈中
     */
    public void push(int x) {
        stack.push(x);
        // 如果辅助栈为空，或者当前元素小于等于辅助栈栈顶，则压入辅助栈
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    /**
     * 删除栈顶的元素
     */
    public void pop() {
        int poppedElement = stack.pop();
        // 如果弹出的元素是当前最小值，则同步弹出辅助栈的栈顶
        if (poppedElement == minStack.peek()) {
            minStack.pop();
        }
    }

    /**
     * 获取栈顶元素
     */
    public int top() {
        return stack.peek();
    }

    /**
     * 检索栈中的最小元素
     */
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Q155_MinStack minStack = new Q155_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("最小值: " + minStack.getMin()); // 输出 -3
        minStack.pop();
        System.out.println("栈顶元素: " + minStack.top()); // 输出 0
        System.out.println("最小值: " + minStack.getMin()); // 输出 -2
    }
}
