package com.demo.model;

import java.util.*;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SpringDAODemo extends JdbcDaoSupport implements IUserDAO {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
        BeanFactory factory = context;
       /* IUserDAO userDao=(IUserDAO)factory.getBean("userDaoProxy");
        try
        {
          userDao.transfer(1, 2, 100);
        }
        catch(Exception e)
        {
        	System.out.println("����ع�");
        }*/

        IUserDAO userDao = (IUserDAO) factory.getBean("userDao");
        User user = new User("JdbcDaoSupportTest", 26, 333.33);
        userDao.addUser(user);
        List<User> list = userDao.queryAllUser();
        for (User u : list) {
            System.out.println(u.toString());
        }
    }

    public List<User> queryAllUser() {
        String sql = "select id,name,age,money from t_user where ?";
        UserMappingSqlQuery userQuery = new UserMappingSqlQuery();
        userQuery.setDataSource(getDataSource());
        userQuery.setSql(sql);
        userQuery.setParameters(new SqlParameter(java.sql.Types.VARCHAR));
        userQuery.compile();
        return userQuery.execute(new Object[]{new String("1=1")});
    }

//	public List<User> QueryAllUser() {
//        String sql="select id,name,age,money from t_user order by id desc";
//        List<Map<String,Object>> list=getJdbcTemplate().queryForList(sql);
//        List<User> userList=new ArrayList<User>();
//        for(Map<String,Object> row:list)
//        {
//            User user=new User();
//            user.setId((Integer)row.get("id"));
//            user.setName((String)row.get("name"));
//            user.setAge((Integer)row.get("age"));
//            user.setMoney(Double.parseDouble(row.get("money").toString()));
//            userList.add(user);
//        }
//        return userList;
//
//	}

    public Boolean addUser(User user) {
        String sql = "insert into t_user (name,age,money) values (?,?,?)";
        int row = getJdbcTemplate().update(sql, new Object[]{user.getName(), user.getAge(), user.getMoney()});
        if (row > 0) {
            System.out.println("数据新增成功!");
            return true;
        }
        return false;
    }

    public Boolean transfer(int fromUserId, int toUserId, float transferMoney) {

        Boolean out = outInMoney(fromUserId, -transferMoney);
        int i = 1 / 0; //����ع�
        Boolean in = outInMoney(toUserId, transferMoney);

        return out & in;
    }

    private Boolean outInMoney(int toUserId, float money) {
        String sql = "update  t_user set money=money+? where id=? ";
        int row = getJdbcTemplate().update(sql, new Object[]{money, toUserId});
        if (row > 0) {
            return true;
        }
        return false;
    }

}
