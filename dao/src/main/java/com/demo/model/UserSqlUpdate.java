package com.demo.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class UserSqlUpdate extends SqlUpdate {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
        BeanFactory factory = context;
        UserSqlUpdate userSqlUpdate = (UserSqlUpdate) factory.getBean("userSqlUpdate");
        userSqlUpdate.updateUserMoney("小李", 666.66);
    }

    public UserSqlUpdate(DataSource ds) {
        setDataSource(ds);
        setSql("update t_user set money=? where name=?");
        declareParameter(new SqlParameter(java.sql.Types.DOUBLE));
        declareParameter(new SqlParameter(java.sql.Types.VARCHAR));
        compile();
    }

    public Boolean updateUserMoney(String name, double money) {
        int row = update(new Object[]{new Double(money), new String(name)});
        if (row > 0) {
            System.out.println("数据新增成功!");
            return true;
        }
        return false;
    }

}
