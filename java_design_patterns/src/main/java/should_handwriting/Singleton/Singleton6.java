package should_handwriting.Singleton;

public enum Singleton6 {

    INSTANCE;

    private String name;

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Singleton6 first = Singleton6.INSTANCE;
        first.setName("first");
        System.out.println(first.getName());
        Singleton6 second = Singleton6.INSTANCE;
        second.setName("second");
        System.out.println(first.getName());

        System.out.println("********************************************************************************");

        System.out.println(first.getName());
        System.out.println(second.getName());

        System.out.println("********************************************************************************");

        Singleton6[] enumConstants = Singleton6.class.getEnumConstants();
        for (Singleton6 enumConstant : enumConstants) {
            System.out.println(enumConstant.getName());
        }
    }

    /*
    *
    * 该实现可以防止反射攻击。
    * 在其它实现中，通过 setAccessible() 方法可以将私有构造函数的访问级别设置为 public，然后调用构造函数从而实例化对象，如果要防止这种攻击，需要在构造函数中添加防止多次实例化的代码。
    * 该实现是由 JVM 保证只会实例化一次，因此不会出现上述的反射攻击。
    * 该实现在多次序列化和反序列化之后，不会得到多个实例。而其它实现需要使用 transient 修饰所有字段，并且实现序列化和反序列化的方法。
    * 见：https://github.com/CyC2018/CS-Notes/blob/master/notes/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F.md#1-%E5%8D%95%E4%BE%8Bsingleton
    *
    * */

    /*
    *
    * 关于支持序列化，需要实现Serializable方法，但是实现该方法会在反序列化时通过反射调用无参构造函数实例化，这样就破坏了单例
    * 见：https://www.hollischuang.com/archives/1144
    *
    * */

}
