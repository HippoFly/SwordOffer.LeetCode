package com.so.lc.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/3 15:51
 **/

public class Q295_FindMedianFromDataStream {
    PriorityQueue<Integer> queMin = new PriorityQueue<Integer>((a, b) -> (b - a));;
    PriorityQueue<Integer> queMax= new PriorityQueue<Integer>((a, b) -> (a - b));

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
     * queMin从小到大，顶部是小堆的最大
     * queMax从大到大，顶部是大堆的最小
     * 添加的时候，先加小堆，并且**小于中位数**后加入小堆
     *
     *
     *
     * **最关键处
     * （这里通过每次添加过后，判断大堆加1会大于等于小堆的长度）
     * 比如以5,4,3,2,1案例
     * 5先加小堆
     * 4加入时由于 4<5先加小堆，判断小堆超大堆2，则吐出小堆最大给大堆
     * @param num
     *
     */
    public void addNum(int num) {

        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
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
