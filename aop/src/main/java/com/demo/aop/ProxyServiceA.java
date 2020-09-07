package com.demo.aop;

public class ProxyServiceA implements IService {

    public ProxyServiceA(IService service) {
        super();
        this.service = service;
    }

    private IService service;

    public void service(String name) throws Exception {
        System.out.println("log start");
        try {
            service.service(name);
        } catch (Exception e) {
            throw e;
        }
        System.out.println("log end");
    }

    public static void main(String[] args) throws Exception {
        IService service = new ServiceImplA();
        service = new ProxyServiceA(service);
        service.service("CYW");
    }
}
