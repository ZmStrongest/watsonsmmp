package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyService {

    public static <T> T getProxy(T t) {
        ProxyHandler handler = new ProxyHandler(t);
        Object proxyClass =  Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), handler);
        return (T) proxyClass;
    }

}
