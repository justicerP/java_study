package should_handwriting.Singleton;

public class Singleton4 { // 懒汉式-线程安全

    private Singleton4() {
        // 私有构造函数
    }

    private static Singleton4 s;

    public synchronized static Singleton4 getInstance() { // 使用synchronized关键字对方法加锁，会让线程阻塞时间过长，性能不够好
        if (s == null) {
            s = new Singleton4();
        }
        return s;
    }

}
