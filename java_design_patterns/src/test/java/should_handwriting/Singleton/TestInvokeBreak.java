package should_handwriting.Singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TestInvokeBreak {

    @Test
    public void test() throws Exception {
        // 正常方式获得实例
        Singleton3 instance = Singleton3.getInstance();

        // 反射重新生成实例
        Constructor<Singleton3> constructor = Singleton3.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Field flag = Singleton3.class.getDeclaredField("flag");
        flag.setAccessible(true);
        flag.set(Singleton3.class, true);
        Singleton3 newInstance = constructor.newInstance();

        // 查看是否相等
        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance.equals(newInstance));
        System.out.println(instance == newInstance);
    }

}
