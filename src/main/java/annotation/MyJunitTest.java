package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyJunitTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class junitClass = JunitTest.class;
        Method[] methods = junitClass.getDeclaredMethods();

//        MyJunit myJunit = (MyJunit) junitClass.getAnnotation(MyJunit.class);
//        System.out.println(myJunit.value() + " " + myJunit.count());
        JunitTest junitTest = (JunitTest) junitClass.newInstance();

        for (Method method : methods) {
            if(method.isAnnotationPresent(MyJunit.class)){
                MyJunit junit = method.getAnnotation(MyJunit.class);
                try {
                    String value = junit.value();
                    int count = junit.count();
                    method.invoke(junitTest, value, count);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
