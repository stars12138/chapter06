package com.itheima.user;

import com.itheima.jdbc.Account;
import com.itheima.jdbc.AccountDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void addTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        User user=new User();
        user.setUsername("dom");
        user.setPassword("123456");
        user.setSex("1");
        int num=userDao.addUser(user);
        if (num>0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }
    @Test
    public void updateTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        User user=new User();
        user.setId(1);
        user.setUsername("xxx");
        user.setSex("2");
        int num=userDao.updateUser(user);
        if (num>0){
            System.out.println("修改成功1");
        }else {
            System.out.println("修改失败2");
        }
    }
    @Test
    public void deleteTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        int num=userDao.deleteUser(1);
        if (num>0){
            System.out.println("删除成功1");
        }else {
            System.out.println("删除失败2");
        }
    }
    @Test
    public void findByIdTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        User user=userDao.findUserById(2);
        System.out.println(user);
    }
    @Test
    public void findAllTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        List<User> users=userDao.findUserAll();
        for (User u:users){
            System.out.println(u);
        }
    }
    @Test
    public void CountTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        System.out.println(userDao.Count("test"));
    }
}
