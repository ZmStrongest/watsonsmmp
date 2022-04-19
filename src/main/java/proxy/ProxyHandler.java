package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler <T> implements InvocationHandler {
    private T target;

    public ProxyHandler(T t){
        this.target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //前置处理
        long startTime = System.currentTimeMillis();

        Object obj = method.invoke(target, args);

        //后置处理
        long endTime = System.currentTimeMillis();
        System.out.println("方法:" + method.getName() + "执行耗时" + (endTime - startTime) + "ms");
        return obj;
    }
}
