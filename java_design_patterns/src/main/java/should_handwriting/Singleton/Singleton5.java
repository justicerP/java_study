package should_handwriting.Singleton;

public class Singleton5 { // 懒汉模式-静态内部类实现

    private Singleton5() {
        // 私有构造函数
    }

    private static class SingletonHolder { // Singleton4类被加载时，SingletonHolder不会被加载
        private static Singleton5 SINGLETON = new Singleton5(); // 只可能实例化一次，而且不会在Singleton5对象加载时加载，而是在getInstance方法首次调用时加载
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.SINGLETON; // 调用此语句时，SingletonHolder才被加载
    }

}
