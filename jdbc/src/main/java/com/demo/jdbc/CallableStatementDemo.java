package com.demo.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementDemo {

    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub
        Connection conn = null;
        CallableStatement callstmt = null;
        ResultSet rs = null;
        try {
            //注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //通过注册的驱动获得连接对象Connection
            conn = DriverManager
                .getConnection("jdbc:mysql://127.0.0.1:3306/springlab?useUnicode=true&characterEncoding=UTF-8"
                    + "&serverTimezone=UTC&useSSL=false", "root", "");
            //CallableStatement对象
            callstmt = conn.prepareCall("{call p_selectUserByAge(?,?)}");
            callstmt.setInt(1, 25);
            //设置传入参数
            callstmt.registerOutParameter(2, Types.INTEGER);
            rs = callstmt.executeQuery();
            while (rs.next()) {
                System.out.println(
                    "姓名:" + rs.getString("name") + "  年龄:" + rs.getInt("age") + "  出生日期:" + rs.getDouble("money"));
            }
            System.out.println("存储过程返回值:" + callstmt.getInt(2));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            //释放资源
            if (conn != null) {
                conn.close();
            }
            if (callstmt != null) {
                callstmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

}
