package com.demo.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaProxyServiceA implements InvocationHandler {

    private Object target;

    public Object bind(Object object) {
        this.target = object;
        Object obj = Proxy
            .newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
        return obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println(proxy.getClass().getName());
        System.out.println("method:" + method);
        System.out.println("args:" + args);
        System.out.println("target:" + this.target);
        System.out.println("log start");
        try {
            result = method.invoke(this.target, args);
        } catch (Exception e) {
            throw e;
        }
        System.out.println("log end");
        return proxy;
    }

    public static void main(String[] args) throws Exception {
        IService service = (IService) new DynaProxyServiceA().bind(new ServiceImplA());
        service.service("CYW");
    }

}
