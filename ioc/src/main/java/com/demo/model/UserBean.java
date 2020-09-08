package com.demo.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserBean implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
    public void setBeanName(String name) {
        System.out.println(name);
    }
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory);
    }
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean被调用");
    }
    public void destroy() throws Exception {
        System.out.println("DisposableBean被调用");
    }
}
