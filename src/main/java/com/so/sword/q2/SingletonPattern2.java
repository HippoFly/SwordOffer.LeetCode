package com.so.sword.q2;

/**
 * 第2题 单例设计模式
 * 设计一个类，只能生成该类的一个实例。
 *
 */
public class SingletonPattern2 {}

/**
 * 1.饿汉式：线程安全，耗费资源
 * 场景：
 * 资源共享：当需要在多个模块中共享同一个实例时
 * 全局访问点：作为全局唯一的访问点，例如日志记录器、配置管理器等。
 * 线程安全要求高：饿汉式单例模式在类加载时就创建实例，因此不存在线程安全问题，适合多线程环境下使用。
 * 避免频繁创建销毁：如果创建和销毁实例的代价比较大，可以使用饿汉式单例模式来避免频繁的创建和销毁操作。
 *
 *
 */
class EagerSingleton1 {
    //该对象的引用不可修改
    private static final EagerSingleton1 ourInstance = new EagerSingleton1();
    public static EagerSingleton1 getInstance() {
        return ourInstance;
    }
    private EagerSingleton1() {}
}

/**
 * 2.饿汉式：在静态代码块实例对象
 */
class EagerSingleton2 {
    private static EagerSingleton2 ourInstance;
    static {
        ourInstance = new EagerSingleton2();
    }
    public static EagerSingleton2 getInstance() {
        return ourInstance;
    }
    private EagerSingleton2() {}
}

/**
 * 3.懒汉式：非线程安全
 */
class LazySingleton1 {
    private static LazySingleton1 ourInstance;
    private LazySingleton1() {}
    public static LazySingleton1 getInstance() {
        if (null == ourInstance) {
            ourInstance = new LazySingleton1();
        }
        return ourInstance;
    }
}

/**
 * 4.(线程安全)懒汉式：给方法加锁
 * 过重，因为访问时也要加锁，后面双检查就是为了减轻
 */
class LazySingleton2 {
    private static LazySingleton2 ourInstance;
    public synchronized static LazySingleton2 getInstance() {
        if (null == ourInstance) {
            ourInstance = new LazySingleton2();
        }
        return ourInstance;
    }
    private LazySingleton2() {}
}

/**
 * 5.线程安全的懒汉式：双重检查锁（同步代码块）
 * 为了解决上述查询也要加锁过重的情形
 */
class Singleton3 {
    private static Singleton3 ourInstance;
    public static Singleton3 getInstance() {
        if (null == ourInstance) {
            synchronized (Singleton3.class) {
                if (null == ourInstance) {
                    ourInstance = new Singleton3();
                }
            }
        }
        return ourInstance;
    }
    private Singleton3() {}
}

/**
 * 双私有一公开
 * 6.线程安全的懒汉式：静态内部类（推荐）
 * 静态内部类在被加载时不会立即初始化，只有在第一次使用时才会加载并初始化。
 */
class LazySingleton4 {
    private LazySingleton4() {
    }
    private static class SingletonHolder {
        private static LazySingleton4 ourInstance = new LazySingleton4();
    }
    public static LazySingleton4 getInstance() {
        return SingletonHolder.ourInstance;
    }
}

/**
 * 7.线程安全的懒汉式：枚举
 */
enum Singleton5 {
    INSTANCE;
    public void whateverMethod() {
        // do something
    }
}
