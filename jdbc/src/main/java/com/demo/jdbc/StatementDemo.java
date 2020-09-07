package com.demo.jdbc;

import java.sql.*;

public class StatementDemo {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //通过注册的驱动获得连接对象Connection
            conn = DriverManager
                .getConnection("jdbc:mysql://127.0.0.1:3306/springlab?useUnicode=true&characterEncoding=UTF-8"
                    + "&serverTimezone=UTC&useSSL=false", "root", "");
            //通过Statement对象执行操作 返回结果ResultSet
            stmt = conn.createStatement();
            //返回结果
            rs = stmt.executeQuery("select * from t_user");
            while (rs.next()) {
                System.out.println(
                    "姓名:" + rs.getString("name") + "  年龄:" + rs.getInt("age") + "  余额:" + rs.getDouble("money"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            //释放资源
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

}
