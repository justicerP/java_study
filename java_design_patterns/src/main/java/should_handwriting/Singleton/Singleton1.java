package should_handwriting.Singleton;

public class Singleton1 { // 懒汉式-线程不安全

    private Singleton1() {
        // 私有构造函数
    }

    private static Singleton1 s; // 静态私有成员变量，一个类只有一个

    public static Singleton1 getInstance() { // 共有静态方法获取单例
        if (s == null) { // 线程不安全，多线程访问会实例化多次
            s = new Singleton1();
        }
        return s;
    }

}
