package should_handwriting.Singleton;

public class Singleton3 { // 懒汉式-线程安全-双重校验锁


    private static boolean flag = true; // 用于防御放射，但是也可能被反射修改，见TestInvokeBreak类

    private Singleton3 () { // 私有构造函数
        if (flag){  // 用于防御放射，但是也可能被反射修改，见TestInvokeBreak类
            flag = false;
        }else {
            throw new RuntimeException("对象已存在");
        }
    }

    private static Singleton3 s; // 这种声明方式有漏洞
    // private static volatile Singleton3 s; // 使用volatile关键字的声明才能保证jvm不重排执行顺序

    public static Singleton3 getInstance(){
        if (s == null) {
            synchronized (Singleton3.class) {
                if (s == null) { // 取到锁后的第二次if判断是为了15行保证初始化语句只执行一次
                    s = new Singleton3();
                    /*
                    * 15行初始化不是原子操作，分为：1、为s分配内存；2、初始化Singleton3；3、将s指向2分配的内存空间
                    *
                    * 在jvm语句重排后的实际执行顺序可能为1>3>2
                    *
                    * 若线程a执行顺序为1>3，此时线程b进入12行判断s的指向已经不为null，则执行return语句返回，但此时s的初始化并未完成
                    * */
                }
            }
        }
        return s;
    }

}
