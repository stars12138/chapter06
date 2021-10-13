package com.itheima.user;

import com.itheima.jdbc.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }


    @Override
    public int addUser(User user) {
        String sql="insert into user(username,password,sex) value(?,?,?)";
        Object[] obj=new Object[]{
                user.getUsername(),
                user.getPassword(),
                user.getSex()
        };
        int num=this.jdbcTemplate.update(sql,obj);
        return num;
    }

    @Override
    public int updateUser(User user) {
        String sql="update user set username=?,sex=? where id=?";
        Object[] params=new Object[]{
                user.getUsername(),
                user.getSex(),
                user.getId()
        };
        int num=this.jdbcTemplate.update(sql,params);
        return num;
    }

    @Override
    public int deleteUser(int id) {
        String sql="delete from user where id=?";
        int num=this.jdbcTemplate.update(sql,id);
        return num;
    }

    @Override
    public User findUserById(int id) {
        String sql="select * from user where id=?";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Override
    public List<User> findUserAll() {
        String sql="select * from user";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        return this.jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public int Count(String username) {
        String sql="select count(*) from user where username=?";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{username}, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                int count = 0;
                count=resultSet.getInt(1);
                return count;
            }
        });
    }

}
