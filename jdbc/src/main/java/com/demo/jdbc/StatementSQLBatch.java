package com.demo.jdbc;

import java.sql.*;

public class StatementSQLBatch {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;

        ResultSet rs = null;
        Statement stmt = null;
        try {
            //注册驱动
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //通过注册的驱动获得连接对象Connection
            conn = DriverManager
                .getConnection("jdbc:mysql://127.0.0.1:3306/springlab?useUnicode=true&characterEncoding=UTF-8"
                    + "&serverTimezone=UTC&useSSL=false", "root", "");

            stmt = conn.createStatement();
            for (int i = 0; i < 2; i++) {
                String sql =
                    "insert into t_user (name,age,money) values('StatementTest" + i + "'," + 25 + i + ",222.22)";
                stmt.addBatch(sql);
            }
            //批处理
            int[] result = stmt.executeBatch();
            System.out.println("影响的行数分别为:");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + "  ");
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
