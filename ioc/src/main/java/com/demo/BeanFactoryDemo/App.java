package com.demo.BeanFactoryDemo;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.demo.model.AppConf;
import com.demo.model.Person;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception {
//        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
//        BeanFactory factory = context;
//        UserBean user = (UserBean) context.getBean("user");
//        ((ClassPathXmlApplicationContext) context).close();

//        ApplicationContext context = new FileSystemXmlApplicationContext(
//            new String[]{"classpath:ApplicationContext.xml"});
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
        BeanFactory factory = context;
        Person person = (Person) factory.getBean("person");
        person.breath();

//        AppConf conf = (AppConf) factory.getBean("conf");
//        conf.person().breath();

//    	XMLInstance instance=(XMLInstance)factory.getBean("xmlinstance");
//    	instance.setName("123");
//    	instance.Breath();
//    	instance=(XMLInstance)factory.getBean("xmlinstance");
//    	instance.Breath();
//        test=(XMLInstance)factory.getBean("xmlcontructinstance");
//    	test.Breath();
//        test=(XMLInstance)factory.getBean("xmlfactoryinstance");
//    	test.Breath();
//        test=(XMLInstance)factory.getBean("xmlfactorystaticinstance");
//    	test.Breath();
//    	AnnontationInstance annontationInstance=(AnnontationInstance)factory.getBean("annontationInstance");
//    	annontationInstance.Breath();

    }
}
