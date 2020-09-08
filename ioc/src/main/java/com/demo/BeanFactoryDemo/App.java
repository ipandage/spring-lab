package com.demo.BeanFactoryDemo;


import com.demo.model.XMLInstance;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.AppConf;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception {
//        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
//        UserBean user = (UserBean) context.getBean("user");
//        user.destroy();
//        ((ClassPathXmlApplicationContext) context).close();

//        ApplicationContext context = new FileSystemXmlApplicationContext(
//            new String[]{"classpath:ApplicationContext.xml"});
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
        BeanFactory factory = context;
        XMLInstance instance = (XMLInstance) factory.getBean("xmlinstance");
        instance.setName("123");
        instance.breath();
        instance = (XMLInstance) factory.getBean("xmlinstance");
        instance.breath();
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
