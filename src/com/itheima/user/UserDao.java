package com.itheima.user;

import com.itheima.jdbc.Account;

import java.util.List;

public interface UserDao {
    public int addUser(User user);
    public int updateUser(User user);
    public int deleteUser(int id);
    public User findUserById(int id);
    public List<User> findUserAll();
    public int Count(String username);
}
