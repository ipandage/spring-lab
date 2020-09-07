package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

    public static void main(String[] args) throws SQLException {

        Connection conn = null;

        ResultSet rs = null;
        PreparedStatement prestmt = null;
        try {
            //注册驱动
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //通过注册的驱动获得连接对象Connection
            conn = DriverManager
                .getConnection("jdbc:mysql://127.0.0.1:3306/springlab?useUnicode=true&characterEncoding=UTF-8"
                    + "&serverTimezone=UTC&useSSL=false", "root", "");
            //手动开启事务
            conn.setAutoCommit(false);
            String sql = "update  t_user set money=money-? where id=?";
            prestmt = conn.prepareStatement(sql);

            prestmt.setDouble(1, -111.11);
            prestmt.setInt(2, 2);
            prestmt.addBatch();

            prestmt.setDouble(1, 111.11);
            prestmt.setInt(2, 1);
            prestmt.addBatch();

            //批处理
            prestmt.executeBatch();

            //提交事务
            conn.commit();


        } catch (SQLException e) {
            //事务回滚
            conn.rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            //释放资源
            if (conn != null) {
                conn.close();
            }
            if (prestmt != null) {
                prestmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

}
