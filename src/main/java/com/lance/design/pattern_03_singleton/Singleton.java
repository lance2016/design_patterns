package com.lance.design.pattern_03_singleton;


import java.util.concurrent.atomic.AtomicReference;

/**
* 我们使用了一个 AtomicReference<Singleton> 类型的静态常量 INSTANCE 来保存单例对象。
 * 在 getInstance() 方法中，我们首先使用 INSTANCE.get() 方法获取当前的单例对象
 * ，如果已经被初始化，则直接返回该对象。如果没有被初始化，则使用 new Singleton() 创建一个新的 Singleton 对象，
 * 并使用 INSTANCE.compareAndSet(null, instance) 方法来将其设置为单例对象。
 * 由于 compareAndSet() 方法具有原子性和线程安全性，因此可以确保只有一个线程可以成功设置单例对象。
 */

public class Singleton {
    private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<Singleton>();

    private Singleton() {}

    public static Singleton getInstance() {
        for (;;) {
            Singleton instance = INSTANCE.get();
            if (instance != null) {
                return instance;
            }
            instance = new Singleton();
            if (INSTANCE.compareAndSet(null, instance)) {
                return instance;
            }
        }
    }
}
