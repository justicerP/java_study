package should_handwriting.Singleton;

public class Singleton2 { // 饿汉式

    private Singleton2() {
        // 私有构造函数
    }

    private static Singleton2 s = new Singleton2(); // 持有私有静态实例，仅会初始化一次，但也丢失了延迟实例化带来的节约资源的好处

    public static Singleton2 getInstance() {
        return s;
    }

}
