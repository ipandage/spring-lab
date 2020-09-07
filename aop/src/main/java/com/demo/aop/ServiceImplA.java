package com.demo.aop;

public class ServiceImplA implements IService, ITest {

    public void service(String name) throws Exception {
        System.out.println("ServiceImplA service:" + name);
    }

    public void test(String name) throws Exception {
        System.out.println("ServiceImplA test:" + name);

    }
}
