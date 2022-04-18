package generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GenericDemo {

    public static <T> void f(T x){
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args)  {
        GenericDemo gm = new GenericDemo();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        GenericDemo.f("");
        GenericDemo.f(1);
        try {
            Class c = Class.forName("generic.Cat");
            Cat cat = (Cat)c.newInstance();
            Method method1 = c.getMethod("setName", String.class);
            Method method2 = c.getMethod("setType", String.class);
            Method method3 = c.getMethod("show");
            method1.invoke(cat,"Bobby");
            method2.invoke(cat,"英短");
            method3.invoke(cat);
            System.out.println(cat);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
