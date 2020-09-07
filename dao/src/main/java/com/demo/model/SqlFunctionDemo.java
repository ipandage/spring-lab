package com.demo.model;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.object.SqlFunction;

public class SqlFunctionDemo {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
        BeanFactory factory = context;
        BasicDataSource dataSource = (BasicDataSource) factory.getBean("dataSource");
        SqlFunction sf = new SqlFunction(dataSource, "select count(1) from t_user;");
        sf.compile();
        int count = sf.run();
        System.out.println("User Count:" + count);
    }

}
