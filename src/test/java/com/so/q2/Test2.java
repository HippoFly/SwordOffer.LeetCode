package com.so.q2;

import org.junit.Test;

/**
 * 第2题 单例设计模式
 * 设计一个类，只能生成该类的一个实例。
 *
 */
public class Test2 {
    @Test
    public void test2() {
        LazySingleton1 singleton = LazySingleton1.getInstance();
        LazySingleton1 singleton2 = LazySingleton1.getInstance();
        System.out.println("使用单例模式获取对象，是否是同一个实例：" + singleton.equals(singleton2));
//        Singleton1 singleton3 = new Singleton1();
//        System.out.println("使用new创建对象，是否是同一个实例：" + singleton.equals(singleton3));
    }
}
