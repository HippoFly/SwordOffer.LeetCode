package com.so.sword.q8;

import com.so.sword.q8.MinNumber8;
import org.junit.Test;

/**
 * 第8题
 *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 * 输入一个非递减排序数组的一个旋转，输出旋转数组的最小元素。
 */
public class Test8 {
    @Test
    public void test8() throws Exception {
        int[] array = {6, 7, 9, 1, 3, 5, 5};
        System.out.println("旋转数组的最小元素：" + MinNumber8.minInReversingList(array));
        System.out.println("旋转数组的最小元素：" + MinNumber8.minInReversingList2(array));
    }
}
