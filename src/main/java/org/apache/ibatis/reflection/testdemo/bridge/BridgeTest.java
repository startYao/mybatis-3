package org.apache.ibatis.reflection.testdemo.bridge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * todo 泛型擦除+桥接
 */
public class BridgeTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        AClass obj = new AClass();
        Method func = AClass.class.getMethod("func", String.class);
        func.invoke(obj, "AAA");
        System.out.println(func.isBridge());
        func = AClass.class.getMethod("func", Object.class);
        func.invoke(obj, "BBB");
        System.out.println(func.isBridge());
    }
}


interface AInterface {
    void func(Object t);
}

//新生成的这个方法就是桥接方法
class AClass implements AInterface {
    public void func(String s) {
        System.out.println(s);
    }
    public void func(Object s) {
        this.func((String) s);
    }
}

