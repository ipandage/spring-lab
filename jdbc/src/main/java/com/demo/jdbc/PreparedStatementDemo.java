package com.demo.jdbc;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PreparedStatementDemo {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement prestmt = null;
        ResultSet rs = null;
        try {
            //注册驱动
            DriverManager.registerDriver(new Driver());

            //通过注册的驱动获得连接对象Connection
            conn = DriverManager
                .getConnection("jdbc:mysql://127.0.0.1:3306/springlab?useUnicode=true&characterEncoding=UTF-8"
                    + "&serverTimezone=UTC&useSSL=false", "root", "");
            //PreparedStatement对象
            String sql = "insert into t_user (name,age,money) values(?,?,?)";
            prestmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prestmt.setString(1, "小李");
            prestmt.setInt(2, 25);
            prestmt.setDouble(3, 222.22);
            //返回结果
            int result = prestmt.executeUpdate();
            if (result > 0) {
                System.out.println("新增成功");
                rs = prestmt.getGeneratedKeys();
                while (rs.next()) {
                    System.out.println("生成的主键ID为:" + rs.getInt(1));
                }
            }
        } catch (SQLException e) {
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
