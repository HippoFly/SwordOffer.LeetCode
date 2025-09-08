package com.so.leetcode;

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/3 15:51
 **/

public class Q295_FindMedianFromDataStream {
    PriorityQueue<Integer> queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
    ;
    PriorityQueue<Integer> queMax = new PriorityQueue<Integer>((a, b) -> (a - b));

    public static void main(String[] args) {
        Q295_FindMedianFromDataStream twoHeaps = new Q295_FindMedianFromDataStream();
        twoHeaps.addNum(5);
        twoHeaps.addNum(4);
        twoHeaps.addNum(3);
        twoHeaps.addNum(2);
        twoHeaps.addNum(1);
        System.out.println(twoHeaps);
    }

    /**
     * 向数据结构中添加一个数字
     * 使用两个堆来维护数据的有序性：
     * - queMin: 最大堆，保存较小的一半数据
     * - queMax: 最小堆，保存较大的一半数据
     * 保持两个堆的大小平衡，确保queMin的大小要么等于queMax，要么比queMax多1
     *
     * @param num 要添加的数字
     */
    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            // 将num加入较小部分（queMin最大堆）
            queMin.offer(num);
            // 如果较小部分比大部分多出超过1个元素
            if (queMax.size() + 1 < queMin.size()) {
                // 将较小部分的最大值移到大部分中，保持平衡
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            // 如果较大部分的元素个数超过了较小部分
            if (queMax.size() > queMin.size()) {
                // 将较大部分的最小值移到较小部分中，保持平衡
                queMin.offer(queMax.poll());
            }
        }
    }


    public double findMedian() {
        // 奇数返回小堆顶峰
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }

}
