package com.so.sword.q7;

import com.so.sword.q7.DoubleSQueue7;
import org.junit.Test;

/**
 * 第7题
 * Stack -> Queue(FIFO)
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 */
public class Test7 {
    @Test
    public void test7() throws Exception {
        DoubleSQueue7 doubleSQueue7 = new DoubleSQueue7();
        doubleSQueue7.push(2);
        doubleSQueue7.push(5);
        doubleSQueue7.push(8);
        System.out.println("出队列：" + doubleSQueue7.pop());
    }
}
