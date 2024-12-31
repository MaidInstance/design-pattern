package Patterns;

public class SingletonPattern {
    // Singleton pattern 单例模式
    // 类只能产生一个实例，保证全局使用的是同一对象。

    /*
     * 单例模式有很多种实现方式，双检锁方式、枚举方式、静态内部类方式等，
     * 线程安全：getInstance() 方法中需要使用同步锁 synchronized (Singleton.class)
     *         防止多线程同时进入造成实例被多次创建。
     * 延迟初始化：实例在第一次调用 getInstance() 方法时创建。
     * 序列化和反序列化：重写 readResolve 方法以确保反序列化时不会创建新的实例。
     * 反射攻击：在构造函数中添加防护代码，防止通过反射创建新实例。
     * 类加载器问题：注意复杂类加载环境可能导致的多个实例问题。
     */

    // 等待补充
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
    }
}

// 常规的做法
class Singleton {
    private Singleton() {}

    private static final Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

}

// 双重检查锁
class Singleton2 {
    private Singleton2() {}
    private static volatile Singleton2 instance;
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

// 静态内部类 保证了多线程安全
class Singleton3 {
    private Singleton3() {}

    private static class SingletonHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }
    public static Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}