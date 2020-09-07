package com.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.object.MappingSqlQuery;

public class UserMappingSqlQuery extends MappingSqlQuery<User> {

    @Override
    protected User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId((Integer) rs.getInt("id"));
        user.setName((String) rs.getString("name"));
        user.setAge((Integer) rs.getInt("age"));
        user.setMoney((Double) rs.getDouble("money"));
        return user;
    }

}
