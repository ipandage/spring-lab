package com.demo.model;

import java.util.*;

public interface IUserDAO {

    public List<User> queryAllUser();

    public Boolean addUser(User user);

    public Boolean transfer(int fromUserId, int toUserId, float transferMoney);

}
