package com.lance.design.pattern_03_singleton;

/**
 * 在上面的代码中，我们通过在 instance 变量声明前添加 volatile 关键字来确保多线程下的可见性。
 * 在 getInstance() 方法中，我们首先检查 instance 是否已经被初始化，
 * 如果没有，我们就对 Singleton.class 进行同步操作，确保只有一个线程可以进入该同步块。
 * 在进入同步块后，我们再次检查 instance 是否已经被初始化，
 * 如果没有，我们就创建一个新的 Singleton 实例并将其赋值给 instance。
 * <p>
 * 这种双重检查锁定的单例模式实现既能保证线程安全，又能保证性能。
 * 但是，需要注意的是，这种实现方式在 JDK1.5 之前的版本中可能会出现问题
 * ，因为 Java 的内存模型在之前的版本中没有规定 volatile 关键字的语义，
 * 可能导致双重检查锁定失效。
 */
public class Singleton01 {
    private volatile static Singleton01 instance;

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        if (instance == null) {
            synchronized (Singleton01.class) {
                if (instance == null) {
                    instance = new Singleton01();
                }
            }
        }
        return instance;
    }
}


